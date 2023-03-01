package io.zenmake.deepmutate.plugins.common.factories.mutator;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.factories.io.InputReaderFactory;
import io.zenmake.deepmutate.plugins.common.factories.io.MutationIOFactory;
import io.zenmake.deepmutate.plugins.common.interfaces.Mutator;
import io.zenmake.deepmutate.plugins.lang.java.mutate.semantic.SemanticMutator;
import io.zenmake.deepmutate.plugins.lang.java.mutate.syntactic.SyntacticMutator;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class JavaMutatorFactory extends AbstractMutatorFactory {

    public JavaMutatorFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        super(projectConf, inputConf, outputConf);
    }

    @Override
    public Mutator getMutator(String type) {
        var inputReader = InputReaderFactory.getReader(this.inputConf, this.projectConf);
        var mutationWriter = MutationIOFactory.getWriter(this.outputConf);

        return switch (type) {
            case ProjectConf.MUTATION_TYPE_SEMANTIC -> SemanticMutator.create(inputReader, mutationWriter);
            case ProjectConf.MUTATION_TYPE_SYNTACTIC -> SyntacticMutator.create(inputReader, mutationWriter);
            default -> {
                throw new UnsupportedOperationException("No mutator found for type: " + type);
            }
        };
    }

}

