package com.sunday.dao;

import com.sunday.entities.domain.AccountDO;
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
public interface AccountMapper {
    int changeAccount(AccountDO accountDO);

    AccountDO selectAccountById(@Param("userId") Long userId);
}
