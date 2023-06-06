package com.example.exercice_07;

public class Identity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

    //region Constructors
    public Identity() {

    }

    public Identity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password ;
    }

    public Identity(Identity identity) {
        this.firstName = identity.firstName;
        this.lastName = identity.lastName;
        this.email = identity.email;
        this.password = identity.password ;
    }
}


