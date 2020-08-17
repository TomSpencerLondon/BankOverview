package com.codurance;

public class Account {

  private TransactionRepository transactionRepository;
  private final StatementPrinter statementPrinter;

  public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
    this.transactionRepository = transactionRepository;
    this.statementPrinter = statementPrinter;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(100);
  }

  public void withdraw(int amount) {
    transactionRepository.addWithdrawal(100);
  }

  public void printStatement() {
    statementPrinter.print(transactionRepository.allTransactions());
  }
}
