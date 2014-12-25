package jbehave.strategies;

import jbehave.model.JuniorEngineer;
import jbehave.model.Worker;

/**
 * Created by serhii on 07.12.14.
 */
public class JuniorAlgorithm implements SalaryAlgorithm {

    @Override
    public double calculateSalary(int hours, double rate, Worker worker) {
        double salary = hours * rate * 20;
        if (worker.isBonus()) {
            salary += JuniorEngineer.BONUS;
        }

        return salary;
    }
}
