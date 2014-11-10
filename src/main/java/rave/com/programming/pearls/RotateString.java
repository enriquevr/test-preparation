package rave.com.programming.pearls;


/**
 *
 * Rotates a string of m elements by n elements using with time complexity O(n) and additional space of m - 2*n
 * */
public class RotateString {

  public static void rotate(char[] input, int n) {

    char [] buffer = new char[input.length - 2 * n];

    fillBuffer(input, buffer);

    shuffle(input, n);

    putBuffer(input, buffer, n);
  }

  private static void putBuffer(char[] input, char[] buffer, int offset) {
    for(int i = 0, m = buffer.length; i < m; i++) {
      input[i + offset] = buffer[i];
    }
  }

  private static void shuffle(char[] input, int n) {
    int m = input.length - 1;
    for(int i = n - 1 ; i >= 0; i--) {
      char temp = input [i];
      int offset = n - i - 1;
      input[i] = input[i + n];
      input[m - offset] = temp;
    }
  }

  private static void fillBuffer(char[] input, char[] buffer) {
    int length = input.length;

    for(int i = 0, n = buffer.length; i < n; i++) {
      buffer[i] = input[length - n + i];
    }
  }
}
