package tech.linjuliwhu.mapper;

import tech.linjuliwhu.domain.QueAnswer;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "QueAnswerMapper")
public interface QueAnswerMapper extends BaseMapper<QueAnswer> {
}
