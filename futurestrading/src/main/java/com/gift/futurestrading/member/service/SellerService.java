package com.gift.futurestrading.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.member.mapper.SellerMapper;
import com.gift.futurestrading.member.vo.SellerRequestVo;
@Service
public class SellerService {
	@Autowired
	private SellerMapper sellerMapper;
	
	public int idCheck(String id) {
		int selectResult = 0;
		
		/* 맵퍼 계층의 selectIdCheck 메서드 호출 */
		selectResult = sellerMapper.selectIdCheck(id);
		System.out.println(selectResult+" <---selectResult");
			
		return selectResult;
	}	/**
	 * 컨트롤러로부터 넘겨받은 데이터를 가공하여 SQL 메서드를 호출할 때 param으로 넘김
	 * 
	 * @param sellerRequestVo
	 * @return
	 * @since JDK1.8
	 */
	public int insertSeller(SellerRequestVo sellerRequestVo) {
		System.out.println("sellerService.insertseller() 호출");
		/* postcode, rodeAddress, detailAddress 데이터 getting */
		String postCode = sellerRequestVo.getPostcode();
		String rodeAddress = sellerRequestVo.getRoadAddress();
		String detailAddress = sellerRequestVo.getDetailAddress();
		
		/* getting해온 데이터들(주소) 하나의 변수에 저장 */
		String allAddress = postCode + " " + rodeAddress + " " + detailAddress;
		System.out.println(allAddress+" <---allAddress");
		
		/* 해쉬맵에 구매자 정보를 put하여 맵퍼 계층의 메서드를 호출할 때 param으로 넘김 */
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("seller_id_pk", sellerRequestVo.getSellerIdPk());
		map.put("seller_password", sellerRequestVo.getSellerPassword());
		map.put("seller_name", sellerRequestVo.getSellerName());
		map.put("seller_email", sellerRequestVo.getSellerEmail());
		map.put("seller_jumin_no", sellerRequestVo.getSellerJuminNo());
		map.put("seller_address", allAddress);
		System.out.println(sellerRequestVo.getCorporateName());
		map.put("seller_corporate_name", sellerRequestVo.getCorporateName());
		map.put("seller_phone", sellerRequestVo.getSellerPhone());
		
		/* 맵퍼 계층의 insertseller 메서드 호출 */
		int insertResult = sellerMapper.insertSeller(map);

		return insertResult;
	}
}
