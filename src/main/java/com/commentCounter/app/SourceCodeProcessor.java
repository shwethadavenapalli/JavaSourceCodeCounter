package com.commentCounter.app;

import com.commentCounter.exception.SourceCodeCounterException;
import com.commentCounter.model.SourceCodeCounter;

import java.io.IOException;

/**
 * Created by nelso on 11-11-2018.
 */
public class SourceCodeProcessor {

    private SourceCodeCounter sourceCodeCounter;
    private UserInputHandler userInputHandler;

    public SourceCodeProcessor(SourceCodeCounter sourceCodeCounter) {
        this.sourceCodeCounter = sourceCodeCounter;
        userInputHandler = new UserInputHandler(sourceCodeCounter);
    }

    public int processFile(String filePath) throws SourceCodeCounterException, IOException {
        userInputHandler.checkAllStates();
        FileProcessRouter fileProcessor = FileProcessRouter.getFileProcessor(sourceCodeCounter);
        return fileProcessor.countLines(filePath);
    }

}
