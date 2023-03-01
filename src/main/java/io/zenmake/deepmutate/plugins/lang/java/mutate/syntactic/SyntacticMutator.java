package io.zenmake.deepmutate.plugins.lang.java.mutate.syntactic;

import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;
import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationWriter;
import io.zenmake.deepmutate.plugins.common.interfaces.Mutator;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class SyntacticMutator implements Mutator {

    private final InputReader inputReader;

    private final MutationWriter outputWriter;


    private SyntacticMutator(InputReader inputReader, MutationWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public static Mutator create(InputReader inputReader, MutationWriter outputWriter) {
        return new SyntacticMutator(inputReader, outputWriter);
    }

    @Override
    public void mutate(ProjectDecl project) {
        throw new UnsupportedOperationException("SyntacticMutator not implemented.");
    }

}
