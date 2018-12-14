package com.gift.futurestrading.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gift.futurestrading.member.mapper.SellerMapper;
import com.gift.futurestrading.member.vo.SellerFileRequest;
import com.gift.futurestrading.member.vo.SellerFileVo;
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
	/**
	 * 샘플에 대한 정보를 데이터베이스에 등록
	 *
	 * @param seller 입력된 샘플에 대한 정보
	 */

	/* 12.14 현재 문제점 
	 * 각 파일의 확장자 데어터 타입등 상세정보가 담길 데이터 베이스를 다시 만들어야한다
	 * Vo파일 다시 생성하고 코드 주석 추가해야한다.
	 * 현재 "document_seller의 데이터 베이스같이 licence"
	 * 
	 * */
	
	public void addseller(SellerFileRequest sellerFileRequest, String realPath) {
		/*
		 * sellerFileRequest --> seller, sellerFile로 변환 필요
		 * 1. multipartfile 파일데이터 -> 저장
		 * 2. multipartfile 정보-> 새로운정보 추가 ->sellerFile
		 * 3. 
		 */
		//1.
		//2
		SellerFileVo sellerFileVo = new SellerFileVo();
		MultipartFile[] multiPartFile = sellerFileRequest.getMultipartFile();
		// 1. SellerFileNo : AutoIntrement
		for(MultipartFile multipart :multiPartFile) {
			if(!multipart.isEmpty()) {
			
				// 3. sellerFilePath
				sellerFileVo.setSellerPath(realPath);
				String originalFileName = multipart.getOriginalFilename();
				int index = originalFileName.indexOf(".");
				// 4. 이름
				String fileName = originalFileName.substring(0,index);
				sellerFileVo.setSellerName(fileName);
				// 5. 확장자
				String ext = originalFileName.substring(fileName.length()+1, originalFileName.length());
				sellerFileVo.setSellerFileExt(ext);
				// 6. 타입
/*				sellerFileVo.setsellerFileType(multipart.getContentType());
				// 7. 크기
				sellerFileVo.setsellerFileSize(multipart.getSize());
				// 8. 저장될 파일의 이름
				String realFileName = UUID.randomUUID().toString();
				sellerFileVo.setsellerFileRealName(realFileName);
				
				//내가 원하는 이름의 빈파일 생성
				File file = new File(realPath + "/" + realFileName + "." + ext);
				transaction2 = sellerFileMapper.insertsellerFile(sellerFile); //트랜잭션 2
				//multipartFile파일을 빈파일로 복사
				try {
					multipart.transferTo(file);
				}
				catch(IllegalStateException | IOException e) {
					e.printStackTrace();*/
				}
			}
		}
	}

