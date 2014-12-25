package jbehave;

/**
 * Created by serhii on 07.12.14.
 */
public interface Calculator {

    public double calculateSalary(int reportedHours);

    public void identifyWorkerWithRate(String worker, double rate);

    public void identifyWorker(String worker);

    public void setBonus(boolean bonus);
}
