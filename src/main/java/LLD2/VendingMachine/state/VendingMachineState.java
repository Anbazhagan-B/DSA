package LLD2.VendingMachine.state;

import LLD2.VendingMachine.VendingMachine;
import LLD2.VendingMachine.enums.Coins;

public abstract class VendingMachineState {
    public VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    public abstract void dispense();
    public abstract void refund();
    public abstract void selectItem(String itemCode);
    public abstract void insertCoin(Coins coins);
}
