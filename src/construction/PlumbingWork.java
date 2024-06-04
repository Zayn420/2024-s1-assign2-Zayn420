
package construction;

import java.io.Serializable;
import java.util.Scanner;

public class PlumbingWork extends Component implements Serializable {
    private static final long serialVersionUID = 1L;
    public int days;
    private static final double DAILY_COST = 243;
    private static final int MIN_DAYS = 5;
    private static final int MAX_DAYS = 8;

    public PlumbingWork() {
        Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter the number of days required for plumbing work (5-8): ");
                this.days = scanner.nextInt();
            } while (days < MIN_DAYS || days > MAX_DAYS);
        }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public void displayDetails() {
        double cost = days * DAILY_COST;
        System.out.println("Plumbing Work: Requires " + days + " days");
        System.out.println(days + " days @ $" + DAILY_COST + " per day\t\t" + cost);
        System.out.println("Total Cost: $" + cost);
    }

    @Override
    public int getDaysRequired() {
        return days;
    }

    @Override
    public double getCost() {
        return days * DAILY_COST;
    }

    @Override
    public String getSummary() {
        return "Plumbing Work: " + days + " days @ $" + DAILY_COST + " per day, Total Cost: $" + getCost();
    }
}
