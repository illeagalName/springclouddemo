package com.sunday.api.fallback;

import com.sunday.api.RemoteAccountService;
import com.sunday.entities.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.api.fallback
 * @ClassName: AccountFallbackFactory
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/10 10:16
 * @Version: 1.0
 */
@Component
@Slf4j
public class AccountFallbackFactory implements FallbackFactory<RemoteAccountService> {
    @Override
    public RemoteAccountService create(Throwable cause) {
        log.error("资产调用失败:{}", cause.getMessage());
        return (userId, money) -> R.error("扣资产异常");
    }
}
