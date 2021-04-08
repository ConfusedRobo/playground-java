package company.test;

public class General implements Cavalry, Soldier {
    public General() {
        callSoldier();
        callCavalry();
        callArmy();
    }

    @Override
    public void callSoldier() {
        System.out.println(totalSoldiers + " soldiers has been summoned.");
    }

    @Override
    public void callCavalry() {
        System.out.println(totalCavalries + " cavalries has been summoned.");
    }

    @Override
    public void callArmy() {
        System.out.println(totalPersonnel + " army personnel has been called.");
    }
}
