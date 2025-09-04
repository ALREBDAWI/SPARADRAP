package org.sparadrap.model;

public class Doctor extends AbstractEntity {
    private  String lastName;
    private  String approvalNumber ;

    // ---------- constructor ---------

    public Doctor(String name, String address, String postalCode, String city, String email, String telephone, String lastName, String approvalNumber) {
        super(name, address, postalCode, city, email, telephone);
        setLastName(lastName);
        setApprovalNumber(approvalNumber);
    }

    // ---------- getters and setters ------------

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        String regex = "^\\p{L}+(?:[ '\\-]\\p{L}+)*$";
        if (lastName.matches(regex)) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    public String getFullName(){
        return this.getName() + " " + this.getLastName();
    }

    public String getApprovalNumber() {
        return this.approvalNumber;
    }
    public void setApprovalNumber(String approvalNumber) {
        String regex = "^[A-Za-z0-9_-]{5,15}$";
        if (approvalNumber.matches(regex)) {
            this.approvalNumber = approvalNumber;
        }else{
            throw new IllegalArgumentException("Invalid approval number");
        }
    }

    // ---------- print info ---------------


    public void displayInfo(){
        System.out.println("---- Doctor Information ----");
        System.out.printf("%-25s: %s%n", "Last Name", lastName);
        displayCommonInfo();
        System.out.printf("%-25s: %s%n", "Approval Number", approvalNumber);
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Doctor Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Name", getFullName()));
        sb.append(String.format("%-25s: %s%n", "City", getCity()));
        sb.append(String.format("%-25s: %s%n", "Phon Number", getTelephone()));
        sb.append(String.format("%-25s: %s%n", "Approval Number", getApprovalNumber() ));
        sb.append("--------------------------------\n");
        return sb.toString();
    }


}



