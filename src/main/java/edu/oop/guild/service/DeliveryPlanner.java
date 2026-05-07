package edu.oop.guild.service;

import edu.oop.guild.factory.RealmFactory;
import edu.oop.guild.log.GuildLog;
import edu.oop.guild.model.DeliveryPlan;
import edu.oop.guild.model.DeliveryRequest;
import edu.oop.guild.strategy.DeliveryCostStrategy;
import edu.oop.guild.creature.Creature;
import edu.oop.guild.seal.PackageSeal;

public class DeliveryPlanner {
	private final RealmFactory realmFactory;
    private final DeliveryCostStrategy strategy;
    private final GuildLog log;

    public DeliveryPlanner(RealmFactory realmFactory, DeliveryCostStrategy strategy, GuildLog log) {
        // Enforce the null checks found in the test
        this.realmFactory = Objects.requireNonNull(realmFactory);
        this.strategy = Objects.requireNonNull(strategy);
        this.log = Objects.requireNonNull(log);
    }

    public DeliveryPlan plan(DeliveryRequest request) {
        if (request == null) throw new NullPointerException();

        Creature courier = realmFactory.createCourier();
        PackageSeal seal = realmFactory.createSeal();

       
        if (request.getDestinationRealm() != realmFactory.getRealm()) {
            throw new IllegalStateException("Courier cannot reach this realm");
        }

        
        int price = strategy.estimateCoins(request);
        String label = seal.apply(request.summary());

        
        DeliveryPlan plan = new DeliveryPlan(courier, request, price, label);

        
        log.addEntry(plan.summary());

        return plan;
    }
}
