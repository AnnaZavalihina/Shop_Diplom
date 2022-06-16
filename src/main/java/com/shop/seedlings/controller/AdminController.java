package com.shop.seedlings.controller;

import com.shop.seedlings.domain.entity.Order;
import com.shop.seedlings.service.BasketService;
import com.shop.seedlings.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/seedlings.by/listOrders")
    public String showAllOrders(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Order> allOrders = orderService.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        model.addAttribute("formatForDateNow", formatForDateNow);
        return "listOfOrders";
    }

    @RequestMapping("/seedlings.by/listMadeOrders")
    public String showAllMadeOrders(Model model, @RequestParam("made")String made, HttpServletRequest request, HttpServletResponse response) {
        List<Order> allMadeOrders = orderService.getAllMadeOrders(made);
        model.addAttribute("allMadeOrders", allMadeOrders);

        String status = "";
        if(made.equals("true")){status="ЗАВЕРШЕННЫХ";}
        else{status="НЕЗАВЕРШЕННЫХ";}
        model.addAttribute("status", status);

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        model.addAttribute("formatForDateNow", formatForDateNow);
        return "listMadeOrders";
    }

    @RequestMapping("/seedlings.by/switchStatus")
    public String switchOrderStatus(Model model, @RequestParam("orderId")int orderId, HttpServletRequest request, HttpServletResponse response) {
        Order order = orderService.getOrderById(orderId);
        order.setStatus("true");
        orderService.saveOrder(order);
        return "redirect:/seedlings.by/listOrders";
    }
}
