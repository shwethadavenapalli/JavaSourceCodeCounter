package com.commentCounter.app;

import com.commentCounter.exception.SourceCodeCounterException;
import com.commentCounter.model.SourceCodeCounter;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by nelso on 12-11-2018.
 */
public class CommentProcessorTest {

   /* @Test(expected = SourceCodeCounterException.class)
    public void testProcessFileWhenFileTypeIsNotMentioned() throws SourceCodeCounterException, IOException {
        SourceCodeCounter commentCounter =
                new SourceCodeCounter.SourceCodeCounterBuilder().setCountSingleLines(true).build();
        SourceCodeProcessor commentProcessor = new SourceCodeProcessor(commentCounter);
        String fileName = "javaProg.java";
        commentProcessor.processFile(fileName);

    }

    @Test(expected = SourceCodeCounterException.class)
    public void testProcessFileWhenTypeOfCommentToCountIsNotMentioned() throws SourceCodeCounterException, IOException {
        SourceCodeCounter commentCounter =
                new SourceCodeCounter.SourceCodeCounterBuilder().setCountJava(true).build();
        SourceCodeProcessor commentProcessor = new SourceCodeProcessor(commentCounter);
        String fileName = "javaProg.java";
        commentProcessor.processFile(fileName);
    }

    @Test(expected = SourceCodeCounterException.class)
    public void testProcessFileWhenGiveNFileIsNonJavaButSpecifiedRequestAsJavaCount() throws SourceCodeCounterException, IOException {
        SourceCodeCounter commentCounter =
                new SourceCodeCounter.SourceCodeCounterBuilder().setCountJava(true).build();
        SourceCodeProcessor commentProcessor = new SourceCodeProcessor(commentCounter);
        String fileName = "SingleLineComment.cpp";
        commentProcessor.processFile(fileName);
    }


    @Test
    public void testProcessFileWhenGiveNFileHasOnlySingleLineComments() throws SourceCodeCounterException, IOException {
        SourceCodeCounter commentCounter =
                new SourceCodeCounter.SourceCodeCounterBuilder()
                        .setCountJava(true)
                        .setCountSingleLines(true)
                        .build();
        SourceCodeProcessor commentProcessor = new SourceCodeProcessor(commentCounter);
        String fileName = "javaPrg2.java";
        commentProcessor.processFile(fileName);
    }*/
}