package com.spring.SurveyStorage.controller;

import com.spring.SurveyStorage.entity.Survey;
import com.spring.SurveyStorage.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final SurveyService surveyService;

    public MainController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "welcome";
    }

    @RequestMapping("showAllSurveys")
    public String showAllSurveys(Model model){
        List<Survey> surveys = surveyService.getAllSurveys();
        model.addAttribute("allSurv",surveys);
        return "all-Surveys";
    }

    @RequestMapping("addNewSurvey")
    public String addNewSurvey(Model model){
        Survey survey =new Survey();
        model.addAttribute("survey", survey);
        return "surv-Info";
    }

    @RequestMapping("saveSurvey")
    public String saveSurvey(@ModelAttribute("survey") Survey survey ){
        surveyService.saveSurvey(survey);
        return "redirect:showAllSurveys";
    }

    @RequestMapping("/updateSurvey")
    public String updateSurvey(@RequestParam("survey_id") int id, Model model){
        Survey survey =  surveyService.getSurvey(id);
        model.addAttribute("survey",survey);
        return "surv-Info";
    }

    @RequestMapping("deleteSurvey")
    public String deteteSurvey(@RequestParam ("survey_id") int id){
        surveyService.deleteSurvey(id);
        return "redirect:showAllSurveys";
    }
}
