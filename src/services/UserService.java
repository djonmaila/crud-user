package services;

import models.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User getUser(Long id);
    List<User> getAllUser();
    void updateUser(Long id,User user);
    void deleteUser(Long id);
}
