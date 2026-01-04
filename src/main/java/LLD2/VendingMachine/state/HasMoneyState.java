package LLD2.VendingMachine.state;

import LLD2.VendingMachine.VendingMachine;
import LLD2.VendingMachine.enums.Coins;

public class HasMoneyState extends VendingMachineState{

    public HasMoneyState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }

    @Override
    public void dispense() {
        this.vendingMachine.dispenseItem(vendingMachine.getSelectedItem().getCode());
        this.vendingMachine.setVendingMachineState(new DispensingState(vendingMachine));
    }

    @Override
    public void refund() {
        this.vendingMachine.refundBalance();
        this.vendingMachine.reset();
        this.vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Item Already Selected");
    }

    @Override
    public void insertCoin(Coins coins) {
        System.out.println("Coin already Inserted");
    }
}
