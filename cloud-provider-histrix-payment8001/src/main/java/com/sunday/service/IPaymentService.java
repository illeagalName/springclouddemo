package com.sunday.service;

import com.sunday.entities.domain.PaymentDO;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 12:34 下午
 */
public interface IPaymentService {
    int create(PaymentDO paymentDO);

    PaymentDO getPaymentById(Long id);

    String payment_ok(Long id);

    String payment_error(Long id);
}
