package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayService;
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
    public PayResponse create(String orderId, BigDecimal amount) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("6814129-xiangxuan");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.debug("payRequest = {}" + payRequest);
        return payResponse;
    }

    @Override
    public String asyncNotify(String notify) {
        return null;
    }
}
