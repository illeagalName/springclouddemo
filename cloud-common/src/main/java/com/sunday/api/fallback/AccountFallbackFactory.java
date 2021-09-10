package com.sunday.api.fallback;

import com.sunday.api.RemoteAccountService;
import com.sunday.entities.common.R;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

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
public class AccountFallbackFactory implements FallbackFactory<RemoteAccountService> {
    @Override
    public RemoteAccountService create(Throwable cause) {
        return (userId, money) -> R.error("扣资产异常");
    }
}
