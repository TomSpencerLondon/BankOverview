package com.codurance.feature;

import com.codurance.Console;

public class Account {

  private final Console console;

  public Account(Console console) {
    this.console = console;
  }

  public void deposit(int amount) {
  }

  public void withdraw(int amount) {
  }

  public void printStatement() {
    console.printLine("DATE | AMOUNT | BALANCE");
  }
}
