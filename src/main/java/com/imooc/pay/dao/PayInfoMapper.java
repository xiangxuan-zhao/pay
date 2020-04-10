package com.imooc.pay.dao;

import com.imooc.pay.pojo.PayInfo;

/**
 * @author Administrator
 */
public interface PayInfoMapper {
    /**
     * 根据id 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(PayInfo record);

    /**
     * 有选择的插入
     * @param record
     * @return
     */
    int insertSelective(PayInfo record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(PayInfo record);
}