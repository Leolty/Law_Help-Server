package tech.linjuliwhu.service;

import tech.linjuliwhu.domain.AttachFile;

import java.util.List;

public interface AttachFileService {
    int addNewFile(AttachFile attachFile);

    List<AttachFile> getFilesBuyLinkId(String linkId);
}
