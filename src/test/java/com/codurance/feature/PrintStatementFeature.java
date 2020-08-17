package com.codurance.feature;

import static org.mockito.Mockito.verify;

import com.codurance.Account;
import com.codurance.Clock;
import com.codurance.Console;
import com.codurance.StatementPrinter;
import com.codurance.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {


  @Mock
  private Console console;
  @Mock
  private Clock clock;

  private Account account;


  @BeforeEach
  void setUp() {
    TransactionRepository transactionRepository = new TransactionRepository(clock);
    StatementPrinter statementPrinter = new StatementPrinter();
    account = new Account(transactionRepository, statementPrinter);
  }

  @Test
  void print_statement_containing_all_transactions() {
    account.deposit(1000);
    account.withdraw(100);
    account.deposit(500);


    account.printStatement();

    InOrder inOrder = Mockito.inOrder(console);

    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }
}
