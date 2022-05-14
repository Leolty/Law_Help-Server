package tech.linjuliwhu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tech.linjuliwhu.domain.QueRoot;

@Mapper
@Component(value = "QueRootMapper")
public interface QueRootMapper extends BaseMapper<QueRoot> {
}
