package io.zenmake.deepmutate.plugins.io.input;

import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.model.Codebase;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public class JavaDirReader implements InputReader {

    public static final String TYPE_DIR = "dir";
    public static final String FORMAT_JAVA = "java";

    public static final String JAVA_SRC_DIR_PATH = "/src/main/java";
    public static final String JAVA_TEST_DIR_PATH = "/src/test/java";

    private final Map<String, String> dirs;
    private final List<String> formats;

    private record FileRecord(String id, String rootDir, String srcDir, String filename, String filepath) {
    }

    private JavaDirReader(Map<String, String> dirs) {
        this.dirs = dirs;
        this.formats = List.of(FORMAT_JAVA);
    }

    public static JavaDirReader create(Map<String, String> dirs) {
        return new JavaDirReader(dirs);
    }

    @Override
    public Iterator<Codebase> iterator() {
        return this.dirs.entrySet()
                .stream()
                .flatMap(x -> files(x.getKey(), x.getValue(), x.getValue() + JAVA_SRC_DIR_PATH).stream())
                .map(x -> read(x.id, x.rootDir, x.filepath))
                .iterator();
    }

    private Set<FileRecord> files(String id, String rootDir, String srcDir) {
        Set<FileRecord> fileRecords = new HashSet<>();
        try {
            Files.walkFileTree(Paths.get(srcDir), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (!Files.isDirectory(file) && checkFormat(file)) {
                        var filename = file.getFileName().toString();
                        var filepath = file.toFile().getAbsolutePath();
                        fileRecords.add(new FileRecord(id, rootDir, srcDir, filename, filepath));
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileRecords;
    }

    private Codebase read(String id, String dirPath, String filepath) {
        var codebase = new Codebase(id, TYPE_DIR, dirPath, filepath);

        try {
            var content = Files.readString(Path.of(filepath));
            codebase.setContent(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return codebase;
    }

    private boolean checkFormat(Path file) {
        var ext = FilenameUtils.getExtension(file.getFileName().toString());
        return this.formats.contains(ext);
    }

}
