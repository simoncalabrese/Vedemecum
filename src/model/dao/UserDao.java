package model.dao;

import api.dto.UserDto;
import model.entity.User;

import java.util.List;

/**
 * Created by simon on 04/09/16.
 */
public class UserDao extends BaseDaoImplementation {

    public Boolean insertUser(User user) {
        return insert(user);

    }

    public void editUser(User user) {
        update(user);
    }


    public List<User> login(UserDto userDto) {
        return getAll(new User());
    }
}
