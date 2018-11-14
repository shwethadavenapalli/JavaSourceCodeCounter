package com.commentCounter.app;

import com.commentCounter.exception.SourceCodeCounterException;
import com.commentCounter.model.SourceCodeCounter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nelso on 12-11-2018.
 */
public class JavaFileProcessor implements FileProcessRouter {

    private SourceCodeCounter sourceCodeCounter;

    private static final String regex;

    static {
        regex = "(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/|[\\t]*//.*)|\"(\\\\.|[^\\\\\"])*\"|'(\\\\[\\s\\S]|[^'])*'";
    }


    public JavaFileProcessor(SourceCodeCounter sourceCodeCounter) {
        this.sourceCodeCounter = sourceCodeCounter;
    }


    public boolean isValidFileType(String filePath) throws SourceCodeCounterException {
        Optional<String> fileExtensionOption = getExtention(filePath);

        if (!fileExtensionOption.get().equalsIgnoreCase("java")) {
            throw new
                    SourceCodeCounterException("Invalid file type provided for Java source code line file processor");
        }
        return true;
    }


    public String replaceCommentsWithBlanks(String fileContent) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileContent);

        boolean countMultiLines = !sourceCodeCounter.isIgnoreMultiLineComments();
        boolean countSingleLines = !sourceCodeCounter.isIgnoreSingleLineComments();
        boolean countCopyRightHeaders = !sourceCodeCounter.isIgnoreCopyRightHeadersComments();
        boolean countJavaClassHeaders = !sourceCodeCounter.isIgnoreJavaClassHeadersComments();

        while (matcher.find()) {
            String foundToken = matcher.group();
            if (isDoubleOrSingleQuoteToken(foundToken)) continue;
            if (countSingleLines && isSingleLineCommentFound(foundToken)) continue;
            if (countCopyRightHeaders && isCopyRightHeaderCommentFound(foundToken)) continue;
            if (countMultiLines && isMultiLineCommentFound(foundToken)) continue;
            if (countJavaClassHeaders && isAuthorCommentFound(foundToken)) continue;
            fileContent = fileContent.replaceFirst(Pattern.quote(foundToken), "");
        }
        System.out.println("final java code " + fileContent);
        return fileContent;
    }

    private boolean isCopyRightHeaderCommentFound(String foundToken) {
        return Pattern.compile(Pattern.quote("copyright"), Pattern.CASE_INSENSITIVE).matcher(foundToken).find();
    }

    private boolean isAuthorCommentFound(String foundToken) {
        return Pattern.compile(Pattern.quote("author"), Pattern.CASE_INSENSITIVE).matcher(foundToken).find();
    }


    private boolean isMultiLineCommentFound(String foundToken) {
        return foundToken.startsWith("/*");
    }

    private boolean isSingleLineCommentFound(String foundToken) {
        return (foundToken.startsWith("//"));
    }

    private boolean isDoubleOrSingleQuoteToken(String foundToken) {
        return foundToken.startsWith("\"") || foundToken.startsWith("\'");
    }


}