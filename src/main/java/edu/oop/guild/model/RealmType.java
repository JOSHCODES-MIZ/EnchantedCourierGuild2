package edu.oop.guild.model;

public enum RealmType {
	SKY("Sky Kingdom"),
    UNDERGROUND("Underground Market");

    private final String displayName;

    RealmType(String displayName) {
        this.displayName = displayName;
    }

    // Line 25 of the test calls .displayName()
    public String displayName() {
        return displayName;
    }
}
