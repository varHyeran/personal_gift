package com.gift.futurestrading.order.mapper;

import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderSellMapper {
	int insertOrderSeller(HashMap<String, Object> map);
	int selectOneAutoMax(); 
}
