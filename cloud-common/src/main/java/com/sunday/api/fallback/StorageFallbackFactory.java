package com.sunday.api.fallback;

import com.sunday.api.RemoteStorageService;
import com.sunday.entities.common.R;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class StorageFallbackFactory implements FallbackFactory<RemoteStorageService> {

    @Override
    public RemoteStorageService create(Throwable cause) {
        log.error("库存调用失败:{}", cause.getMessage());
        return (productId, count) -> R.error("扣库存异常");
    }
}
