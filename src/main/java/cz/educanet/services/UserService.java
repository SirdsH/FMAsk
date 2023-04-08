package cz.educanet.services;

import cz.educanet.modes.UserModel;
import cz.educanet.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named
public class UserService {

    @Inject
    private UserRepository userRepository;
    @Inject
    private ActiveUser activeUser;

    public void register(UserModel userModel) {
        this.userRepository.register(userModel);
    }

    public UserModel login(UserModel userModel) {
        UserModel user = this.userRepository.login(userModel);
        activeUser.setCurrentUser(user);
        return user;
    }

    public List<UserModel> getUsers() {
        return this.userRepository.getUsers();
    }
}
