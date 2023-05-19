package Camera;

import java.util.*;




public class CameraRentalApp {
    private Map<Integer, Camera> cameraMap;
    private double walletBalance;
    
    private Scanner scanner;

    public CameraRentalApp() {
        cameraMap = new HashMap<>();
        walletBalance = 0.0;
        
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n****===== WELCOME TO CAMERA RENTAL APP =====****");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
        scanner.close();
    }

    private void login() {
    	try {
    	    System.out.print("Enter username: ");
    	    String username = scanner.nextLine();
    	    System.out.print("Enter password: ");
    	    String password = scanner.nextLine();

    	    if (username.equals("admin") && password.equals("password")) {
    	        showMainMenu();
    	    } else {
    	        System.out.println("Invalid username or password.");
    	    }
    	} catch (Exception e) {
    	    System.out.println("An error occurred during login: " + e.getMessage());
    	}

    }

    private void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====Menu=====");
            System.out.println("1.  My Camera");
            System.out.println("2. View All Cameras");
            System.out.println("3. My Wallet");
            System.out.println("4. Rent a Camera");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    showMyCameraMenu();
                    break;
                case 2:
                    viewAllCameras();
                    break;
                case 3:
                    showWallet();
                    break;
                case 4:
                    rentCamera();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void showMyCameraMenu() {
        boolean backToMainMenu = false;
        while (!backToMainMenu) {
            System.out.println("\n===== My Camera  =====");
            System.out.println("1. Add Camera");
            System.out.println("2. Remove Camera");
            System.out.println("3. View My Cameras");
            System.out.println("4. Go to Previous Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCamera();
                    break;
                case 2:
                    removeCamera();
                    break;
                case 3:
                    viewMyCameras();
                    break;
                case 4:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid ");
            }
        }
    }

    private void addCamera() {
        System.out.println("\n===== Add Camera =====");
        System.out.print("Enter camera brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter camera model: ");
        String model = scanner.nextLine();
        System.out.print("Enter per day price: ");
        double perDayPrice = scanner.nextDouble();
        scanner.nextLine(); 

        int id = generateCameraId();
        Camera camera = new Camera(id, brand, model, perDayPrice, true);
        cameraMap.put(id, camera);
        System.out.println("Camera added successfully!");
    }

    private int generateCameraId() {
        int id = 1;
        if (!cameraMap.isEmpty()) {
            id = Collections.max(cameraMap.keySet()) + 1;
        }
        return id;
    }

    private void removeCamera() {
        System.out.println("\n===== Remove Camera =====");
        System.out.println("Camera Details:");
        displayCameraDetails();

        System.out.print("Enter camera ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Camera camera = cameraMap.get(id);
        if (camera != null) {
            cameraMap.remove(id);
            System.out.println("Camera removed successfully!");
        } else {
            System.out.println("Invalid camera ID.");
        }
    }

    private void viewMyCameras() {
        System.out.println("\n===== My Cameras =====");
        if (cameraMap.isEmpty()) {
            System.out.println("No cameras available.");
        } else {
            System.out.println("ID\t\tBrand\t\tModel\t\tPrice\t\tStatus");
            for (Camera camera : cameraMap.values()) {
                if (!camera.isAvailable()) {
                    System.out.println(camera.getId() + "\t\t" + camera.getBrand() + "\t\t" +
                            camera.getModel() + "\t\t" + camera.getPerDayPrice() + "\t\tRented");
                }
            }
        }
    }

    private void viewAllCameras() {
        System.out.println("\n===== All Cameras =====");
        if (cameraMap.isEmpty()) {
            System.out.println("No cameras available.");
        } else {
            displayCameraDetails();
        }
    }

    private void displayCameraDetails() {
        System.out.println("ID\t\tBrand\t\tModel\t\tPrice\t\tStatus");
        for (Camera camera : cameraMap.values()) {
            System.out.println(camera.getId() + "\t\t" + camera.getBrand() + "\t\t" +
                    camera.getModel() + "\t\t" + camera.getPerDayPrice() + "\t\t" +
                    (camera.isAvailable() ? "Available" : "Rented"));
        }
    }

    private void showWallet() {
        System.out.println("\n===== My Wallet =====");
        System.out.println("Available Balance: $" + walletBalance);

        System.out.print("Do you want to add amount to your wallet? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the amount to add: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.print("Confirm adding $" + amount + " to your wallet? (yes/no): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                walletBalance += amount;
                System.out.println("Amount added successfully!");
            } else {
                System.out.println("Adding amount to wallet canceled.");
            }
        }
    }

    private void rentCamera() {
        System.out.println("\n===== Rent a Camera =====");
        if (cameraMap.isEmpty()) {
            System.out.println("No cameras available for rent.");
            return;
        }

        System.out.println("Available Cameras:");
        displayAvailableCameras();

        System.out.print("Enter camera ID to rent: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Camera camera = cameraMap.get(id);
        if (camera != null && camera.isAvailable()) {
            double rentPrice = camera.getPerDayPrice();
            try {
            if (walletBalance >= rentPrice) {
                camera.setAvailable(false);
                walletBalance -= rentPrice;
                System.out.println("Your transaction for " + camera.getBrand() + " " + camera.getModel() +
                        " with rent price $" + rentPrice + " is successful.");
            } else {
                System.out.println("Insufficient balance in your wallet to rent this camera.");
            }
        } 
         catch (Exception e) {
            System.out.println("An error occurred during the transaction: " + e.getMessage());
         }
        }
            else {
            System.out.println("Invalid camera ID or camera is not available for rent.");
        }
    }

    private void displayAvailableCameras() {
        System.out.println("ID\t\tBrand\t\tModel\t\tPrice");
        for (Camera camera : cameraMap.values()) {
            if (camera.isAvailable()) {
                System.out.println(camera.getId() + "\t" + camera.getBrand() + "\t\t" +
                        camera.getModel() + "\t\t" + camera.getPerDayPrice());
            }
        }
    }

    public static void main(String[] args) {
        CameraRentalApp rentalApp = new CameraRentalApp();
        rentalApp.run();
    }
}

class Camera {
    private int id;
    private String brand;
    private String model;
    private double perDayPrice;
    private boolean available;

    public Camera(int id, String brand, String model, double perDayPrice, boolean available) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.perDayPrice = perDayPrice;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPerDayPrice() {
        return perDayPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
