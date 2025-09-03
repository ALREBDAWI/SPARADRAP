package org.sparadrap.model;

public abstract class AbstractEntity {
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String email;
    private String telephone;

    // ---------- constructor -------

    public  AbstractEntity(String name, String address, String postalCode, String city, String email, String telephone) {
        setName(name);
        setAddress(address);
        setPostalCode(postalCode);
        setCity(city);
        setEmail(email);
        setTelephone(telephone);
    }

    // ---------- getters and setters ----------

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    protected void displayCommonInfo() {
        System.out.printf("%-25s: %s%n", "Name", name);
        System.out.printf("%-25s: %s%n", "Address", address);
        System.out.printf("%-25s: %s%n", "Postal Code", postalCode);
        System.out.printf("%-25s: %s%n", "City", city);
        System.out.printf("%-25s: %s%n", "Email", email);
        System.out.printf("%-25s: %s%n", "Telephone", telephone);
    }

}
