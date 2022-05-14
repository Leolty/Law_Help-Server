package tech.linjuliwhu.service;

import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.domain.QueUserAsk;

import java.util.List;

public interface QueUserAskService {
    int addAsk(QueUserAsk queUserAsk, Parameter mpVersionParam);

    int replyAsk(String askId, String answerUserId, String queAnswer);

    List<QueUserAsk> getMyAskBySAV(String userId, int askStatus, Parameter mpVersionParam);

    List<QueUserAsk> getMyAskAll(String userId, Parameter mpVersionParam);

    List<QueUserAsk> getAskBySAV(int queAskStatus, Parameter mpVersionParam);

    List<QueUserAsk> getPublicAskBySAV(int queAskStatus, Parameter mpVersionParam);

    List<QueUserAsk> getAllAsks(Parameter mpVersionParam);

    QueUserAsk getAskById(String askId);
}
