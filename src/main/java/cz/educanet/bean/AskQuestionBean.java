package cz.educanet.bean;

import cz.educanet.modes.QuestionModel;
import cz.educanet.services.QuestionService;
import cz.educanet.services.SpecificUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class AskQuestionBean {
    @Inject
    private QuestionService questionService;
    @Inject
    private SpecificUser specificUser;

    private QuestionModel questionModel = new QuestionModel("", null);

    public void askQuestion() {
        questionModel.setTargetID(specificUser.getSpecificUser());
        questionService.askQuestion(questionModel);
    }

    public QuestionModel getAskQuestionModel() {
        return questionModel;
    }
}
