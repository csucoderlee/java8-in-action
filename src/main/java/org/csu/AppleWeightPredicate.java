package org.csu;

public class AppleWeightPredicate implements ApplePredicate {

  @Override
  public boolean test(Apple apple) {
    return apple.getWeight() > 150;
  }
}
