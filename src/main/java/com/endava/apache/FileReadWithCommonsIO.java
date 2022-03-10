package com.endava.apache;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileReadWithCommonsIO {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/file.txt");
        List lines = FileUtils.readLines(file, "UTF-8");
        System.out.println(FileUtils.readLines(file, Charset.defaultCharset()));
        System.out.println(lines);
    }
}
