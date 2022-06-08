package com.shop.seedlings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shop.seedlings.domain.entity.User;
import com.shop.seedlings.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/user/allUsers")
//    public String showAllItems(Model model) {
//
//        List<User> allItems = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//
//        return "all-users";
//    }
//        @RequestMapping("/shop/showItem")
//    public String showSong(@RequestParam("itemId") int id, Model model) {
//
//        List<Line> allLines = auditionService.getAllLinesBySongId(id);
//        List<Word> allWordsNotSorted = new ArrayList<>();
//        for (Line currentLine : allLines) {
//            allWordsNotSorted.addAll(currentLine.getListOfWords());
//        }
//        List<Word> allWords = allWordsNotSorted.stream().sorted(Comparator.comparingInt(Word::getWordOrder)).collect(Collectors.toList());
//
//        auditionService.doStrategy(allWords, allLines);
//        AnswersFromClient answersFromClient = new AnswersFromClient();
//
//        model.addAttribute("allLines", allLines);
//        model.addAttribute("allWords", allWords);
//        model.addAttribute(answersFromDAO);
//        model.addAttribute(answersFromClient);
//        return "show-item";
//    }
    @RequestMapping("/login/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/login/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/user/profile";
    }

    @RequestMapping("/user/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/user/allUsers";
    }

    @RequestMapping("/user/profile")
    public String userProfile(@RequestParam("userId") int id) {

        userService.getUserById(id);

        return "profile";
    }
}