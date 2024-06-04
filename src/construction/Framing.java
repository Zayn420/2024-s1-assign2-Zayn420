package construction;

import java.io.Serializable;
import java.util.Scanner;

public class Framing extends Component implements Serializable {
    private static final long serialVersionUID = 1L;
    public int length;
    public String material;
    private static final double PINE_COST = 21.20;
    private static final double STEEL_COST = 43.70;
    private static final int BASE_DAYS = 3;
    private static final int METERS_PER_DAY = 200;
    private static final double LABOR_COST_PER_DAY = 400;

    public Framing() {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the total length of framing required (in meters): ");
            this.length = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter the type of framing (pine/steel): ");
            this.material = scanner.nextLine();
        }
    

    public void setLength(int length) {
        this.length = length;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void displayDetails() {
        double materialCost = (material.equalsIgnoreCase("steel") ? STEEL_COST : PINE_COST) * length;
        int days = BASE_DAYS + (int) Math.ceil((double) length / METERS_PER_DAY);
        double laborCost = days * LABOR_COST_PER_DAY;
        double totalCost = materialCost + laborCost;
        System.out.println("Framing: Requires " + days + " days");
        System.out.println(length + " meters of " + material + " @ $" + (material.equalsIgnoreCase("steel") ? STEEL_COST : PINE_COST) + " per meter\t\t" + materialCost);
        System.out.println("Labor costs\t\t" + laborCost);
        System.out.println("Total Cost: $" + totalCost);
    }

    @Override
    public int getDaysRequired() {
        return BASE_DAYS + (int) Math.ceil((double) length / METERS_PER_DAY);
    }

    @Override
    public double getCost() {
        double materialCost = (material.equalsIgnoreCase("steel") ? STEEL_COST : PINE_COST) * length;
        int days = BASE_DAYS + (int) Math.ceil((double) length / METERS_PER_DAY);
        double laborCost = days * LABOR_COST_PER_DAY;
        return materialCost + laborCost;
    }

    @Override
    public String getSummary() {
        return "Framing: " + length + " meters of " + material + ", Total Cost: $" + getCost();
    }
}
