package com.example.interfaceMode;

import java.time.LocalDateTime;

public class MyPrototypeBean implements IPrototype {

  private String dateTimeString = LocalDateTime.now().toString();

  @Override
  public String getDateTime() {
      return dateTimeString;
  }
}