package com.codurance;

public class Account {

  private TransactionRepository transactionRepository;
  private final StatementPrinter printer;

  public Account(TransactionRepository transactionRepository, StatementPrinter printer) {
    this.transactionRepository = transactionRepository;
    this.printer = printer;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(100);
  }

  public void withdraw(int amount) {
    transactionRepository.addWithdrawal(100);
  }

  public void printStatement() {
  }
}
