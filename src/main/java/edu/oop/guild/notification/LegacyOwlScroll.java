package edu.oop.guild.notification;

public class LegacyOwlScroll {
    public String dispatchScroll(String recipient, String inscription) {
        // Validation for 'invalidScrolls'
        if (recipient == null || recipient.isBlank() || 
            inscription == null || inscription.isBlank()) {
            throw new IllegalArgumentException("Inputs cannot be blank");
        }
        
        // Match the exact format in the assertEquals
        return "Owl scroll sent to " + recipient + ": " + inscription;
    }
}