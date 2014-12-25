package jbehave.model;

import jbehave.strategies.SalaryAlgorithm;
import jbehave.strategies.SeniorAlgorithm;

/**
 * Created by serhii on 07.12.14.
 */
public class SeniorEngineer extends Worker {

    private SalaryAlgorithm salaryAlgorithm = new SeniorAlgorithm();

    public SeniorEngineer(){
        setHourRate(12);
    }

    public SeniorEngineer(double hourRate){
        setHourRate(hourRate);
    }

    @Override
    public double calculateSalary(int reportedHours) {
        return salaryAlgorithm.calculateSalary(reportedHours, getHourRate(), this);
    }
}
