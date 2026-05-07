package edu.oop.guild.strategy;

import edu.oop.guild.model.DeliveryRequest;

public class ExpressDeliveryStrategy implements DeliveryCostStrategy{
	@Override
    public int estimateCoins(DeliveryRequest request) {
        if (request == null) throw new NullPointerException();
        
        int base = (request.getWeightKg() * 3) + (request.getDistanceLeagues() * 3);
        int cost = (base * 2) + 5;
        if (request.isFragile()) {
            cost += 10;
        }
        return cost;
    }
}
