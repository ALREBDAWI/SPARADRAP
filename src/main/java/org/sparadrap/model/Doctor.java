package org.sparadrap.model;

public class Doctor extends AbstractEntity {
    private  String lastName;
    private  long approvalNumber ;

    // ---------- constructor ---------

    public Doctor(String name, String address, int postalCode, String city, String email, long telephone, String lastName, long approvalNumber) {
        super(name, address, postalCode, city, email, telephone);
        setLastName(lastName);
        setApprovalNumber(approvalNumber);
    }

    // ---------- getters and setters ------------

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getApprovalNumber() {
        return this.approvalNumber;
    }
    public void setApprovalNumber(long approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    // ---------- print info ---------------

    public void displayInfo(){
        System.out.println("---- Doctor Information ----");
        System.out.printf("%-25s: %s%n", "Last Name", lastName);
        displayCommonInfo();
        System.out.printf("%-25s: %d%n", "Approval Number", approvalNumber);
        System.out.println("----------------------------");
    }

}



