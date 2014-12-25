package jbehave.model;

/**
 * Created by serhii on 07.12.14.
 */
public enum Employee {

    JUNIOR("junior"), SENIOR("senior");
    private final String employee;

    Employee(String employee) {
        this.employee = employee;
    }
}
