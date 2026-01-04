package LLD2.VendingMachine.enums;

public enum Coins {
    PENNY(1),
    NICKEL(2),
    DIME(5),
    QUARTER(15);

    private final int value;
    Coins(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
