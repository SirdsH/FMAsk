package cz.educanet.bean;

import cz.educanet.modes.UserModel;
import cz.educanet.services.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class RegisterBean {
    @Inject
    private UserService userServices;

    private UserModel registerUser = new UserModel("", "", "", "");

    public void register() throws IOException {
        this.userServices.register(registerUser);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public UserModel getRegisterUser() {
        return registerUser;
    }
}
