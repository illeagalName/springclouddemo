package com.sunday.controller;

import com.sunday.entities.common.R;
import com.sunday.entities.domain.OrderDO;
import com.sunday.entities.domain.StorageDO;
import com.sunday.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping("changeStorage")
    public R<Boolean> changeStorage(Long productId, Integer count) {
        return R.success(storageService.changeStorage(productId, count));
    }
}
