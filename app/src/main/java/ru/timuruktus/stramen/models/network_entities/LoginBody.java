package ru.timuruktus.stramen.models.network_entities;

public class LoginBody{

    private String email;
    private String password;

    public LoginBody(String email, String password){
        this.email = email;
        this.password = password;
    }

    public LoginBody(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
