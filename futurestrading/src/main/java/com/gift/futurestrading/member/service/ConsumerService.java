package com.gift.futurestrading.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.member.mapper.ConsumerMapper;
import com.gift.futurestrading.member.vo.ConsumerRequestVo;
import com.gift.futurestrading.member.vo.ConsumerVo;

@Service
public class ConsumerService {
	@Autowired
	private ConsumerMapper consumerMapper;
	private ConsumerVo consumerVo;	
	
	public int insertConsumer(ConsumerRequestVo consumerRequestVo) {
		System.out.println("ConsumerService.insertConsumer() 호출");
		/* postcode, rodeAddress, detailAddress 데이터 getting */
		String postCode = consumerRequestVo.getPostcode();
		String rodeAddress = consumerRequestVo.getRoadAddress();
		String detailAddress = consumerRequestVo.getDetailAddress();
		
		/* getting해온 데이터들 하나의 변수에 저장 */
		String allAddress = postCode + " " + rodeAddress + " " + detailAddress;
		System.out.println(allAddress+" <---allAddress");
		
		/* ConsumerVo VO에 데이터 setting */
/*		consumerVo = new ConsumerVo();
		consumerVo.setConsumerIdPk(consumerRequestVo.getConsumerIdPk());
		consumerVo.setConsumerPassword(consumerRequestVo.getConsumerPassword());
		consumerVo.setConsumerName(consumerRequestVo.getConsumerName());
		consumerVo.setConsumerEmail(consumerRequestVo.getConsumerEmail());
		consumerVo.setConsumerJuminNo(consumerRequestVo.getConsumerJuminNo());
		consumerVo.setConsumerAddress(allAddress);
		consumerVo.setConsumerPhone(consumerRequestVo.getConsumerPhone());*/
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("consumer_id_pk", consumerRequestVo.getConsumerIdPk());
		map.put("consumer_password", consumerRequestVo.getConsumerPassword());
		map.put("consumer_name", consumerRequestVo.getConsumerName());
		map.put("consumer_email", consumerRequestVo.getConsumerEmail());
		map.put("consumer_jumin_no", consumerRequestVo.getConsumerJuminNo());
		map.put("consumer_address", allAddress);
		map.put("consumer_phone", consumerRequestVo.getConsumerPhone());
		
		/* insert 맵퍼 호출 */
		int insertResult = consumerMapper.insertConsumer(map);
	
		return insertResult;
	}
}
