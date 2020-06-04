package org.company.forward.domain.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * @author wangjian
 * @date 2020/6/1 0001 11:15
 */
public class FileStreamAnalizy {

    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader(new File("1.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        lineNumberReader.getLineNumber();
    }
}
