package tech.linjuliwhu.implement;

import tech.linjuliwhu.domain.User;
import tech.linjuliwhu.mapper.UserMapper;
import tech.linjuliwhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String openId) {
        return userMapper.selectById(openId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }
}
