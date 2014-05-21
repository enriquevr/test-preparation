package rave.com.cormen.chapter.one;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static rave.com.cormen.chapter.one.Efficiency.Algorithm;
import static rave.com.cormen.chapter.one.Efficiency.Computer;
import static rave.com.math.Logarithm.log2;

@RunWith(Theories.class)
public class EfficiencyTest {

  private Computer computerA;
  private Computer computerB;

  private Algorithm mergeSort;
  private Algorithm insertionSort;

  @Before
  public void setUp() throws Exception {
    computerA = new Computer("Fast Computer", 10000000000l);
    computerB = new Computer("Slow Computer", 10000000l);


    insertionSort = new Algorithm("Insertion Sort", 2l) {
      @Override
      public double time(Long n) {
        return constantFactor() * n * n;
      }
    };

    mergeSort = new Algorithm("Merge Sort", 50l) {
      @Override
      public double time(Long n) {
        return constantFactor() * n * log2(n);
      }
    };

  }

  @DataPoints
  public static Long[] inputSizes() throws Exception {
    Long [] inputSizes = new Long[10000];
    for(int i = 0, n = inputSizes.length; i < n; i++) {
      inputSizes[i] = (long)i;
    }
    return inputSizes;
  }

  @Theory
  public void calculateTimes(Long n) throws Exception {
    System.out.println(computerB.run(mergeSort, n).timeTaken());
  }

  @Test
  public void computerA_is_1000_times_faster_than_computerB() throws Exception {

    Long instructionsPerSecondOfA = computerA.instructionsPerSecond();
    Long instructionsPerSecondOfB = computerB.instructionsPerSecond() * 1000;

    Assert.assertEquals(instructionsPerSecondOfA, instructionsPerSecondOfB);
  }


}
