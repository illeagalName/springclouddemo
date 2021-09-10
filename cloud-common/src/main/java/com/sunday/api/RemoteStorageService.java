package com.sunday.api;


import com.sunday.api.fallback.StorageFallbackFactory;
import com.sunday.constant.ServiceNameConstants;
import com.sunday.entities.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 文件服务
 *
 * @author
 */
@FeignClient(contextId = "remoteStorageService", value = ServiceNameConstants.STORAGE_SERVICE, fallbackFactory = StorageFallbackFactory.class)
public interface RemoteStorageService {
    @GetMapping("changeStorage")
    R<Boolean> changeStorage(Long productId, Integer count);
}
