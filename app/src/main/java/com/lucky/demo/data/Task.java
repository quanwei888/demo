package com.lucky.demo.data;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by qw on 18-11-30.
 */

public class Task {
    public int taskId;
    public List<String> words;
    Iterator<String> wordIter;

    public String nextWord() {
        if (wordIter == null) {
            wordIter = words.iterator();
        }

        if (!wordIter.hasNext()) {
            wordIter = words.iterator();
        }
        return wordIter.next();
    }
}
