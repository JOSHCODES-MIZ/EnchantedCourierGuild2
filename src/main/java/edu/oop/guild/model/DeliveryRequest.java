package edu.oop.guild.model;

public class DeliveryRequest {
	private final PackageType packageType;
    private final int weightKg;
    private final int distanceLeagues;
    private final RealmType destinationRealm;
    private final boolean fragile;

    public DeliveryRequest(PackageType packageType, int weightKg, int distanceLeagues, RealmType destinationRealm, boolean fragile) {
        // Validation required by invalidRequests() in DeliveryRequestTest
        if (packageType == null || destinationRealm == null) {
            throw new NullPointerException("Fields cannot be null");
        }
        if (weightKg <= 0 || distanceLeagues <= 0) {
            throw new IllegalArgumentException("Weight and distance must be positive");
        }
        
        this.packageType = packageType;
        this.weightKg = weightKg;
        this.distanceLeagues = distanceLeagues;
        this.destinationRealm = destinationRealm;
        this.fragile = fragile;
    }

    public PackageType getPackageType() { return packageType; }
    public int getWeightKg() { return weightKg; }
    public int getDistanceLeagues() { return distanceLeagues; }
    public RealmType getDestinationRealm() { return destinationRealm; }
    public boolean isFragile() { return fragile; }
}
