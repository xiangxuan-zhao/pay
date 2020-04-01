package com.imooc.controller;

import com.imooc.service.impl.PayServiceImpl;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020/04/01
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayServiceImpl payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,@RequestParam("amount") BigDecimal amount){
        Map<String,String> map = new HashMap<>();
        PayResponse payResponse = payService.create(orderId, amount);
        map.put("codeUrl",payResponse.getCodeUrl());
        return new ModelAndView("create",map);
    }
}
