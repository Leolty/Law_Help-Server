package tech.linjuliwhu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import tech.linjuliwhu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "UserMapper")
public interface UserMapper extends BaseMapper<User> {

}

