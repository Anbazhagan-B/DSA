package LLD2.VendingMachine;

import LLD2.VendingMachine.entity.Inventory;
import LLD2.VendingMachine.entity.Item;
import LLD2.VendingMachine.enums.Coins;
import LLD2.VendingMachine.state.IdleState;
import LLD2.VendingMachine.state.VendingMachineState;

public class VendingMachine {

    private  static final VendingMachine instance = new VendingMachine();
    VendingMachineState vendingMachineState;
    Inventory inventory = new Inventory();
    int balance = 0;
    String selectedItemCode;

    public VendingMachine()
    {
        this.vendingMachineState = new IdleState(this);
    }

    public static VendingMachine getInstance() {
        return instance;
    }

    public Item addItem(String itemCode, String itemName, int price, int quantity)
    {
        Item item = new Item(itemName, itemCode, price);
        inventory.addItem(itemCode, item, quantity);

        return item;
    }

    public void insertCoin(Coins coins)
    {
        vendingMachineState.insertCoin(coins);
    }

    public void dispense()
    {
        vendingMachineState.dispense();
    }

    public void selectItem(String itemCode)
    {
        vendingMachineState.selectItem(itemCode);
    }

    public void dispenseItem(String itemCode)
    {
        Item item = inventory.getItem(itemCode);
        if(balance >= item.getPrice())
        {
            inventory.reduceQuantity(itemCode);
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());

            if(balance > 0 )
            {System.out.println("Returning Balance");}
        }
        reset();
        setVendingMachineState(new IdleState(this));
    }

    public void reset()
    {
        balance = 0;
        selectedItemCode = null;
    }

    public void addBalance(int value)
    {
        balance += value;
    }

    public Item getSelectedItem()
    {
        return inventory.getItem(selectedItemCode);
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public int getBalance() {
        return balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }
}
