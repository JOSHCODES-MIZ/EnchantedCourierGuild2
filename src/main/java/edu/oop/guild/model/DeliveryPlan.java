package edu.oop.guild.model;

import edu.oop.guild.creature.Creature;

public class DeliveryPlan {
    private final DeliveryRequest request;
    private final Creature courier;
    private final String sealedLabel;
    private final int priceInCoins;

    public DeliveryPlan(DeliveryRequest request, Creature courier, String sealedLabel, int priceInCoins) {
        // Guard clauses to satisfy the 'invalidPlans' test (Screenshot 2026-05-05 at 1.41.46 PM.jpg)
        if (request == null) {
            throw new NullPointerException("DeliveryRequest cannot be null");
        }
        if (courier == null) {
            throw new NullPointerException("Creature cannot be null");
        }
        if (sealedLabel == null) {
            throw new NullPointerException("Label cannot be null");
        }
        
        // This handles the IllegalArgumentException for negative prices in 'invalidPlans'
        if (priceInCoins < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.request = request;
        this.courier = courier;
        this.sealedLabel = sealedLabel;
        this.priceInCoins = priceInCoins;
    }

    public DeliveryRequest getRequest() { return request; }
    public Creature getCourier() { return courier; }
    public String getSealedLabel() { return sealedLabel; }
    public int getPriceInCoins() { return priceInCoins; }

    // Required for the 'planValues' test in DeliveryPlanTest
    public String summary() {
        return String.format("%s delivers %s for %d coins", 
                             courier.name(), sealedLabel, priceInCoins);
    }
}