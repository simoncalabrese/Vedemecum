package ejb.service;

import api.dto.UserDto;
import ejb.converter.UserConverter;
import model.dao.UserDao;
import model.entity.User;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simon on 04/09/16.
 */

public class LoginService extends BaseService<UserDao> {

    private UserDao userDao = new UserDao();

    @Override
    public UserDao getDao() {
        return userDao;
    }

    public Boolean loginService(UserDto userDto) {
        List<User> users = getDao().login(userDto)
                .stream()
                .filter(user -> user.getCod().equals(userDto.getUsername().toUpperCase())
                        && user.getPassword().equals(userDto.getPassword().toUpperCase()))
                .collect(Collectors.toList());
        return !(users.isEmpty());
    }

    public Boolean signinService(UserDto userDto){
        if(getDao().insertUser(converter(userDto, UserConverter.toEntity.toUserEntity))){
            return true;
        }else {
            return false;
        }
    }
}
