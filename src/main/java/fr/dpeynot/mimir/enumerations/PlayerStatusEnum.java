package fr.dpeynot.mimir.enumerations;

public enum PlayerStatusEnum {
    ACTIVE("An active player"),
    INACTIVE("A player not seen recently"),
    HISTORICAL("The old guard. One of the most invested players the community never had"),
    MISSING_IN_ACTION("A player who left the community"),
    IN_MEMORIAM("An unforgettable player that unfortunately did not make it");

    public String description;

    PlayerStatusEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
}
