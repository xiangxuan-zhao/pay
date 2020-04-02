package com.imooc.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

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
     * @param payTypeEnum 支付类型
     * @return code_url
     */
    PayResponse create(String orderId, BigDecimal amout, BestPayTypeEnum payTypeEnum);

    /**
     * 支付回调
     * @param notify
     * @return
     */
    String asyncNotify(String notify);
}
