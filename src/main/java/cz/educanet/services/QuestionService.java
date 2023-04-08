package cz.educanet.services;

import cz.educanet.modes.QuestionModel;
import cz.educanet.modes.UserModel;
import cz.educanet.repository.QuestionRepository;
import cz.educanet.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named
public class QuestionService {
    @Inject
    private QuestionRepository questionRepository;

    private List<QuestionModel> questionModel = null;
    private UserModel userModel = null;

    public void askQuestion(QuestionModel questionModel) {
        questionRepository.askQuestion(questionModel);
    }

    public List<QuestionModel> getQuestions() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (userModel == null || userModel.getUserId() != Integer.parseInt(id)) {
            questionModel = questionRepository.getSpecificQuestion(Integer.parseInt(id));
        }
        return questionModel;
    }
}
