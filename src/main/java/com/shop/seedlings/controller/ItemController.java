package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.Basket;
import com.shop.seedlings.domain.entity.Subtype;
import com.shop.seedlings.domain.entity.Type;
import com.shop.seedlings.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shop.seedlings.service.ItemService;
import com.shop.seedlings.domain.entity.Item;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private BasketService basketService;

    @RequestMapping("/seedlings.by")
    public String showAllItems(Model model) {

        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItems", allItems);
        List<Type> allTypes = itemService.getAllTypes();
        model.addAttribute("allTypes", allTypes);
        return "catalog-items";
    }
    @RequestMapping("/seedlings.by/type")
    public String showTypeItems(Model model, @RequestParam("typeId") int typeId) {

        List<Item> allTypeItems = itemService.getAllTypeItems(typeId);
        model.addAttribute("allTypeItems", allTypeItems);

        List<Type> allTypes = itemService.getAllTypes();
        model.addAttribute("allTypes", allTypes);
        List<Subtype> allSubtypes = itemService.getAllSubtypes(typeId);
        model.addAttribute("allSubtypes", allSubtypes);

        model.addAttribute("typeId", typeId);
        Type type = itemService.getTypeById(typeId);
        model.addAttribute("type", type);
        return "types-items";
    }


    @RequestMapping("/seedlings.by/subtype")
    public String showSubtypeItems(Model model, @RequestParam("subtypeId") int subtypeId,
                                   @RequestParam("typeId") int typeId) {

        List<Item> allSubtypeItems = itemService.getAllSubtypeItems(subtypeId);
        model.addAttribute("allSubtypeItems", allSubtypeItems);

        List<Type> allTypes = itemService.getAllTypes();
        model.addAttribute("allTypes", allTypes);
        List<Subtype> allSubtypes = itemService.getAllSubtypes(typeId);
        model.addAttribute("allSubtypes", allSubtypes);

        model.addAttribute("typeId", typeId);
        Subtype subtype = itemService.getSubtypeById(subtypeId);
        model.addAttribute("subtype", subtype);
        return "subtypes-items";
    }
    @RequestMapping("/seedlings.by/item")
    public String showItem(Model model, @RequestParam("itemId") int id) {

        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);

        return "item-info";
    }

    @RequestMapping("/seedlings.by/discount")
    public String discountItems(Model model) {

        List<Item> allDiscountItems = itemService.getAllDiscountItems();
        model.addAttribute("allDiscountItems", allDiscountItems);

        return "discount-items";
    }
}
