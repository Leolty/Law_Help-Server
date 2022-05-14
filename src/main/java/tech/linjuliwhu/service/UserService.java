package tech.linjuliwhu.service;

import tech.linjuliwhu.domain.User;

public interface UserService {
    User getUserById(String openId);

    int insertUser(User user);

    int updateUser(User user);
}
