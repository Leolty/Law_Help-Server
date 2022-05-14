package tech.linjuliwhu.implement;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.linjuliwhu.domain.AttachFile;
import tech.linjuliwhu.mapper.AttachFileMapper;
import tech.linjuliwhu.service.AttachFileService;

import java.util.List;

@Service("AttachFileServiceImpl")
public class AttachFileServiceImpl implements AttachFileService {
    @Autowired
    private AttachFileMapper attachFileMapper;

    @Override
    public int addNewFile(AttachFile attachFile) {
        return attachFileMapper.insert(attachFile);
    }

    @Override
    public List<AttachFile> getFilesBuyLinkId(String linkId) {
        return attachFileMapper.selectList(new EntityWrapper<AttachFile>()
                .eq("LINK_ID", linkId));
    }
}
