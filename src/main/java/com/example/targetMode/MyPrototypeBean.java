package com.example.targetMode;

import java.time.LocalDateTime;

public class MyPrototypeBean {

    private final String dateTimeString = LocalDateTime.now().toString();

    public MyPrototypeBean() {
        System.out.println("call prototype constructor : " + dateTimeString);
    }

    public String getDateTime() {
        return dateTimeString;
    }
}