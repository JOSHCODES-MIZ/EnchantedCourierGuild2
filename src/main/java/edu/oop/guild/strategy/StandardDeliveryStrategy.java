package edu.oop.guild.strategy;

import edu.oop.guild.model.DeliveryRequest;

public class StandardDeliveryStrategy implements DeliveryCostStrategy{
	@Override
    public int estimateCoins(DeliveryRequest request) {
        if (request == null) throw new NullPointerException();
        
        int cost = (request.getWeightKg() * 3) + (request.getDistanceLeagues() * 3);
        if (request.isFragile()) {
            cost += 5;
        }
        return cost;
    }

}
