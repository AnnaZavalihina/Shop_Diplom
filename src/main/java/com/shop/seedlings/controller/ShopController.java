package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.Info;
import com.shop.seedlings.domain.entity.PickupAddress;
import com.shop.seedlings.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/seedlings.by/delivery")
    public String deliveryAddresses(Model model) {

        List<PickupAddress> allPickupAddresses = shopService.getAllPickupAddresses();
        model.addAttribute("allPickupAddresses", allPickupAddresses);

        return "info-delivery";
    }

    @RequestMapping("/seedlings.by/about")
    public String aboutUs(Model model) {

        Info info = shopService.getInfo();
        model.addAttribute("info", info);

        return "about";
    }

    @RequestMapping("/seedlings.by/questions")
    public String questionsAnswers(Model model) {

        List<Question> allQuestion = shopService.getAllQuestions();
        model.addAttribute("allQuestion", allQuestion);

        Question question = new Question();
        model.addAttribute("question", question);

        return "questions-answers";
    }
    @RequestMapping("/seedlings.by/your-question")
    public String saveQuestion(@ModelAttribute("question") Question question, Model model) {

        question.setDate(new java.sql.Date(System.currentTimeMillis()));
        shopService.saveQuestion(question);
//        String dateQuestion = new SimpleDateFormat("dd/MM/yyyy").format( aDate );
        return "redirect:/seedlings.by/questions";
    }
}
