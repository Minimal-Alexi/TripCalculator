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
    public float getPricePerTrip(){
        return ((float) distanceKm / fuelEfficiency) * fuelPricePerLiter;
    }

}
