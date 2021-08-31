package com.sunday.dao;

import com.sunday.entities.domain.PaymentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 12:20 下午
 */
@Mapper
public interface PaymentDAO {
    int create(PaymentDO paymentDO);

    PaymentDO getPaymentById(@Param("id") Long id);
}
