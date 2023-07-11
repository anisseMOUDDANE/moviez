package com.example.moviez.models;

import java.util.List;
import java.util.Map;

public class Response {

    private List<Choice> choices;

    public Map<Object, Object> getChoices() {
    }

    // constructors, getters and setters

    public static class Choice {

        private int index;
        private Message message;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
// constructors, getters and setters
    }
}
