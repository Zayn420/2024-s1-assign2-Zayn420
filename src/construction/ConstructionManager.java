
package construction;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructionManager {
    private static ArrayList<BuildingJob> jobs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            try {
                switch (choice) {
                    case 1:
                        addNewBuildingJobManually();
                        break;
                    case 2:
                        displayBuildingJobDetails();
                        break;
                    case 3:
                        generateSummaryReport();
                        break;
                    case 4:
                        addBuildingJobFromFile();
                        break;
                    case 5:
                        saveBuildingJobs();
                        break;
                    case 6:
                        loadBuildingJobs();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a new Building Job manually");
        System.out.println("2. Display details of a particular Building Job");
        System.out.println("3. Generate a summary report");
        System.out.println("4. Add a new Building Job from a file");
        System.out.println("5. Save all Building Jobs");
        System.out.println("6. Load Building Jobs");
        System.out.println("7. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void addNewBuildingJobManually() {
        System.out.print("Enter the address of the work site: ");
        String address = scanner.nextLine();
        System.out.print("Enter the type of build job (house/industrial): ");
        String type = scanner.nextLine();
        BuildingJob job = new BuildingJob(address, type);

        while (true) {
            System.out.println("1. Add Concrete Slab");
            System.out.println("2. Add Framing");
            System.out.println("3. Add Roofing");
            System.out.println("4. Add Brick Work");
            System.out.println("5. Add Windows and Doors");
            System.out.println("6. Add Electrical Work");
            System.out.println("7. Add Plumbing Work");
            System.out.println("8. Display current job details");
            System.out.println("9. Confirm and add job");
            System.out.println("10. Cancel");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    job.addComponent(new ConcreteSlab());
                    break;
                case 2:
                    job.addComponent(new Framing());
                    break;
                case 3:
                    job.addComponent(new Roofing());
                    break;
                case 4:
                    job.addComponent(new BrickWork());
                    break;
                case 5:
                    job.addComponent(new WindowAndDoor());
                    break;
                case 6:
                    job.addComponent(new ElectricalWork());
                    break;
                case 7:
                    job.addComponent(new PlumbingWork());
                    break;
                case 8:
                    job.displayDetails();
                    break;
                case 9:
                    jobs.add(job);
                    System.out.println("Building job added.");
                    return;
                case 10:
                    System.out.println("Cancelled adding job.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayBuildingJobDetails() {
        if (jobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        for (int i = 0; i < jobs.size(); i++) {
            System.out.println((i + 1) + ". " + jobs.get(i).getAddress());
        }

        System.out.print("Enter the number of the job to display: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice > 0 && choice <= jobs.size()) {
            jobs.get(choice - 1).displayDetails();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void generateSummaryReport() throws IOException {
        System.out.print("Enter the file name for the summary report: ");
        String fileName = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Summary Report\n");
            for (BuildingJob job : jobs) {
                writer.write(job.getSummary());
                writer.newLine();
            }
            System.out.println("Summary report generated.");
        }
    }

    @SuppressWarnings("unchecked")
	private static void addBuildingJobFromFile() throws IOException {
        System.out.print("Enter the address of the work site: ");
        String address = scanner.nextLine();
        System.out.print("Enter the file name with building job details: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            BuildingJob job = new BuildingJob(address, "house");
            String line = null;

            // Read Concrete Slab details
            ConcreteSlab slab = null;
                try {
                    slab = new ConcreteSlab();
                    job.addComponent(slab);
                } catch (Exception e) {
                    System.err.println("Error parsing Concrete Slab details: " + e.getMessage());
                }

            // Read Framing details
            
                Framing framing = null;
                try {
                    framing = new Framing();
                    job.addComponent(framing);
                } catch (Exception e) {
                    System.err.println("Error parsing Framing details: " + e.getMessage());
                }
            

            // Read Roofing details
            
                Roofing roofing = null;
                try {
                    
                    roofing = new Roofing();
                    job.addComponent(roofing);
                } catch (Exception e) {
                    System.err.println("Error parsing Roofing details: " + e.getMessage());
                }
            

            // Read Brick Work details
            
                BrickWork brickWork = null;
                try {
                    
                      brickWork = new BrickWork();
                    job.addComponent(brickWork);
                } catch (Exception e) {
                    System.err.println("Error parsing Brick Work details: " + e.getMessage());
                }
            

            // Read Windows and Doors details
                WindowAndDoor windowsAndDoors = null;
                try {
                    
                      windowsAndDoors = new WindowAndDoor();
                    job.addComponent(windowsAndDoors);
                } catch (Exception e) {
                    System.err.println("Error parsing Windows and Doors details: " + e.getMessage());
                }
            

            // Read Electrical and Plumbing details
                ElectricalWork electricalWork = null;
                PlumbingWork plumbingWork = null;
                try {
                      electricalWork = new ElectricalWork();
//                    electricalWork.setDays(Integer.parseInt(parts[0]));
                    job.addComponent(electricalWork);

                    plumbingWork = new PlumbingWork();
//                    plumbingWork.setDays(Integer.parseInt(parts[1]));
                    job.addComponent(plumbingWork);
                } catch (Exception e) {
                    System.err.println("Error parsing Electrical and Plumbing details: " + e.getMessage());
                }
            

                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    writer.write("---New Job---\n");
                    writer.write("Area: "+String.valueOf(slab.area));
                    writer.write("\nArea: "+String.valueOf(slab.area));


                    writer.write("\n\nArea: "+String.valueOf(slab.area));
                    writer.write("\nFarming Length: "+String.valueOf(framing.length));
                    writer.write("\nFarming Type: "+framing.material);
                    
                    writer.write("\n\nRoofing Area: "+String.valueOf(roofing.area));
                    writer.write("\nRoofing Type: "+roofing.material);
                    writer.write("\nRoofing Color: "+roofing.color);
                    
                    writer.write("\\n\\nNumber of Bricks: "+String.valueOf(brickWork.numberOfBricks));
                    
                    if(brickWork.quality == 1) {
                    	writer.write("\nBricks Quality: LOW");
                    }else if(brickWork.quality == 2) {
                    	writer.write("\nBricks Quality: MEDIUM");
                    }else {
                    	writer.write("\nBricks Quality: HIGH");
                    }
                    writer.write("\nBricks Color: "+brickWork.color);
                    
                    
                    
                    writer.write("\n\nNumbers of small windows: "+String.valueOf(windowsAndDoors.smallWindows));
                    writer.write("\nNumbers of large windows: "+String.valueOf(windowsAndDoors.largeWindows));
                    writer.write("\nNumbers of sliding doors: "+String.valueOf(windowsAndDoors.slidingDoors));
                    writer.write("\nNumbers of swing doors: "+String.valueOf(windowsAndDoors.swingDoors));
                    
                    
                    writer.write("\n\nDays required for electrical work: "+String.valueOf(electricalWork.days));
                    
                    writer.write("\n\nDays required for plumbing work: "+String.valueOf(plumbingWork.days));
  
                    System.out.println("Summary report generated.");
                }

        }
    }

    private static void saveBuildingJobs() throws IOException {
        System.out.print("Enter the file name to save building jobs: ");
        String fileName = scanner.nextLine();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(jobs);
            System.out.println("Building jobs saved.");
        }
    }

    private static void loadBuildingJobs() throws IOException, ClassNotFoundException {
        System.out.print("Enter the file name to load building jobs: ");
        String fileName = scanner.nextLine();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            jobs = (ArrayList<BuildingJob>) in.readObject();
            System.out.println("Building jobs loaded.");
        }
    }
}
