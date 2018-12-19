package com.gift.futurestrading.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.member.mapper.ConsumerMapper;
import com.gift.futurestrading.member.vo.ConsumerMypageVo;
import com.gift.futurestrading.member.vo.ConsumerRequestVo;

@Service
public class ConsumerService {
	@Autowired
	private ConsumerMapper consumerMapper;	
	
	/**
	 * modifyConsumerPassword 컨트롤러로부터 넘겨받은 데이터를 입력값으로 해당 멤버의 비밀번호를 수정
	 * 
	 * @param consumerRequestVo
	 * @return 실행확인을 위해 리턴값 int로 사용
	 * @since JDK1.8
	 */
	public int updateConsumerPassword(Map<String, Object> ConsumerMypageChangePw) {
		System.out.println("ConsumerService.updateConsumerPassword() 호출");
		consumerMapper.updateConsumerMypagePassword(ConsumerMypageChangePw);
		System.out.println("consumerChangePassword : "+ConsumerMypageChangePw.get("consumerChangePassword"));
		return 0;
	}
	
	/**
	 * modifyConsumrInformation 컨트롤러로부터 넘겨받은 데이터를 입력값으로 해당 멤버의 개인정보를 수정
	 * 
	 * @param consumerMypageVo
	 * @return 실행확인을 위해 리턴값 int로 사용
	 * @since JDK1.8
	 */
	public int updateConsumerInformation(ConsumerMypageVo consumerMypageVo) {
		System.out.println("ConsumerService.updateConsumerInformation() 호출");
		consumerMapper.updateConsumerMypageInformation(consumerMypageVo);
		return 0;
	}
	/**
	 * getconsumerMypageInformation 컨트롤러로부터 넘겨받은 데이터를 입력값으로 해당 멤버의 개인정보를 넘김
	 * 
	 * @param ConsumerMypageIdPw
	 * @return consumerMypageVo
	 * @since JDK1.8
	 */
	public ConsumerMypageVo selectConsumerMypageInformation(Map<String, Object> ConsumerMypageIdPw) {
		System.out.println("ConsumerService.selectConsumerMypageInformation() 호출");
		System.out.println("서비스 아이디 :: "+"ConsumerMypageIdPw : "+ConsumerMypageIdPw.get("mypageId"));
		System.out.println("서비스 비번 :: "+"ConsumerMypageIdPw : "+ConsumerMypageIdPw.get("mypagePw"));
		ConsumerMypageVo consumerMypageVo = consumerMapper.selectConsumerMypageInformation(ConsumerMypageIdPw);
		
		System.out.println("ConsumerMypageId : "+consumerMypageVo.getConsumerIdPk());
		return consumerMypageVo;
	}
	
	/**
	 * 컨트롤러로부터 넘겨받은 데이터를 가공하여 SQL 메서드를 호출할 때 param으로 넘김
	 * 
	 * @param consumerRequestVo
	 * @return
	 * @since JDK1.8
	 */
	public int insertConsumer(ConsumerRequestVo consumerRequestVo) {
		System.out.println("ConsumerService.insertConsumer() 호출");
		/* postcode, rodeAddress, detailAddress 데이터 getting */
		String postCode = consumerRequestVo.getPostcode();
		String rodeAddress = consumerRequestVo.getRoadAddress();
		String detailAddress = consumerRequestVo.getDetailAddress();
		
		/* getting해온 데이터들(주소) 하나의 변수에 저장 */
		String allAddress = postCode + " " + rodeAddress + " " + detailAddress;
		System.out.println(allAddress+" <---allAddress");
		
		/* 해쉬맵에 구매자 정보를 put하여 맵퍼 계층의 메서드를 호출할 때 param으로 넘김 */
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("consumer_id_pk", consumerRequestVo.getConsumerIdPk());
		map.put("consumer_password", consumerRequestVo.getConsumerPassword());
		map.put("consumer_name", consumerRequestVo.getConsumerName());
		map.put("consumer_email", consumerRequestVo.getConsumerEmail());
		map.put("consumer_jumin_no", consumerRequestVo.getConsumerJuminNo());
		map.put("consumer_address", allAddress);
		map.put("consumer_phone", consumerRequestVo.getConsumerPhone());
		
		/* 맵퍼 계층의 insertConsumer 메서드 호출 */
		int insertResult = consumerMapper.insertConsumer(map);

		return insertResult;
	}
	
	/**
	 * 컨트롤러로부터 넘어온 아이디와 DB에 저장된 아이디를 비교하여 중복값을 체크
	 * 
	 * @param id
	 * @return
	 * @since JDK1.8
	 */
	public int idCheck(String id) {
		System.out.println("ConsumerService.idCheck() 호출");
		int selectResult = 0;
		
		/* 맵퍼 계층의 selectIdCheck 메서드 호출 */
		selectResult = consumerMapper.selectIdCheck(id);
		System.out.println(selectResult+" <---selectResult");
			
		return selectResult;
	}

	
}