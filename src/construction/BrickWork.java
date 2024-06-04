
package construction;

import java.io.Serializable;
import java.util.Scanner;

public class BrickWork extends Component implements Serializable {
    private static final long serialVersionUID = 1L;
    public int numberOfBricks;
    public int quality;
    public String color;
    private static final double LOW_QUALITY_COST = 3.10;
    private static final double MEDIUM_QUALITY_COST = 5.50;
    private static final double PREMIUM_QUALITY_COST = 7.20;
    private static final double BASE_LABOR_COST = 1350;
    private static final int BRICKS_PER_DAY = 600;
    private static final double ADDITIONAL_LABOR_COST = 170;

    public BrickWork() {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of bricks required: ");
            this.numberOfBricks = scanner.nextInt();
            System.out.print("Enter the brick quality (1=low, 2=medium, 3=premium): ");
            this.quality = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter the color of the bricks: ");
            this.color = scanner.nextLine();
        }

    public void setNumberOfBricks(int numberOfBricks) {
        this.numberOfBricks = numberOfBricks;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayDetails() {
        double brickCost = 0;
        if (quality == 1) {
            brickCost = LOW_QUALITY_COST * numberOfBricks;
        } else if (quality == 2) {
            brickCost = MEDIUM_QUALITY_COST * numberOfBricks;
        } else if (quality == 3) {
            brickCost = PREMIUM_QUALITY_COST * numberOfBricks;
        }
        int days = (int)Math.ceil((double)numberOfBricks / BRICKS_PER_DAY);
        double laborCost = BASE_LABOR_COST + ADDITIONAL_LABOR_COST * days;
        double totalCost = brickCost + laborCost;
        System.out.println("Brick Work: Requires " + days + " days");
        System.out.println(numberOfBricks + " bricks @ $" + (quality == 1 ? LOW_QUALITY_COST : (quality == 2 ? MEDIUM_QUALITY_COST : PREMIUM_QUALITY_COST)) + " each, color: " + color + "\t\t" + brickCost);
        System.out.println("Labor costs\t\t" + laborCost);
        System.out.println("Total Cost: $" + totalCost);
    }

    @Override
    public int getDaysRequired() {
        return (int)Math.ceil((double)numberOfBricks / BRICKS_PER_DAY);
    }

    @Override
    public double getCost() {
        double brickCost = 0;
        if (quality == 1) {
            brickCost = LOW_QUALITY_COST * numberOfBricks;
        } else if (quality == 2) {
            brickCost = MEDIUM_QUALITY_COST * numberOfBricks;
        } else if (quality == 3) {
            brickCost = PREMIUM_QUALITY_COST * numberOfBricks;
        }
        int days = (int)Math.ceil((double)numberOfBricks / BRICKS_PER_DAY);
        double laborCost = BASE_LABOR_COST + ADDITIONAL_LABOR_COST * days;
        return brickCost + laborCost;
    }

    @Override
    public String getSummary() {
        return "Brick Work: " + numberOfBricks + " bricks @ $" + (quality == 1 ? LOW_QUALITY_COST : (quality == 2 ? MEDIUM_QUALITY_COST : PREMIUM_QUALITY_COST)) + " each, color: " + color + ", Total Cost: $" + getCost();
    }
}
