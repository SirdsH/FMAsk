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
public class LoginBean {
    @Inject
    private UserService userServices;

    private UserModel loginUser = new UserModel("", "", "");

    public void login() throws IOException {
        this.userServices.login(loginUser);
        FacesContext.getCurrentInstance().getExternalContext().redirect("loggedIn.xhtml");
    }

    public UserModel getLoginUser() {
        return loginUser;
    }
}
