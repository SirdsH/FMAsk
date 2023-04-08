package cz.educanet.services;

import cz.educanet.modes.UserModel;
import cz.educanet.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named
public class SpecificUser {
    @Inject
    private UserRepository userRepository;

    private UserModel userModel = null;

    public UserModel getSpecificUser() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (userModel == null || userModel.getUserId() != Integer.parseInt(id)) {
            userModel = userRepository.specificUser(Integer.parseInt(id));
        }
        return userModel;
    }
}
