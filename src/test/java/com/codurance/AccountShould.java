package com.codurance;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountShould {

  private Account account;

  @Mock
  private TransactionRepository transactionRepository;

  @BeforeEach
  void setUp() {
    account = new Account(transactionRepository);
  }

  @Test
  void store_deposit_transaction() {
    account.deposit(100);

    verify(transactionRepository).addDeposit(100);
  }
}
