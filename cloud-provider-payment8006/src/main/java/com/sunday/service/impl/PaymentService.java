package com.sunday.service.impl;

import com.sunday.dao.PaymentDAO;
import com.sunday.entities.domain.PaymentDO;
import com.sunday.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 12:36 下午
 */
@Service
public class PaymentService implements IPaymentService {

    @Autowired
    PaymentDAO paymentDAO;

    @Override
    public int create(PaymentDO paymentDO) {
        return paymentDAO.create(paymentDO);
    }

    @Override
    public PaymentDO getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
