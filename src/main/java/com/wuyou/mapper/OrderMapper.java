package com.wuyou.mapper;

import com.wuyou.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int addOrder(Order order);
}
