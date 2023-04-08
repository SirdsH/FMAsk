package cz.educanet.bean;

import cz.educanet.services.ActiveUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class LogOutBean {
    @Inject
    private ActiveUser activeUser;

    public void LogOut() throws IOException {
        activeUser.setCurrentUser(null);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
}
