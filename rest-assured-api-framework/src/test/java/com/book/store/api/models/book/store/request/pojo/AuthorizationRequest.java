package com.book.store.api.models.book.store.request.pojo;

public class AuthorizationRequest {
    public String userName;
    public String password;

    public AuthorizationRequest(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
