package tech.linjuliwhu.mapper;

import tech.linjuliwhu.domain.AttachFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "AttachFileMapper")
public interface AttachFileMapper extends BaseMapper<AttachFile> {
}
