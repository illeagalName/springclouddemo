package com.sunday.dao;

import com.sunday.entities.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;

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
public interface OrderMapper {
    int insert(OrderDO orderDO);
}
