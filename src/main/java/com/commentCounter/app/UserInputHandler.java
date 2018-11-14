package com.commentCounter.app;

import com.commentCounter.exception.SourceCodeCounterException;
import com.commentCounter.model.SourceCodeCounter;

/**
 * Created by nelso on 11-11-2018.
 */
public class UserInputHandler {
    private SourceCodeCounter sourceCodeCounter;

    public UserInputHandler(SourceCodeCounter commentCounter) {
        this.sourceCodeCounter = commentCounter;
    }

    public void checkAllStates() throws SourceCodeCounterException {
        if (sourceCodeCounter.isCountJava() == false) throw
                new SourceCodeCounterException("Which type of programs comment line to count is not specified");
        if (sourceCodeCounter.isIgnoreSingleLineComments() && sourceCodeCounter.isIgnoreMultiLineComments()) throw new
                SourceCodeCounterException("Which type of comment to ignore is not specified");
    }
}
