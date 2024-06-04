
package construction;

import java.io.Serializable;
import java.util.ArrayList;

public class BuildingJob implements Serializable {
    private static final long serialVersionUID = 1L;
    private String address;
    private String type;
   
    private ArrayList<Component> components;
    private static final double TAX_RATE = 0.10;
    private static final double HOUSE_FEE = 12000;
    private static final double LANDSCAPED_HOUSE_FEE = 21000;
    private static final double INDUSTRIAL_FEE = 18400;

    public BuildingJob(String address, String type) {
        this.address = address;
        this.type = type;
        
        this.components = new ArrayList<>();
    }
  

	public void addComponent(Component component) {
        components.add(component);
    }

    public void displayDetails() {
        System.out.println("Building Job site: " + address);
        System.out.println("Type: " + type);
        int totalDays = 0;
        double totalCost = 0;

        for (Component component : components) {
            component.displayDetails();
            totalDays += component.getDaysRequired();
            totalCost += component.getCost();
        }

        double contractFee = (type.equalsIgnoreCase("house")) ? HOUSE_FEE :
                             (type.equalsIgnoreCase("landscaped house")) ? LANDSCAPED_HOUSE_FEE :
                             INDUSTRIAL_FEE;
        totalCost += contractFee;
        double tax = totalCost * TAX_RATE;
        totalCost += tax;

        System.out.println("Contract Fee: $" + contractFee);
        System.out.println("TOTAL COSTS: $" + (totalCost - tax));
        System.out.println("Government Taxes: $" + tax);
        System.out.println("AMOUNT DUE: $" + totalCost);
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Component component : components) {
            totalCost += component.getCost();
        }
        double contractFee = (type.equalsIgnoreCase("house")) ? HOUSE_FEE :
                             (type.equalsIgnoreCase("landscaped house")) ? LANDSCAPED_HOUSE_FEE :
                             INDUSTRIAL_FEE;
        totalCost += contractFee;
        double tax = totalCost * TAX_RATE;
        totalCost += tax;
        return totalCost;
    }

    public int calculateTotalDays() {
        int totalDays = 0;
        for (Component component : components) {
            totalDays += component.getDaysRequired();
        }
        return totalDays;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Building Job site: ").append(address).append("\n");
        summary.append("Type: ").append(type).append("\n");
        int totalDays = calculateTotalDays();
        double totalCost = calculateTotalCost();
        summary.append("Total Days required: ").append(totalDays).append("\n");
        summary.append("Total Cost: $").append(totalCost).append("\n");
        for (Component component : components) {
            summary.append(component.getSummary()).append("\n");
        }
        return summary.toString();
    }
}
