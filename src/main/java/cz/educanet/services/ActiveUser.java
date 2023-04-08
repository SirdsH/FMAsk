package cz.educanet.services;

import cz.educanet.modes.UserModel;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class ActiveUser implements Serializable {
    private UserModel activeUser;

    public UserModel getCurrentUser() {
        return activeUser;
    }

    public void setCurrentUser(UserModel activeUser) {
        this.activeUser = activeUser;
    }
}
