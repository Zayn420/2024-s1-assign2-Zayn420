package construction;
import java.io.Serializable;
import java.util.Scanner;

public class WindowAndDoor extends Component implements Serializable {
 private static final long serialVersionUID = 1L;
 public int smallWindows;
 public int largeWindows;
 public int slidingDoors;
 public int swingDoors;
 private static final double SMALL_WINDOW_COST = 800;
 private static final double LARGE_WINDOW_COST = 1520;
 private static final double SLIDING_DOOR_COST = 2100;
 private static final double SWING_DOOR_COST = 380;
 private static final double LABOR_COST = 750;
 private static final int UNITS_PER_DAY = 4;

 public WindowAndDoor() {
    Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the number of small windows: ");
         this.smallWindows = scanner.nextInt();
         System.out.print("Enter the number of large windows: ");
         this.largeWindows = scanner.nextInt();
         System.out.print("Enter the number of sliding doors: ");
         this.slidingDoors = scanner.nextInt();
         System.out.print("Enter the number of swing-open doors: ");
         this.swingDoors = scanner.nextInt();
     }

 public void setSmallWindows(int smallWindows) {
     this.smallWindows = smallWindows;
 }

 public void setLargeWindows(int largeWindows) {
     this.largeWindows = largeWindows;
 }

 public void setSlidingDoors(int slidingDoors) {
     this.slidingDoors = slidingDoors;
 }

 public void setSwingDoors(int swingDoors) {
     this.swingDoors = swingDoors;
 }

 @Override
 public void displayDetails() {
     double totalCost = smallWindows * SMALL_WINDOW_COST +
                        largeWindows * LARGE_WINDOW_COST +
                        slidingDoors * SLIDING_DOOR_COST +
                        swingDoors * SWING_DOOR_COST + LABOR_COST;
     int totalUnits = smallWindows + largeWindows + slidingDoors + swingDoors;
     int days = (int)Math.ceil((double)totalUnits / UNITS_PER_DAY);
     System.out.println("Windows and Doors: Requires " + days + " days");
     System.out.println(smallWindows + " small windows @ $" + SMALL_WINDOW_COST + "\t\t" + smallWindows * SMALL_WINDOW_COST);
     System.out.println(largeWindows + " large windows @ $" + LARGE_WINDOW_COST + "\t\t" + largeWindows * LARGE_WINDOW_COST);
     System.out.println(slidingDoors + " sliding doors @ $" + SLIDING_DOOR_COST + "\t\t" + slidingDoors * SLIDING_DOOR_COST);
     System.out.println(swingDoors + " swing-open doors @ $" + SWING_DOOR_COST + "\t\t" + swingDoors * SWING_DOOR_COST);
     System.out.println("Labor costs\t\t" + LABOR_COST);
     System.out.println("Total Cost: $" + totalCost);
 }

 @Override
 public int getDaysRequired() {
     int totalUnits = smallWindows + largeWindows + slidingDoors + swingDoors;
     return (int)Math.ceil((double)totalUnits / UNITS_PER_DAY);
 }

 @Override
 public double getCost() {
     return smallWindows * SMALL_WINDOW_COST +
            largeWindows * LARGE_WINDOW_COST +
            slidingDoors * SLIDING_DOOR_COST +
            swingDoors * SWING_DOOR_COST + LABOR_COST;
 }

 @Override
 public String getSummary() {
     return "Windows and Doors: " + smallWindows + " small windows, " + largeWindows + " large windows, " + slidingDoors + " sliding doors, " + swingDoors + " swing-open doors, Total Cost: $" + getCost();
 }
}
