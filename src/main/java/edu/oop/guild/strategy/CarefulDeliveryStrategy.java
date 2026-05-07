package edu.oop.guild.strategy;

import edu.oop.guild.model.DeliveryRequest;

public class CarefulDeliveryStrategy implements DeliveryCostStrategy{
	@Override
    public int estimateCoins(DeliveryRequest request) {
        if (request == null) throw new NullPointerException();
        
        int base = (request.getWeightKg() * 3) + (request.getDistanceLeagues() * 3);
        
        int typeCharge = switch (request.getPackageType()) {
            case FOOD -> 16;
            case POTION -> 21;
            case ARTIFACT -> 33;
        };
        
        return base + typeCharge;
    }

}
