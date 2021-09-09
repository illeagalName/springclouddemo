package com.sunday.service;

import java.math.BigDecimal;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.service
 * @ClassName: OrderService
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:46
 * @Version: 1.0
 */
public interface AccountService {
    Boolean changeAccount(Long userId, BigDecimal money);
}
