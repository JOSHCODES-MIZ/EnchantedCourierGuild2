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

        // 1. Get the tools from the Factory
        Creature courier = realmFactory.createCourier();
        PackageSeal seal = realmFactory.createSeal();

        // 2. Validate realm (Test: rejectsPlansWhenCourierCannotCarryPackage)
        // If the factory for Sky is used for an Underground request, throw error
        if (request.getDestinationRealm() != realmFactory.getRealm()) {
            throw new IllegalStateException("Courier cannot reach this realm");
        }

        // 3. Calculate Price and Label
        int price = strategy.estimateCoins(request);
        String label = seal.apply(request.summary());

        // 4. Create the Plan
        DeliveryPlan plan = new DeliveryPlan(courier, request, price, label);

        // 5. Log the delivery (Test: plansSkyDelivery checks the log)
        log.addEntry(plan.summary());

        return plan;
    }
}
