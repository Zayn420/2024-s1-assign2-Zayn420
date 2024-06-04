package construction;

import java.io.Serializable;
import java.util.Scanner;

public class Roofing extends Component implements Serializable {
    private static final long serialVersionUID = 1L; // Adding serialVersionUID

    public int area;
    public String material;
    public String color;
    private static final double TILE_COST = 95.00;
    private static final double PAINTED_STEEL_COST = 65.00;
    private static final double UNPAINTED_STEEL_COST = 47.00;
    private static final int BASE_DAYS = 2;
    private static final int TILE_AREA_PER_DAY = 80;
    private static final int STEEL_AREA_PER_DAY = 400;
    private static final double BASE_LABOR_COST = 600;
    private static final double ADDITIONAL_LABOR_COST = 230;

    public Roofing() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total area of roofing required (in square meters): ");
        this.area = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter the type of roofing (tiles/painted steel/unpainted steel): ");
        this.material = scanner.nextLine();
        if (this.material != null && !material.equalsIgnoreCase("unpainted steel")) {
            System.out.print("Enter the color of the roofing: ");
            this.color = scanner.nextLine();
        }
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayDetails() {
        double materialCost = 0;
        int additionalDays = 0;
        if (material.equalsIgnoreCase("tiles")) {
            materialCost = TILE_COST * area;
            additionalDays = (int) Math.ceil((double) area / TILE_AREA_PER_DAY);
        } else if (material.equalsIgnoreCase("painted steel")) {
            materialCost = PAINTED_STEEL_COST * area;
            additionalDays = (int) Math.ceil((double) area / STEEL_AREA_PER_DAY);
        } else if (material.equalsIgnoreCase("unpainted steel")) {
            materialCost = UNPAINTED_STEEL_COST * area;
            additionalDays = (int) Math.ceil((double) area / STEEL_AREA_PER_DAY);
        }
        int totalDays = BASE_DAYS + additionalDays;
        double laborCost = BASE_LABOR_COST + ADDITIONAL_LABOR_COST * additionalDays;
        double totalCost = materialCost + laborCost;
        System.out.println("Roofing: Requires " + totalDays + " days");
        System.out.println(area + " m2 of " + material + (color != null ? ", color: " + color : "") + " @ $" + (material.equalsIgnoreCase("tiles") ? TILE_COST : (material.equalsIgnoreCase("painted steel") ? PAINTED_STEEL_COST : UNPAINTED_STEEL_COST)) + " per m2\t\t" + materialCost);
        System.out.println("Labor costs\t\t" + laborCost);
        System.out.println("Total Cost: $" + totalCost);
    }

    @Override
    public int getDaysRequired() {
        int additionalDays = 0;
        if (material.equalsIgnoreCase("tiles")) {
            additionalDays = (int) Math.ceil((double) area / TILE_AREA_PER_DAY);
        } else {
            additionalDays = (int) Math.ceil((double) area / STEEL_AREA_PER_DAY);
        }
        return BASE_DAYS + additionalDays;
    }

    @Override
    public double getCost() {
        double materialCost = 0;
        int additionalDays = 0;
        if (material.equalsIgnoreCase("tiles")) {
            materialCost = TILE_COST * area;
            additionalDays = (int) Math.ceil((double) area / TILE_AREA_PER_DAY);
        } else if (material.equalsIgnoreCase("painted steel")) {
            materialCost = PAINTED_STEEL_COST * area;
            additionalDays = (int) Math.ceil((double) area / STEEL_AREA_PER_DAY);
        } else if (material.equalsIgnoreCase("unpainted steel")) {
            materialCost = UNPAINTED_STEEL_COST * area;
            additionalDays = (int) Math.ceil((double) area / STEEL_AREA_PER_DAY);
        }
        double laborCost = BASE_LABOR_COST + ADDITIONAL_LABOR_COST * additionalDays;
        return materialCost + laborCost;
    }

    @Override
    public String getSummary() {
        return "Roofing: " + area + " m2 of " + material + (color != null ? ", color: " + color : "") + ", Total Cost: $" + getCost();
    }
}
