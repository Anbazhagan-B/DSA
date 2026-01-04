package LLD2.VendingMachine.state;

import LLD2.VendingMachine.VendingMachine;
import LLD2.VendingMachine.enums.Coins;

public class IdleState extends VendingMachineState{

    public IdleState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }

    @Override
    public void dispense() {
        System.out.println("No item selected.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }

    @Override
    public void selectItem(String itemCode) {
        if(!this.vendingMachine.getInventory().isAvailable(itemCode))
        {
            throw  new RuntimeException("Item Not Available");
        }
        this.vendingMachine.setSelectedItemCode(itemCode);
        this.vendingMachine.setVendingMachineState(new ItemSelectedState(vendingMachine));
        System.out.println("Item selected: " + itemCode);

    }


    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Please select an item before inserting money.");
    }
}
