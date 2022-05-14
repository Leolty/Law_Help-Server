package tech.linjuliwhu.mapper;

import tech.linjuliwhu.domain.Question;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "QuestionMapper")
public interface QuestionMapper extends BaseMapper<Question> {
}
