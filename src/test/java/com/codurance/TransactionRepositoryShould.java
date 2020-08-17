package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryShould {


  public static final String TODAY = "12/05/2020";
  private TransactionRepository transactionRepository;

  @Mock
  private Clock clock;

  @BeforeEach
  void setUp() {
    transactionRepository = new TransactionRepository(clock);
  }

  @Test
  void create_and_store_a_deposit_transaction() {
    given(clock.todayAsString()).willReturn(TODAY);

    transactionRepository.addDeposit(100);

    List<Transaction> transactions = transactionRepository.allTransactions();

    assertEquals(1, transactions.size());
    assertEquals(transaction(TODAY, 100), transactions.get(0));
  }

  private Transaction transaction(String date, int amount) {
    return new Transaction(date, amount);
  }
}
