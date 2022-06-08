package com.shop.seedlings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shop.seedlings.domain.entity.Item;
import com.shop.seedlings.service.ItemService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/shopAdmin")
    public String showCatalogItems(Model model) {

        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItems", allItems);

        return "catalog-items";
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
    @RequestMapping("/shopAdmin/addNewItem")
    public String addNewItem(Model model) {

        Item item = new Item();
        model.addAttribute("item", item);

        return "item-info";
    }

    @RequestMapping("/shopAdmin/saveItem")
    public String saveItem(@ModelAttribute("item") Item item) {

        itemService.saveItem(item);

        return "redirect:/shop/allItems";
    }

    @RequestMapping("/shopAdmin/deleteItem")
    public String deleteSong(@RequestParam("itemId") int id) {

        itemService.deleteItem(id);

        return "redirect:/shop/allItems";
    }

    @RequestMapping("/shopAdmin/editItem")
    public String editItem(@RequestParam("itemId") int id,Model model) {

        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        model.addAttribute("itemId",id);
        return "item-info";
    }
}