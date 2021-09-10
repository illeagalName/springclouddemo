package com.sunday.api;


import com.sunday.api.fallback.AccountFallbackFactory;
import com.sunday.constant.ServiceNameConstants;
import com.sunday.entities.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

/**
 * 文件服务
 *
 * @author
 */
@FeignClient(contextId = "remoteAccountService", value = ServiceNameConstants.ACCOUNT_SERVICE, fallbackFactory = AccountFallbackFactory.class)
public interface RemoteAccountService {
    @GetMapping("changeAccount")
    R<Boolean> changeAccount(Long userId, BigDecimal money);
}
