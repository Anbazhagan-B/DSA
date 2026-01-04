package LLD2.FoofDeliverySystem.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    final Map<String, MenuItem> menuItems = new HashMap<>();

    public void addItem(MenuItem menuItem)
    {
        menuItems.put(menuItem.getId(), menuItem);
    }

    public MenuItem getItem(String menuItemId)
    {
        return menuItems.get(menuItemId);
    }

    public Map<String, MenuItem> getMenuItems()
    {
        return menuItems;
    }
}
