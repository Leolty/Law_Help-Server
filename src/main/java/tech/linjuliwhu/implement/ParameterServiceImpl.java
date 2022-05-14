package tech.linjuliwhu.implement;

import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.mapper.ParameterMapper;
import tech.linjuliwhu.service.ParameterService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ParameterService")
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public Parameter getParamValueByName(String paramName) {
        List<Parameter> parameterList = parameterMapper.selectList(new EntityWrapper<Parameter>()
                .eq("PARAM_KEY", paramName));
        return parameterList.isEmpty() ? null : parameterList.get(0);
    }
}
