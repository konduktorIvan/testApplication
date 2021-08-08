package org.test.example.testapplication.client.ui.application.content.screen02.helper;

public class Wrapper {

  private final int    radomNumber;

  private boolean sorted;
  private boolean active;

  public Wrapper(int radomNumber) {
    this.radomNumber = radomNumber;
  }

  public int getRadomNumber() {
    return radomNumber;
  }

  public boolean isSorted() {
    return sorted;
  }

  public void setSorted(boolean sorted) {
    this.sorted = sorted;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
