package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2020/04/01
 */
@Slf4j
@Service
public class PayServiceImpl implements IPayService {
    @Autowired
    private BestPayService bestPayService;

    @Override
    public PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum payTypeEnum) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("6814129-xiangxuan");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(payTypeEnum);
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("payRequest={}" + payRequest);
        return payResponse;
    }

    @Override
    public String asyncNotify(String notifyData) {
        //1.签名校验
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("payResponse={}" + payResponse);
        //2.金额和数据库金额比对

        //3.更新数据库订单

        //4.返回给支付平台
        if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.WX) {
            return "<xml>\n" +
                    "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                    "</xml>";
        } else if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.ALIPAY) {
            return "success";
        }

        throw new RuntimeException("异步通知中错误的支付平台");
    }
}