package com.imooc.pay.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Administrator
 */
@Data
public class PayInfo {
    private Integer id;

    private Integer userId;

    private Long orderNo;

    private Integer payPlatform;

    private String platformNumber;

    private String platformStatus;

    private BigDecimal payAmount;

    private Date createTime;

    private Date updateTime;

}