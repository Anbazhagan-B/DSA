package LLD2.OnlineShoppingService.models;

public class Address {
    final String street;
    final String city;
    final String state;
    final String zipCode;

    public Address(String street, String city , String state, String zipcode)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
    }


    @Override
    public String toString() {
        return String.format("%s, %s, %s %s", street, city, state, zipCode);
    }
}
