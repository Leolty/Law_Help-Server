package tech.linjuliwhu.service;

import tech.linjuliwhu.domain.QueAnswer;
import tech.linjuliwhu.domain.QueRoot;
import tech.linjuliwhu.domain.Question;
import tech.linjuliwhu.util.FatherQue;

import java.util.List;

public interface QueService {
    List<QueRoot> getQueRootByVersion(int parseInt);

    Question getQuestionById(String queId);

    List<Question> getSubsById(String queId);

    QueAnswer getAnsByQueId(String queId);

    int addQueRoot(String rootName, String rootVersion, String queId);

    int addQueWithRootLocation(String userId, String queText, String queId);

    int addQueNode(Question question);

    int addQueLeaf(Question question);

    int addQueAnswer(Question question, String ansStr);

    List<FatherQue> getFatherQuesByQueId(String queId);
}
