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
        String regex = "^\\p{L}+(?:[ '\\-]\\p{L}+)*$";
        if (name.matches(regex)) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Invalid name!");
        }
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        String regex = "^[0-9A-Za-z\\s.,'#-]+$";
        if (address.matches(regex)) {
            this.address = address;
        }else{
            throw new IllegalArgumentException("Invalid address!");
        }
    }

    public String getPostalCode() {
        return this.postalCode;
    }
    public void setPostalCode(String postalCode) {
        String regex = "^[0-9\\p{L}\\s.,'#-]+$";
        if (postalCode.matches(regex)) {
            this.postalCode = postalCode;
        }else{
            throw new IllegalArgumentException("Invalid postal code!");
        }
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        String regex = "^\\p{L}+(?:[ '\\-]\\p{L}+)*$";
        if(city.matches(regex)) {
            this.city = city;
        }else {
            throw new IllegalArgumentException("Invalid city name!");
        }
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email.matches(regex)) {
            this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid email!");
        }
    }

    public String getTelephone() {
        return this.telephone;
    }
    public void setTelephone(String telephone) {
        String regex = "^\\+?[0-9\\s()-]{7,15}$";//general for all countries
        if (telephone.matches(regex)) {
            this.telephone = telephone;
        }else{
            throw new IllegalArgumentException("Invalid telephone number!");
        }
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
