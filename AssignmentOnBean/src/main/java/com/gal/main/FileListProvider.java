package com.gal.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileListProvider {

    @Autowired
    @Qualifier("dirToSearch")
    private String dirToSearch;

    public List<File> getFileJava() {

        List<File> javaFiles = new ArrayList<>();
        File directory = new File(dirToSearch);
        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            for (File f : allFiles) {
            	System.out.println("hii");
            	System.out.println(f.getName());
                if (f.getName().endsWith(".java")) {
                    javaFiles.add(f);
                }
            }
        }
        return javaFiles;
    }
}
