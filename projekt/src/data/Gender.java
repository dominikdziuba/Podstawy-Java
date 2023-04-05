package data;

public enum Gender {
    MALE("Mężczyzna"),
    FEMALE("Kobieta");

    private final String gender;

    Gender(String g) {
        this.gender = g;
    }
    public String toString(){
        return gender;
    }

}
