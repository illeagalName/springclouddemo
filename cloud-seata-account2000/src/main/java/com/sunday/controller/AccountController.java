package com.sunday.controller;

import com.sunday.entities.common.R;
import com.sunday.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.controller
 * @ClassName: OrderController
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("changeAccount")
    public R<Boolean> changeAccount(@RequestParam Long userId, @RequestParam BigDecimal money) {
        return R.success(accountService.changeAccount(userId, money));
    }
}
