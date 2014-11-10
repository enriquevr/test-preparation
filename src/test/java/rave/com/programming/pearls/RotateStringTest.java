package rave.com.programming.pearls;

import junit.framework.Assert;
import org.junit.Test;

public class RotateStringTest {

  @Test
  public void itShouldRotateAGivenString() throws Exception {
    char input [] = {'a','b','c','d','e','f','g','h'};
    int n = 3;
    System.out.println("before rotation: " + new String(input));

    RotateString.rotate(input, n);

    Assert.assertEquals("defghabc", new String(input));
  }
}