package jbehave.strategies;

import jbehave.Constants;
import jbehave.model.SeniorEngineer;
import jbehave.model.Worker;

/**
 * Created by serhii on 07.12.14.
 */
public class SeniorAlgorithm implements SalaryAlgorithm {

    @Override
    public double calculateSalary(int hours, double rate, Worker worker) {
        double salary = hours * rate * 20;
        if (worker.isBonus()) {
            salary += SeniorEngineer.BONUS;
        }
        salary += Constants.LEAD_ACTIVITIES_INCOME;

        return salary;
    }
}
