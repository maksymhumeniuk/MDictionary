package ua.com.mdictionary.datalayer.network.response;


import java.util.List;

public class LessonsResponse {

    private String title;
    private String description;
    private int drowableRess;
    private List <String> dictionaryWords;

    private LessonsResponse(Builder builder) {
        title = builder.title;
        description = builder.description;
        drowableRess = builder.drowableRess;
        dictionaryWords = builder.dictionaryWords;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDrowableRess() {
        return drowableRess;
    }

    public List<String> getDictionaryWords() {
        return dictionaryWords;
    }

    /**
     * {@code LessonsResponse} builder static inner class.
     */
    public static final class Builder {
        private String title;
        private String description;
        private int drowableRess;
        private List<String> dictionaryWords;

        public Builder() {
        }

        /**
         * Sets the {@code title} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code title} to set
         * @return a reference to this Builder
         */
        public Builder title(String val) {
            title = val;
            return this;
        }

        /**
         * Sets the {@code description} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code description} to set
         * @return a reference to this Builder
         */
        public Builder description(String val) {
            description = val;
            return this;
        }

        /**
         * Sets the {@code drowableRess} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code drowableRess} to set
         * @return a reference to this Builder
         */
        public Builder drowableRess(int val) {
            drowableRess = val;
            return this;
        }

        /**
         * Sets the {@code dictionaryWords} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code dictionaryWords} to set
         * @return a reference to this Builder
         */
        public Builder dictionaryWords(List<String> val) {
            dictionaryWords = val;
            return this;
        }

        /**
         * Returns a {@code LessonsResponse} built from the parameters previously set.
         *
         * @return a {@code LessonsResponse} built with parameters of this {@code LessonsResponse.Builder}
         */
        public LessonsResponse build() {
            return new LessonsResponse(this);
        }
    }
}
