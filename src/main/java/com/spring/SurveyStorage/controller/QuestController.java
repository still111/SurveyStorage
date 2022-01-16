package com.spring.SurveyStorage.controller;

import com.spring.SurveyStorage.entity.Question;
import com.spring.SurveyStorage.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    private final QuestService questService;
    private int survey_id;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @RequestMapping("showAllQuestions")
    public String showQuestions (Model model ){
        List<Question> questions = questService.getAllQuestions();
        model.addAttribute("allQuest", questions);
        return "all-quest";
    }

    @RequestMapping("showDetQuests")
    public String showDetQuest(@RequestParam("survey_id") int survey_id, Model  model){
        List<Question>  questions = questService.getDetQuestion(survey_id);
        this.survey_id = survey_id;
        model.addAttribute("allQuest", questions);
        return "all-quest";
    }
    @RequestMapping("selectDetQuests")
    public String selectDetQuest(@RequestParam("survey_id") int survey_id, Model  model){
        List<Question>  questions = questService.getDetQuestion(survey_id);
        this.survey_id = survey_id;
        model.addAttribute("allQuest", questions);
        return "pick-survey";
    }

    @RequestMapping("addQuest")
        public String addNewQuestion(
                @RequestParam("survey_id") int survey_id
            ,Model  model){
        this.survey_id = survey_id;
        Question question = new Question();
        model.addAttribute("survey_id", survey_id);
        model.addAttribute("question", question);
        return "quest-info";
    }

    @RequestMapping("saveQuest")
    public String saveQuest(@ModelAttribute("question") Question question){
        questService.saveQuestion(survey_id,question);
        return "redirect:/showAllSurveys";
    }


    @RequestMapping("/updateQuest")
    public String updateSurvey(@RequestParam("quest_id") int id, Model model){
        Question question =  questService.getQuest(id);
        model.addAttribute("question",question);
        return "quest-info";
    }

    @RequestMapping("/deleteQuest")
    public String deteteSurvey(@RequestParam ("quest_id") int id){
        questService.deleteQuest(id);
        return "redirect:/showAllSurveys";
    }
}
