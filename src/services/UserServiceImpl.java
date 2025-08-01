package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private ArrayList<User> users;

    public UserServiceImpl(){
        users = new ArrayList<User>();
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public User getUser(Long id) {
        int i = 0;
        while(users.get(i).getId()!=id && i<users.size()){
            i++;
        }
        if (i<users.size()){
            return users.get(i);
        }else{
            return null;
        }
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) users;
    }

    @Override
    public void updateUser(Long id, User user) {
        int i = 0;

        while (users.get(i).getId()!=id && i<users.size()){
            i++;
        }
        if (i<users.size()){
            users.get(i).setFirstName(user.getFirstName());
            users.get(i).setLastName(user.getLastName());
            users.get(i).setEmail(user.getEmail());
            users.get(i).setPhoneNumber(user.getPhoneNumber());
        }
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId()==id);
    }
}
