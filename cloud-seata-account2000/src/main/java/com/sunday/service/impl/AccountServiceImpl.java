package com.sunday.service.impl;

import com.sunday.dao.AccountMapper;
import com.sunday.entities.domain.AccountDO;
import com.sunday.entities.domain.StorageDO;
import com.sunday.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.service.impl
 * @ClassName: OrderServiceImpl
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:47
 * @Version: 1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Boolean changeAccount(Long userId, BigDecimal money) {
        AccountDO accountDO = accountMapper.selectAccountById(userId);
        // 暂时不考虑钱是负数
        accountDO.setUsed(accountDO.getUsed().add(money));
        accountDO.setResidue(accountDO.getResidue().subtract(money));
        log.info("减资产开始。。。");
        int insert = accountMapper.changeAccount(accountDO);

        // 最后一步模拟异常
        int i = 10 / 0;
        log.info("减资产结束。。。");
        return insert > 0;
    }
}
