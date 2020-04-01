package com.imooc.service;

import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2020/04/01
 */
public interface IPayService {
    /**
     * 创建/发起 支付
     * @param orderId 订单号
     * @param amout 支付金额
     * @return code_url
     */
    PayResponse create(String orderId, BigDecimal amout);

    /**
     * 支付回调
     * @param notify
     * @return
     */
    String asyncNotify(String notify);
}
