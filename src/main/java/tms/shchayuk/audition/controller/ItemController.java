package tms.shchayuk.audition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tms.shchayuk.audition.entity.*;
import tms.shchayuk.audition.service.ItemService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/shop")
    public String showAllItems(Model model) {

        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItems", allItems);

        return "all-items";
    }
//    @RequestMapping("/shop/showItem")
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
    @RequestMapping("/shop/addNewItem")
    public String addNewItem(Model model) {

        Item item = new Item();
        model.addAttribute("item", item);

        return "item-info";
    }
    @RequestMapping("/shop/saveItem")
    public String saveItem(@ModelAttribute("item") Item item) {

        itemService.saveItem(item);

        return "redirect:/shop";
    }
    @RequestMapping("/shop/deleteItem")
    public String deleteSong(@RequestParam("itemId") int id) {

        itemService.deleteItem(id);

        return "redirect:/shop";
    }
}
