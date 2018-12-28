package com.gift.futurestrading.order.mapper;

import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 정진우
 * @ClassName : OrderSellMapper
 * @Version : JDK1.8
 * @LatestUpdate : 2018-12-28
 */

@Mapper
public interface OrderSellMapper {
	// 주문 INSERT
	int insertOrderSeller(HashMap<String, Object> map);
	// PK자동증가 코드를 위해 최대값을 가져오는 쿼리
	int selectOneAutoMax(); 
}
