package tech.linjuliwhu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tech.linjuliwhu.domain.QueUserAsk;

@Mapper
@Component(value = "QueUserAskMapper")
public interface QueUserAskMapper extends BaseMapper<QueUserAsk> {
}
