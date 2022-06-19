package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.*;
import com.shop.seedlings.service.BasketService;
import com.shop.seedlings.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showAllBasketItems(Model model, HttpServletRequest request, HttpServletResponse response) {
        int hostId = checkCookie(request, response);

        List<BasketItem> basketItems = basketService.getAllBasketItems(hostId);
        Basket basket = basketService.getBasketById(hostId);
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("basket", basket);
        return "basket";
    }

    @RequestMapping("/seedlings.by/addBasketItem")
    public String addBasketItems(Model model, @RequestParam("itemId") int itemId, HttpServletRequest request, HttpServletResponse response) {
        int hostId = checkCookie(request, response);

        List<BasketItem> bi = basketService.getDoubleItems(itemId, hostId);
        Item item = itemService.getItemById(itemId);

        if (bi.size() == 0) {
            BasketItem basketItem = basketService.itemToBasketItem(item, hostId);
            basketService.saveBasketItem(basketItem);
        } else {
            BasketItem myBasketItem = bi.get(0);
            myBasketItem.setQuantity(myBasketItem.getQuantity() + 1);
            myBasketItem.setPrice(myBasketItem.getPrice() + item.getUnitPrice());

            basketService.saveBasketItem(myBasketItem);
        }

        Basket basket = basketService.getBasketById(hostId);
        basket.setPrice(basket.getPrice() + item.getUnitPrice());
        basketService.saveBasket(basket);
        return "redirect:/seedlings.by/catalog";
    }

    @RequestMapping("/seedlings.by/deleteBasketItem")
    public String deleteBasketItem(Model model, @RequestParam("itemId") int itemId, HttpServletRequest request, HttpServletResponse response) {
        BasketItem item = basketService.getItemById(itemId);

        int hostId = checkCookie(request, response);

        Basket basket = basketService.getBasketById(hostId);
        basket.setPrice(basket.getPrice() - item.getItem().getUnitPrice() * item.getQuantity());
        basketService.saveBasket(basket);

        basketService.deleteBasketItem(itemId);

        return "redirect:/seedlings.by/basket";
    }


    @RequestMapping("/seedlings.by/makeOrder")
    public String newOrder(Model model, HttpServletRequest request, HttpServletResponse response) {
        int hostId = checkCookie(request, response);

        List<BasketItem> basketItems = basketService.getAllBasketItems(hostId);
        Basket basket = basketService.getBasketById(hostId);
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("basket", basket);

        Client client = new Client();
        model.addAttribute("client", client);
        return "order";
    }

    @RequestMapping("/seedlings.by/order")
    public String doOrder(Model model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("client") Client client) {
        int hostId = checkCookie(request, response);

        client.setId(hostId);
        basketService.saveClient(client);

        double price = basketService.getBasketById(hostId).getPrice();

        Order order = new Order(new java.sql.Date(System.currentTimeMillis()), price, hostId, "false", null);
        basketService.saveOrder(order);
        Order orderByHostId = basketService.getOrderByHostId(hostId);

        List<BasketItem> basketItems = basketService.getAllBasketItems(hostId);

        for (BasketItem basketItem : basketItems) {
            OrderItem oi = new OrderItem();
            oi.setPrice(basketItem.getPrice());
            oi.setItem(basketItem.getItem());
            oi.setQuantity(basketItem.getQuantity());
            oi.setOrder(orderByHostId);
            basketService.saveOrderItem(oi);

            Item item = itemService.getItemById(basketItem.getItem().getId());
            item.setStatus(item.getStatus() - basketItem.getQuantity());
            itemService.saveItem(item);
        }

        basketService.dropAllItems(hostId);
        Basket basket = basketService.getBasketById(hostId);
        basket.setPrice(0);
        basketService.saveBasket(basket);
        return "redirect:/seedlings.by";
    }

    @RequestMapping("/seedlings.by/reduceQuantity")
    public String reduceQuantity(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("itemId") int itemId) {
        int hostId = checkCookie(request, response);

        BasketItem basketItem = basketService.getItemById(itemId);
        basketItem.setQuantity(basketItem.getQuantity() - 1);
        basketItem.setPrice(basketItem.getPrice() - basketItem.getItem().getUnitPrice());

        basketService.saveBasketItem(basketItem);

        Basket myBasket = basketService.getBasketById(hostId);
        myBasket.setPrice(myBasket.getPrice() - basketItem.getItem().getUnitPrice());
        basketService.saveBasket(myBasket);
        return "redirect:/seedlings.by/basket";
    }

    @RequestMapping("/seedlings.by/increaseQuantity")
    public String increaseQuantity(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("itemId") int itemId) {
        int hostId = checkCookie(request, response);

        BasketItem basketItem = basketService.getItemById(itemId);
        basketItem.setQuantity(basketItem.getQuantity() + 1);
        basketItem.setPrice(basketItem.getPrice() + basketItem.getItem().getUnitPrice());
        basketService.saveBasketItem(basketItem);

        Basket myBasket = basketService.getBasketById(hostId);
        myBasket.setPrice(myBasket.getPrice() + basketItem.getItem().getUnitPrice());
        basketService.saveBasket(myBasket);
        return "redirect:/seedlings.by/basket";
    }

    public int checkCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookie = request.getCookies();
        boolean real = false;
        int myId = 0;

        if (cookie == null) {
            String newId = Integer.toString(basketService.getAllBaskets().size() + 1);
            Basket b = new Basket(new java.sql.Date(System.currentTimeMillis()), 0, null);
            basketService.saveBasket(b);

            Cookie newCookie = new Cookie("i", newId);
            newCookie.setMaxAge(24 * 60 * 60);
            response.addCookie(newCookie);

            myId = Integer.parseInt(newId);
        } else {
            for (Cookie c : cookie) {
                if (c.getName().equals("i")) {
                    real = true;
                    myId = Integer.parseInt(c.getValue());
                }
            }
            if (real == false) {
                String newId = Integer.toString(basketService.getAllBaskets().size() + 1);
                Basket b = new Basket(new java.sql.Date(System.currentTimeMillis()), 0, null);
                basketService.saveBasket(b);

                Cookie newCookie = new Cookie("i", newId);
                newCookie.setMaxAge(24 * 60 * 60);
                response.addCookie(newCookie);

                myId = Integer.parseInt(newId);
            }
        }
        return myId;
    }
}
