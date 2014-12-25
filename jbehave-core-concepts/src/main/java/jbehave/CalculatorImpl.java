package jbehave;

import jbehave.model.Worker;
import jbehave.model.WorkerIdentifier;

/**
 * Created by serhii on 07.12.14.
 */
public class CalculatorImpl implements Calculator {

    private Worker worker;

    @Override
    public double calculateSalary(int reportedHours) {
        return worker.calculateSalary(reportedHours);
    }

    @Override
    public void identifyWorkerWithRate(String worker, double rate) {
        this.worker = WorkerIdentifier.getWorker(worker, rate);
    }

    @Override
    public void identifyWorker(String worker) {
        this.worker = WorkerIdentifier.getWorker(worker);
    }

    @Override
    public void setBonus(boolean bonus) {
        worker.setBonus(bonus);
    }
}
