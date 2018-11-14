package com.commentCounter.model;

public final class SourceCodeCounter {

    private boolean countJava;
    private boolean ignoreToDos;
    private boolean ignoreMultiLineComments;
    private boolean ignoreSingleLineComments;
    private boolean ignoreJavaClassHeadersComments;
    private boolean ignoreCopyRightHeadersComments;


    private SourceCodeCounter(SourceCodeCounterBuilder commentRemoverBuilder) {
        this.countJava = commentRemoverBuilder.countJava;
        this.ignoreToDos = commentRemoverBuilder.ignoreToDos;
        this.ignoreMultiLineComments = commentRemoverBuilder.ignoreMultiLineComments;
        this.ignoreSingleLineComments = commentRemoverBuilder.ignoreSingleLineComments;
        this.ignoreJavaClassHeadersComments = commentRemoverBuilder.ignoreJavaClassHeadersComments;
        this.ignoreCopyRightHeadersComments = commentRemoverBuilder.ignoreCopyRightHeadersComments;
    }

    public boolean isCountJava() {
        return countJava;
    }

    public boolean isIgnoreToDos() {
        return ignoreToDos;
    }

    public boolean isIgnoreMultiLineComments() {
        return ignoreMultiLineComments;
    }

    public boolean isIgnoreSingleLineComments() {
        return ignoreSingleLineComments;
    }

    public boolean isIgnoreJavaClassHeadersComments() {
        return ignoreJavaClassHeadersComments;
    }

    public boolean isIgnoreCopyRightHeadersComments() {
        return ignoreCopyRightHeadersComments;
    }

    public static class SourceCodeCounterBuilder {

        private boolean countJava;
        private boolean ignoreToDos;
        private boolean ignoreMultiLineComments;
        private boolean ignoreSingleLineComments;
        private boolean ignoreJavaClassHeadersComments;
        private boolean ignoreCopyRightHeadersComments;

        public SourceCodeCounterBuilder setCountJava(boolean countJava) {
            this.countJava = countJava;
            return this;
        }

        public SourceCodeCounterBuilder setIgnoreToDos(boolean ignoreToDos) {
            this.ignoreToDos = ignoreToDos;
            return this;
        }

        public SourceCodeCounterBuilder setIgnoreMultiLineComments(boolean ignoreMultiLineComments) {
            this.ignoreMultiLineComments = ignoreMultiLineComments;
            return this;
        }

        public SourceCodeCounterBuilder setIgnoreSingleLineComments(boolean ignoreSingleLineComments) {
            this.ignoreSingleLineComments = ignoreSingleLineComments;
            return this;
        }

        public SourceCodeCounterBuilder setIgnoreJavaClassHeadersComments(boolean ignoreJavaClassHeadersComments) {
            this.ignoreJavaClassHeadersComments = ignoreJavaClassHeadersComments;
            return this;
        }

        public SourceCodeCounterBuilder setIgnoreCopyRightHeadersComments(boolean ignoreCopyRightHeadersComments) {
            this.ignoreCopyRightHeadersComments = ignoreCopyRightHeadersComments;
            return this;
        }

        public SourceCodeCounter build() {
            return new SourceCodeCounter(this);
        }
    }

    @Override
    public String toString() {
        return "SourceCodeCounter{" +
                "countJava=" + countJava +
                ", ignoreToDos=" + ignoreToDos +
                ", ignoreMultiLineComments=" + ignoreMultiLineComments +
                ", ignoreSingleLineComments=" + ignoreSingleLineComments +
                ", ignoreJavaClassHeadersComments=" + ignoreJavaClassHeadersComments +
                ", ignoreCopyRightHeadersComments=" + ignoreCopyRightHeadersComments +
                '}';
    }
}
