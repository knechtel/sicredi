package com.demo.sicredi.DTO;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class UserDTO {

    private String status;

    public  UserDTO(String status){
        this.status=status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
