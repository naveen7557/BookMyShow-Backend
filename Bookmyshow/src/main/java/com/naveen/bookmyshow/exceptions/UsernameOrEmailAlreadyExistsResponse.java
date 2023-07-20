package com.naveen.bookmyshow.exceptions;

import lombok.Data;

@Data
public class UsernameOrEmailAlreadyExistsResponse {
    private  String userName;
    private String email;

    public UsernameOrEmailAlreadyExistsResponse(String userName , String email) {
        this.userName = userName;
        this.email = email;

    }
}
