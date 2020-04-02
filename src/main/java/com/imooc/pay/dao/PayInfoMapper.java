package com.imooc.pay.dao;

import com.imooc.pay.pojo.PayInfo;

/**
 * @author Administrator
 */
public interface PayInfoMapper {
    /**
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int insert(PayInfo record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(PayInfo record);

    /**
     *
     * @param id
     * @return
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PayInfo record);
}