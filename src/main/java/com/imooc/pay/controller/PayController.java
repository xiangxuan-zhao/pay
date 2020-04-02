package com.imooc.pay.controller;

import com.imooc.pay.service.impl.PayServiceImpl;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount,
                               @RequestParam("payType")BestPayTypeEnum payTypeEnum){
        Map<String,String> map = new HashMap<>();
        PayResponse payResponse = payService.create(orderId, amount, payTypeEnum);
        if(payTypeEnum == BestPayTypeEnum.WXPAY_NATIVE){
            map.put("codeUrl",payResponse.getCodeUrl());
            return new ModelAndView("createForWxPayNative",map);
        }else if(payTypeEnum == BestPayTypeEnum.ALIPAY_PC){
            map.put("body",payResponse.getBody());
            return new ModelAndView("createForAlipayPc",map);
        }
        throw new RuntimeException("不支持的支付类型");
    }

    @PostMapping("/notify")
    @ResponseBody
    public String asyncNotify(@RequestBody String notifyData){
        return payService.asyncNotify(notifyData);
    }
}
