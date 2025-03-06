import java.util.Scanner;

public class TripCalculator {
    private int distanceKm;
    private int fuelPricePerLiter;
    private final int fuelEfficiency = 20;
    public TripCalculator(){

    }
    public void setDistanceKm(int distanceKm){
        this.distanceKm = distanceKm;
    }
    public void setFuelPricePerLiter(int fuelPricePerLiter){
        this.fuelPricePerLiter = fuelPricePerLiter;
    }
    public int getDistanceKm(){
        return distanceKm;
    }
    public int getFuelPricePerLiter(){
        return fuelPricePerLiter;
    }
    public float getFuelNeeded(){
        return ((float) distanceKm / fuelEfficiency);
    }
    public float getPricePerTrip(){
        return getFuelNeeded() * fuelPricePerLiter;
    }
    public static void main(String[] args){
        boolean run = true;
        while(run){
            run = loop();
        }
    }
    private static boolean loop(){
        // Init
        TripCalculator tripCalculator = new TripCalculator();
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("Please input the distance to travel (km): ");
        int distanceKm = scanner.nextInt();
        tripCalculator.setDistanceKm(distanceKm);
        System.out.println("Distance to travel (km): " + tripCalculator.getDistanceKm());

        System.out.println("Please input the fuel price per liter: ");
        int fuelPricePerLiter = scanner.nextInt();
        System.out.println("Fuel price per liter: " + tripCalculator.getFuelPricePerLiter());
        tripCalculator.setFuelPricePerLiter(fuelPricePerLiter);

        // Calculate
        System.out.println("Total fuel needed for the trip: " + tripCalculator.getFuelNeeded() + "\nTotal price: " + tripCalculator.getPricePerTrip());

        // Option menu
        System.out.println("Pick an option by choosing the number: ");
        System.out.println("1. Calculate again");
        System.out.println("2. Exit");
        int option = scanner.nextInt();
        if(option == 2){
            return false;
        }
        return true;
    }

}
