package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.Basket;
import com.shop.seedlings.domain.entity.Item;
import com.shop.seedlings.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;

    @RequestMapping("/seedlings.by/basket")
    public String showAllBasketItems(Model model, HttpServletRequest request,
                               HttpServletResponse response, @CookieValue(value = "cookies", defaultValue = "1")int hostId) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Basket basket = basketService.getBasketById(hostId);
            model.addAttribute("basket", basket);
        }else
        {
            Cookie newCookie = new Cookie("hostIp", "id");
            newCookie.setMaxAge(24 * 60 * 60);
            response.addCookie(newCookie);
        }

        return "basket";
    }

    @RequestMapping("/seedlings.by/addBasketItem")
    public String addBasketItems(Model model,@RequestParam("item") Item item){

        return "basket";
    }
}
