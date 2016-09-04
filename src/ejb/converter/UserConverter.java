package ejb.converter;

import api.dto.UserDto;
import model.entity.User;

/**
 * Created by simon on 04/09/16.
 */
public class UserConverter {

    public static class toEntity {

        public static SuperConverter<UserDto,User> toUserEntity =
                userDto -> {
                    User user = new User();
                    user.setId(null);
                    user.setCod(userDto.getUsername());
                    user.setPassword(userDto.getPassword());
                    return user;
                };

    }
}
