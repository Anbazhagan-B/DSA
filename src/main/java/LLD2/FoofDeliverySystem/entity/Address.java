package LLD2.FoofDeliverySystem.entity;

public class Address {
    String city;
    String street;
    String zipCode;
    double latitude;
    double longitude;

    public Address(String city, String street, String zipCode, double latitude, double longitude)
    {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDifference(Address address)
    {
        double latitudeDifference = this.latitude - address.latitude;
        double longitudeDifference = this.longitude - address.longitude;
        return Math.sqrt(latitudeDifference * latitudeDifference + longitudeDifference * longitudeDifference);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}
