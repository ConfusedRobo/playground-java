package company.test;

public class Profile {
    private final long profileID;
    private final String name;
    private final int age;
    private final String personality;
    private final boolean adult;

    public Profile(String name, int age, String personality, boolean adult, long profileID) {
        this.name = name;
        this.age = age;
        this.personality = personality;
        this.adult = adult;
        this.profileID = profileID;
    }

    public void viewProfile() {
        System.out.println("ID - " + profileID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Adult: " + this.adult);
        System.out.println("Personality: " + this.personality);
    }
}
