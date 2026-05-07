package edu.oop.guild.notification;

import edu.oop.guild.model.DeliveryPlan;
import edu.oop.guild.model.RealmType;

public class OwlScrollNotificationAdapter implements NotificationChannel {
    private final LegacyOwlScroll owlScroll;

    public OwlScrollNotificationAdapter(LegacyOwlScroll owlScroll) {
        if (owlScroll == null) {
            throw new NullPointerException("LegacyOwlScroll cannot be null");
        }
        this.owlScroll = owlScroll;
    }

    @Override
    public String send(DeliveryPlan plan) {
        if (plan == null) {
            throw new NullPointerException("DeliveryPlan cannot be null");
        }

        // The test expects "Sky Kingdom" instead of "SKY"
        String recipient = formatRealmName(plan.getRequest().getDestinationRealm());
        
        // Use the summary() method we created in DeliveryPlan
        String inscription = plan.summary();

        return owlScroll.dispatchScroll(recipient, inscription);
    }

    private String formatRealmName(RealmType realm) {
        // Simple mapping to match the test expectation of "Sky Kingdom"
        return switch (realm) {
            case SKY -> "Sky Kingdom";
            case UNDERDARK -> "Underdark";
            case GLACIER -> "Glacier";
        };
    }
}