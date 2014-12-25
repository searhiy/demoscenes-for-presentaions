package jbehave.model;

/**
 * Created by serhii on 07.12.14.
 */
public abstract class Worker {

    private double hourRate;

    private boolean bonus;

    public static final double BONUS = 200;

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public abstract double calculateSalary(int reportedHours);
}
