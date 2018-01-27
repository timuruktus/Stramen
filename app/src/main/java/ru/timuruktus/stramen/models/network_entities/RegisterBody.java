package ru.timuruktus.stramen.models.network_entities;

public class RegisterBody{

    private String email;
    private String username;
    private String password1;
    private String password2;

    public RegisterBody(String email, String username, String password1, String password2){
        this.email = email;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public RegisterBody(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword1(){
        return password1;
    }

    public void setPassword1(String password1){
        this.password1 = password1;
    }

    public String getPassword2(){
        return password2;
    }

    public void setPassword2(String password2){
        this.password2 = password2;
    }
}
