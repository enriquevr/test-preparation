package rave.com.cormen.chapter.one;

public class Efficiency {


  static class Computer {

    Computer(String name, Long instructionsPerSecond) {
      this.name = name;
      this.instructionsPerSecond = instructionsPerSecond;
    }

    private String name;
    private Long instructionsPerSecond;

    public Long instructionsPerSecond() {
      return instructionsPerSecond;
    }

    private double doRun(Algorithm algorithm, Long inputSize) {
      double time = algorithm.time(inputSize);
      return time * instructionsPerSecond;
    }

    public AlgorithmRun run(Algorithm algorithm, Long inputSize) {
      return new AlgorithmRun(algorithm, this, inputSize);
    }

    @Override
    public String toString() {
      return "Computer{" +
        "name='" + name + '\'' +
        ", instructionsPerSecond=" + instructionsPerSecond +
        '}';
    }
  }

  static abstract class Algorithm {
    private String name;
    private double constantFactor;

    protected Algorithm(String name, Long constantFactor) {
      this.name = name;
      this.constantFactor = constantFactor;
    }

    protected double constantFactor() {
      return constantFactor;
    }

    public abstract double time(Long n);

    @Override
    public String toString() {
      return "Algorithm{" +
        "name='" + name + '\'' +
        '}';
    }
  }

  static class AlgorithmRun {
    private Algorithm algorithm;
    private Computer computer;
    private Long inputSize;
    private Double timeTaken;

    AlgorithmRun(Algorithm algorithm, Computer computer, Long inputSize) {
      this.algorithm = algorithm;
      this.computer = computer;
      this.inputSize = inputSize;
      timeTaken = computer.doRun(algorithm, inputSize);
    }

    public Double timeTaken() {
      return timeTaken;
    }

    @Override
    public String toString() {
      return algorithm.name + " took:  " + timeTaken + " in " + computer.name + " for n = " + inputSize;
    }

    public static AlgorithmRun max(AlgorithmRun one, AlgorithmRun two) {
      return one.timeTaken <= two.timeTaken ? one : two;
    }
  }


}
