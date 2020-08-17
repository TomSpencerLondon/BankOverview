package com.codurance;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

  private final Clock clock;
  private List<Transaction> transactions = new ArrayList<>();

  public TransactionRepository(Clock clock) {
    this.clock = clock;
  }

  public void addDeposit(int amount) {
    Transaction depositTransaction = new Transaction(clock.todayAsString(), amount);
    transactions.add(depositTransaction);
  }

  public void addWithdrawal(int amount) {
    throw new UnsupportedOperationException("Implement me!");
  }

  public List<Transaction> allTransactions() {
    return unmodifiableList(transactions);
  }
}
