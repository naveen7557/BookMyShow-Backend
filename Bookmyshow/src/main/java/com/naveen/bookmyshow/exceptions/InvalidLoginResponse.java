
package com.naveen.bookmyshow.exceptions;

public class InvalidLoginResponse {
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;

    public InvalidLoginResponse() {
        this.userName = "Invalid Username";
        this.email = "Invalid Email";
        this.password = "Invalid Password";
        this.confirmPassword = "Invalid Password";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

