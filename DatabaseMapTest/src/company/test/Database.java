package company.test;

import java.util.HashMap;

public class Database {
    private final HashMap<Long, Profile> profiles;
    private final String field;

    public Database(String field) {
        this.profiles = new HashMap<>();
        this.field = field;
    }

    public void addProfile(String name, int age, String personality, boolean adult, long profileID) {
        if (!profiles.containsKey(profileID)) {
            profiles.put(profileID, new Profile(name, age, personality, adult, profileID));
            System.out.println("Added profile to map.");
        } else {
            System.out.println("Unable to add. Profile already exists.");
        }
    }

    public void removeProfile(long profileID) {
        if (!profiles.containsKey(profileID)) {
            System.out.println("Unable to remove. Profile doesn't exist.");
        } else {
            profiles.remove(profileID);
            System.out.println("Profile removed successfully.");
        }
    }

    public void viewAll() {
        if (profiles.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (long key : profiles.keySet()) {
                System.out.println("=======================================");
                profiles.get(key).viewProfile();
                System.out.println("=======================================");
            }
        }
    }

    public String getField() {
        return field;
    }
}
