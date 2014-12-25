package jbehave.strategies;

import jbehave.model.Worker;

/**
 * Created by serhii on 07.12.14.
 * General strategy algorithm.
 */
public interface SalaryAlgorithm {

    public double calculateSalary(int hours, double rate, Worker worker);
}
