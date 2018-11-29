package com.lucky.demo.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserState implements Serializable {
    private static final long serialVersionUID = 1L;

    public String bookName;
    public int readDays;
    public int avgReadWord;
    public int remainDays;
}
