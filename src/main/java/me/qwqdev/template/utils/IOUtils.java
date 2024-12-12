package me.qwqdev.template.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

/**
 * I/O 工具类。
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2023/10/9
 */
@UtilityClass
public class IOUtils {
    /**
     * 获取指定文件夹内的所有文件，包括子文件夹。
     *
     * @param folderPath 文件夹路径
     * @return 包含所有文件的并发链接队列 files
     */
    public static Queue<File> getFiles(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.isDirectory()) {
            return new ConcurrentLinkedQueue<>();
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return new ConcurrentLinkedQueue<>();
        }

        return Stream.of(files)
                .flatMap(file -> file.isFile() ? Stream.of(file) : getFiles(file.getAbsolutePath()).stream())
                .collect(ConcurrentLinkedQueue::new, ConcurrentLinkedQueue::offer, ConcurrentLinkedQueue::addAll);
    }

    /**
     * 获取最终文件名。
     *
     * @param name      文件名
     * @param extension 文件拓展名
     * @return 包含后缀的最终文件名 final file name
     */
    public static String getFinalFileName(String name, String extension) {
        return name.endsWith(extension) ? name : name + extension;
    }

    /**
     * Copy files.
     *
     * @param source the source
     * @param target the target
     * @throws java.io.IOException the io exception
     */
    public static void copyFiles(String source, String target) throws IOException {
        File sourceFile = new File(source);
        File targetFile = new File(target);

        if (!sourceFile.exists()) {
            throw new IOException("Source file does not exist");
        }

        if (targetFile.isDirectory()) {
            targetFile = new File(targetFile, sourceFile.getName());
        }

        if (sourceFile.isDirectory()) {
            FileUtils.copyDirectory(sourceFile, targetFile);
        } else {
            FileUtils.copyFile(sourceFile, targetFile);
        }
    }

    /**
     * Is directory exist boolean.
     *
     * @param dirPath the dir path
     * @return the boolean
     */
    public static boolean isDirectoryExist(String dirPath) {
        File directory = new File(dirPath);
        return directory.exists() && directory.isDirectory();
    }

    /**
     * Delete all files in directory.
     *
     * @param dirPath the dir path
     * @throws java.io.IOException the io exception
     */
    public static void deleteAllFilesInDirectory(String dirPath) throws IOException {
        File directory = new File(dirPath);

        if (isDirectoryExist(dirPath)) {
            FileUtils.deleteDirectory(directory);
        } else {
            throw new IllegalArgumentException("The provided path is not a valid directory");
        }
    }
}