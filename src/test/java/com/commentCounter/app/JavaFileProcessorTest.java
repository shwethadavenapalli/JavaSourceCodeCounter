package com.commentCounter.app;

import com.commentCounter.model.SourceCodeCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nelso on 12-11-2018.
 */
public class JavaFileProcessorTest {

    @Test
    public void testToReplaceOnlySingleLineComment() {
        SourceCodeCounter sourceCodeCounter = new SourceCodeCounter.
                SourceCodeCounterBuilder().
                setCountJava(true)
                .setIgnoreCopyRightHeadersComments(true)
                .setIgnoreJavaClassHeadersComments(true)
                .build();
        JavaFileProcessor javaFileProcessor = new JavaFileProcessor(sourceCodeCounter);
        String program = "//Single Line Comment\n" +
                "public class Comment {\n" +
                "    public static void main(String args[]) {\n" +
                "        int a, b; // Local\n" +
                "        System.out.println(\"Comments//\");\n" +
                "    }\n" +
                "}";
        String actualResult = javaFileProcessor.replaceCommentsWithBlanks(program);
        String expectedResult = "public class Comment {\n" +
                "    public static void main(String args[]) {\n" +
                "        int a, b; // Local\n" +
                "        System.out.println(\"Comments//\");\n" +
                "    }\n" +
                "}";
        assertEquals(actualResult, expectedResult);
    }
}