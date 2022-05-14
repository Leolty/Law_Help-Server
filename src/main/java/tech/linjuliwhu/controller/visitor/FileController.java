package tech.linjuliwhu.controller.visitor;

import tech.linjuliwhu.config.UploadConfig;
import tech.linjuliwhu.domain.AttachFile;
import tech.linjuliwhu.service.AttachFileService;
import tech.linjuliwhu.util.FileUtil;
import tech.linjuliwhu.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/visitor/file")
@Component("FileController")
public class FileController {
    @Autowired
    private AttachFileService attachFileService;

    @Autowired
    private UploadConfig uploadConfig;

    @PostMapping("/upload")
    public HashMap<String, String> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
        HashMap<String, String> response = new HashMap<>();
        if (files != null && files.length >= 1) {
            try {
                for (MultipartFile file : files) {
                    // String fileName = file.getOriginalFilename();
                    // 文件后缀与文件名
                    String type = FileUtil.getFileTypePostFix(Objects.requireNonNull(file.getOriginalFilename()));
                    String fileName = UUID.randomUUID().toString().substring(0, 10) + type;
                    // 按用户ID，分类建文件夹
                    String userId = request.getParameter("userId");
                    String userIdAndDateToday = "images/" + userId + "/" + MyConstants.DATE_FORMAT.format(new Date()) + "/";
                    String filePath = uploadConfig.getUploadPath() + userIdAndDateToday;
                    FileUtil.uploadFile(file.getBytes(), filePath, fileName);
                    // 数据库相关
                    AttachFile attachFile = new AttachFile();
                    attachFile.setFileId(UUID.randomUUID().toString());
                    attachFile.setFileUrl(uploadConfig.getStaticPath() + "/" + userIdAndDateToday + fileName);
                    attachFile.setFileType(type);
                    attachFile.setLinkId(request.getParameter("linkId"));
                    attachFile.setLinkType(Integer.parseInt(request.getParameter("linkType")));
                    attachFileService.addNewFile(attachFile);

                    response.put("state", MyConstants.RESULT_OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.put("state", MyConstants.RESULT_FAIL);
            }
        }
        return response;
    }
}
