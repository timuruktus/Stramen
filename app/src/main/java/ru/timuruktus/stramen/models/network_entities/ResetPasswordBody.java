package ru.timuruktus.stramen.models.network_entities;

public class ResetPasswordBody{

    private String email;

    public ResetPasswordBody(String email){
        this.email = email;
    }

    public ResetPasswordBody(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
