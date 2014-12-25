package jbehave.model;

import jbehave.strategies.JuniorAlgorithm;
import jbehave.strategies.SalaryAlgorithm;

/**
 * Created by serhii on 07.12.14.
 */
public class JuniorEngineer extends Worker {

    private SalaryAlgorithm salaryAlgorithm = new JuniorAlgorithm();

    public JuniorEngineer(){
        setHourRate(3);
    }

    public JuniorEngineer(double hourRate){
        setHourRate(hourRate);
    }

    @Override
    public double calculateSalary(int reportedHours) {
        return salaryAlgorithm.calculateSalary(reportedHours, getHourRate(), this);
    }
}
