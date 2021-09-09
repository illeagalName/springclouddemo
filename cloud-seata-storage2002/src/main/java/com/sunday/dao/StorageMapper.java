package com.sunday.dao;

import com.sunday.entities.domain.OrderDO;
import com.sunday.entities.domain.StorageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.mapper
 * @ClassName: OrderMapper
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:49
 * @Version: 1.0
 */
@Mapper
public interface StorageMapper {
    int changeStorage(StorageDO storageDO);

    StorageDO selectStorageById(@Param("productId") Long productId);
}
