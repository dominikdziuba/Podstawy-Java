package data;

public enum ActivityLevel {
    NO_ACTIVITY("Brak aktywności"),
    LOW_ACTIVITY("Niska aktywność"),
    MEDIUM_ACTIVITY("Średnia aktywność"),
    HIGH_ACTIVITY("Wysoka aktywność"),
    EXTREME_ACTIVITY("Ekstremalna aktywność");


    private final String actv;

    ActivityLevel(String a) {
        this.actv = a;
    }

    public String toString(){
        return actv;
    }
}
