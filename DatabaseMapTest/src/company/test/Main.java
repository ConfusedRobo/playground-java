package company.test;

public class Main {

    public static void main(String[] args) {
        Database hospitalDB = new Database("Hospital patients");

        hospitalDB.addProfile("Rajat Biswas", 19, "Mediocre", true, 2276);
        hospitalDB.addProfile("Earl Ryanhertz", 20, "Shy", true, 5460);
        hospitalDB.addProfile("Samson Jamanaguh", 12, "Righteous", false, 3534);
        hospitalDB.addProfile("Lenia Burningrose", 10, "Prideful", false, 7868);
        hospitalDB.addProfile("Wrath Novachronos", 9, "God-complex", false, 1234);

        System.out.println("Field: " + hospitalDB.getField());
        hospitalDB.viewAll();
        System.out.println();

        hospitalDB.removeProfile(5460);
        hospitalDB.viewAll();
    }
}
