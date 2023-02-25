package org.example.model;

public class Customer extends BaseModel{
    private String firstName;
    private String lastName;
    private String phone = "";
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        Customer customer = (Customer)obj;

        if(customer.phone.equals(this.phone)){
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return "Customer =" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
