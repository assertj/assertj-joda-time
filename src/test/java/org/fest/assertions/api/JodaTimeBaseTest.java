package org.fest.assertions.api;

import static org.junit.rules.ExpectedException.none;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class JodaTimeBaseTest {

  @Rule
  public ExpectedException thrown = none();

  protected void expectException(Class<? extends Throwable> type, String message) {
    thrown.expect(type);
    thrown.expectMessage(message);
  }
  
  protected void expectIllegalArgumentException(String message) {
    expectException(IllegalArgumentException.class, message);
  }

}