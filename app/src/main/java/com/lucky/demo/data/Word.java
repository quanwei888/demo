package com.lucky.demo.data;

import java.util.List;

public class Word {
    public String word;
    public String pt;
    public String ptmp3;
    public List<String> synonym;
    public List<Mean> means;
    public List<Example> examples;
    public List<Phrase> phrases;

    public static class Mean {
        public String pos;
        public String mean;
    }
    public static class Example {
        public String en;
        public String cn;
        public String mp3;
    }
    public static class Phrase {
        public String phrase;
        public String mean;
    }
}