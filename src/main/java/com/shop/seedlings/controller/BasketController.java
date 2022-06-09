package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.*;
import com.shop.seedlings.service.BasketService;
import com.shop.seedlings.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private ItemService itemService;

    @RequestMapping("/seedlings.by/basket")
    public String showAllBasketItems(Model model,  HttpServletRequest request,HttpServletResponse response) {
        Cookie [] c=request.getCookies();
        int hostId= Integer.parseInt(c[0].getValue());
        List<BasketItem>basketItems = basketService.getAllBasketItems(hostId);
        Basket basket = basketService.getBasketById(hostId);
        model.addAttribute("basketItems",basketItems);
        model.addAttribute("basket",basket);
        return "basket";
    }

    @RequestMapping("/seedlings.by/addBasketItem")
    public String addBasketItems(Model model,@RequestParam("itemId") int itemId, HttpServletRequest request,HttpServletResponse response){
        Cookie [] c=request.getCookies();
        int hostId= Integer.parseInt(c[0].getValue());
        Item item=itemService.getItemById(itemId);
        BasketItem basketItem=basketService.itemToBasketItem(item, hostId);
        basketService.saveBasketItem(basketItem);
        Basket basket = basketService.getBasketById(hostId);
        basket.setPrice(basket.getPrice()+item.getUnitPrice());
        basketService.saveBasket(basket);
        return "redirect:/seedlings.by/catalog";
    }
    @RequestMapping("/seedlings.by/deleteBasketItem")
    public String deleteBasketItem(Model model,@RequestParam("itemId") int itemId){
        basketService.deleteBasketItem(itemId);
        return "redirect:/seedlings.by/basket";
    }








    @RequestMapping("/seedlings.by/makeOrder")
    public String newOrder(Model model,  HttpServletRequest request,HttpServletResponse response) {
        Cookie [] c=request.getCookies();
        int hostId= Integer.parseInt(c[0].getValue());
        List<BasketItem>basketItems = basketService.getAllBasketItems(hostId);
        Basket basket = basketService.getBasketById(hostId);
        model.addAttribute("basketItems",basketItems);
        model.addAttribute("basket",basket);

        model.addAttribute("hostId",hostId);

        Client client = new Client();
        model.addAttribute("client", client);
        return "order";
    }
    @RequestMapping("/seedlings.by/order")
    public String doOrder(Model model,  HttpServletRequest request,HttpServletResponse response) {

        return "redirect:/seedlings.by/catalog";
    }
}