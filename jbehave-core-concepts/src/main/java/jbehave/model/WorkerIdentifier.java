package jbehave.model;

/**
 * Created by serhii on 08.12.14.
 */
public class WorkerIdentifier {

    public static Worker getWorker(String worker){
        Employee employee = Employee.valueOf(worker.toUpperCase());
        switch (employee){
            case JUNIOR: return new JuniorEngineer();
            case SENIOR: return new SeniorEngineer();
        }
        return null;
    }

    public static Worker getWorker(String worker, double rate){
        Employee employee = Employee.valueOf(worker.toUpperCase());
        switch (employee){
            case JUNIOR: return new JuniorEngineer(rate);
            case SENIOR: return new SeniorEngineer(rate);
        }
        return null;
    }
}
