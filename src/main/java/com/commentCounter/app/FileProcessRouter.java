package com.commentCounter.app;

import com.commentCounter.exception.SourceCodeCounterException;
import com.commentCounter.model.SourceCodeCounter;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by nelso on 12-11-2018.
 */
public interface FileProcessRouter {


    String replaceCommentsWithBlanks(String filePath) throws IOException, SourceCodeCounterException;

    boolean isValidFileType(String filePath) throws SourceCodeCounterException;

    default int countLines(String filePath) throws SourceCodeCounterException, IOException {
        if (!isValidFileType(filePath)) throw new SourceCodeCounterException("Invalid file type");

        String fileContent = getContentsFromClassPath(filePath);
        if (fileContent == null || fileContent.trim().length() == 0)
            throw new SourceCodeCounterException("No contents are available in file!!");

        String finalSourceCode = replaceCommentsWithBlanks(fileContent);

        return finalSourceCode.split("\n").length;

    }

    static FileProcessRouter getFileProcessor(SourceCodeCounter commentCounter) {

        if (commentCounter.isCountJava())
            return new JavaFileProcessor(commentCounter);

        return null;
    }

    default Optional<String> getExtention(String filePath) {

        return Optional.ofNullable(filePath)
                .filter(file -> file.contains("."))
                .map(file -> file.substring(file.lastIndexOf(".") + 1));
    }

    default void checkFileSize(File file) throws SourceCodeCounterException {

        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            throw new SourceCodeCounterException("File size so big for scanning ! -> " + file.getAbsolutePath());
        }
    }

    default StringBuilder getFileContent(String filePath) throws IOException {
        BufferedReader br = null;
        StringBuilder content = null;
        try {
            File file = new File(filePath);
            content = new StringBuilder((int) file.length());

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
                content.append(temp).append("\n");
            }
            br.close();
        } finally {
            br.close();
        }
        return content;
    }


    default String getContentsFromClassPath(String fileName) throws IOException {
        StringBuilder contentBuilder = null;
        try {
            ClassLoader classLoader = FileProcessRouter.class.getClassLoader();
            URL resource = classLoader.getResource(fileName);
            if (resource == null) throw new FileNotFoundException();
            File file = new File(resource.getFile());
            contentBuilder = new StringBuilder((int) file.length());
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    line = line + "\n";
                    System.out.print(line);
                    contentBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(contentBuilder);
    }

}
