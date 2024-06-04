package construction;



import java.io.Serializable;
import java.util.Scanner;

public class ConcreteSlab extends Component implements Serializable {
 private static final long serialVersionUID = 1L;
 public double area;
 private static final double COST_PER_SQUARE_METER = 27.40;
 private static final double LABOR_COST = 2000;
 private static final int DAYS_REQUIRED = 10;

 public ConcreteSlab() {
     Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the total area in square meters: ");
         this.area = scanner.nextDouble();
     }


 public void setArea(double area) {
     this.area = area;
 }

 @Override
 public void displayDetails() {
     double cost = area * COST_PER_SQUARE_METER + LABOR_COST;
     System.out.println("Concrete Slab: Requires " + DAYS_REQUIRED + " days");
     System.out.println(area + " m2 @ $" + COST_PER_SQUARE_METER + " per m2\t\t" + area * COST_PER_SQUARE_METER);
     System.out.println("Labor costs\t\t" + LABOR_COST);
     System.out.println("Total Cost: $" + cost);
 }

 @Override
 public int getDaysRequired() {
     return DAYS_REQUIRED;
 }

 @Override
 public double getCost() {
     return area * COST_PER_SQUARE_METER + LABOR_COST;
 }

 @Override
 public String getSummary() {
     return "Concrete Slab: " + area + " m2 @ $" + COST_PER_SQUARE_METER + " per m2, Total Cost: $" + getCost();
 }
}
