package io.zenmake.deepmutate.plugins.io.db.file;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;
import org.apache.commons.lang3.NotImplementedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Talal Ahmed on 28/02/2023
 */
public class SimpleFile implements MutationIO {

    private final File file;

    private FileWriter writer;

    private SimpleFile(String filePath) {
        this.file = new File(filePath);
    }

    public static SimpleFile SimpleFile(String filePath) {
        var file = new SimpleFile(filePath);
        file.init();
        return file;
    }

    public void init() {
        try {
            this.writer = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Mutation mutation) {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }

    @Override
    public void replace(Mutation mutation) {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> iterator() {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }

    @Override
    public void close() {
        throw new NotImplementedException("SimpleFile operations not implemented yet.");
    }
}
