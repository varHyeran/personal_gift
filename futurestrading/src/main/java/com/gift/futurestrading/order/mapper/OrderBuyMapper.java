package com.gift.futurestrading.order.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.order.vo.ItemDetailVo;
@Mapper
public interface OrderBuyMapper {
	/*품목상세 정보 가져오기 위한 select*/
	ItemDetailVo selectItemDetailAll();
	/*구매자 주문매수 위한 insert*/
	int insertOrderBuy(HashMap<String, Object> map);
	/*pk값 증가시키기 위한 select*/
	int selectOneAutoMax();
}
