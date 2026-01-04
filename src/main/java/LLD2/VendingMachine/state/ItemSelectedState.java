package LLD2.VendingMachine.state;

import LLD2.VendingMachine.VendingMachine;
import LLD2.VendingMachine.enums.Coins;

public class ItemSelectedState extends VendingMachineState{

    public ItemSelectedState(VendingMachine vendingMachine)
    {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund() {
        vendingMachine.reset();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void insertCoin(Coins coins) {
        vendingMachine.addBalance(coins.getValue());

        System.out.println("Coin Inserted: " + coins.getValue());
        if(vendingMachine.getBalance() >= vendingMachine.getSelectedItem().getPrice())
        {
            System.out.println("Sufficient money received.");
            vendingMachine.setVendingMachineState(new HasMoneyState(vendingMachine));
        }

    }
}
