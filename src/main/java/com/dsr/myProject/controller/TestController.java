package com.dsr.myProject.controller;

import com.dsr.myProject.model.Word;
import com.dsr.myProject.service.WordsService;
import com.dsr.myProject.translater.Parser;
import com.dsr.myProject.translater.Translater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private WordsService wordsService;

    @RequestMapping(value = "/questions", method = GET)
    public String test(ModelMap modelMap) {
        modelMap.addAttribute("words", wordsService.findWordsForTest());
        modelMap.addAttribute("oneMore", 1);
        return "test/questions";
    }

    @RequestMapping(value = "/questionsByPriority", method = POST)
    public String testByPriority(@ModelAttribute("priority") Integer priority, ModelMap modelMap) {
        modelMap.addAttribute("words", wordsService.findWordsByPriority(priority - 1));
        modelMap.addAttribute("oneMore", 0);
        return "test/questions";
    }

    @RequestMapping(value = "/questionsByPriority")
    public String testByPriority() {
        return "test/questionsByPriority";
    }
}
