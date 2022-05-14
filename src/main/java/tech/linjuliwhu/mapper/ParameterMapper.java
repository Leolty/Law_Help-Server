package tech.linjuliwhu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import tech.linjuliwhu.domain.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "ParameterMapper")
public interface ParameterMapper extends BaseMapper<Parameter> {

}

