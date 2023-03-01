package io.zenmake.deepmutate;

import io.zenmake.deepmutate.lang.parser.DeepMutateParser;
import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;
import io.zenmake.deepmutate.plugins.common.factories.analyzer.AnalyzerFactoryProducer;
import io.zenmake.deepmutate.plugins.common.factories.mutator.MutatorFactoryProducer;
import io.zenmake.deepmutate.plugins.common.factories.report.ReportGeneratorFactory;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class DeepMutate {

    private static final Logger log = LoggerFactory.getLogger(DeepMutate.class);

    public static void main(String[] args) throws ParseException, IOException {
        var runOpt = Option.builder("R").argName("dm filepath").longOpt("run").hasArg().type(String.class).desc("Run deep-mutate code").build();
        var testOpt = Option.builder("t").longOpt("test").desc("Run deep-mutate sample tests").build();
        var helpOpt = Option.builder("h").longOpt("help").required(false).hasArg(false).build();

        var header = "\nOptions, flags and arguments may be in any order";
        var footer = "\nDeepMutate project: https://github.com/talalzone/DeepMutate";
        var options = new Options().addOption(runOpt).addOption(testOpt).addOption(helpOpt);
        var formatter = new HelpFormatter();

        var command = new DefaultParser().parse(options, args);
        if (command.hasOption(runOpt)) {
            var dslPath = command.getParsedOptionValue(runOpt);
            run((String) dslPath);
        } else if (command.hasOption(helpOpt)){
            formatter.printHelp("DeepMutate", header, options, footer, true);
        }else {
            formatter.printHelp("DeepMutate", header, options, footer, true);
        }
    }

    public static void run(String dslPath) throws IOException {
        var cu = DeepMutateParser.parse(dslPath);

        for (ProjectDecl project : cu.getProjectDeclList()) {
            // Configurations
            var projectConf = project.getProjectConf();
            var inputConf = project.getInputConf();
            var outputConf = project.getOutputConf();

            // Mutate
            var mutatorFactory = MutatorFactoryProducer.getFactory(projectConf, inputConf, outputConf);
            var mutator = mutatorFactory.getMutator(projectConf.getMutationType());
            mutator.mutate(project);

            // Analyze
            if (projectConf.performAnalysis()) {
                var analyzerFactory = AnalyzerFactoryProducer.getFactory(projectConf, inputConf, outputConf);
                var analyzer = analyzerFactory.getAnalyzer(projectConf.getMutationType());
                inputConf.getContentIds().forEach(x -> analyzer.analyze((String) x));
            }

            // Generate Report
            if (outputConf.generateReport()) {
                var reportGenerator = ReportGeneratorFactory.getGenerator(outputConf);
                inputConf.getContentIds().forEach(x -> reportGenerator.generate((String) x));
            }
        }
    }
}
