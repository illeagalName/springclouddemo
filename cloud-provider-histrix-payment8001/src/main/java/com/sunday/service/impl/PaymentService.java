package com.sunday.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunday.dao.PaymentDAO;
import com.sunday.entities.domain.PaymentDO;
import com.sunday.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    @Override
    public String payment_ok(Long id) {
        return "线程池：" + Thread.currentThread().getName() + " OK, id : " + id + "  O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String payment_error(Long id) {
        int time = 2;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {

        }
//        int i = 10/0;
        return "线程池：" + Thread.currentThread().getName() + " TIMEOUT, id : " + id + "  O(∩_∩)O哈哈~ 耗时 (s)" + time;
    }

    public String timeoutHandler(Long id) {
        return "线程池：" + Thread.currentThread().getName() + " TIMEOUT  默认报错, id : " + id;
    }
}
