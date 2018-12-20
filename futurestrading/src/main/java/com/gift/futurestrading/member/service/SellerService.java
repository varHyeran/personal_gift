package com.gift.futurestrading.member.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.gift.futurestrading.member.mapper.SellerMapper;
import com.gift.futurestrading.member.vo.AccountCheckResultVo;
import com.gift.futurestrading.member.vo.SellerFileRequestVo;
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
		System.out.println(selectResult + " <---selectResult");

		return selectResult;
	}
	
	public int accountCheck(HashMap<String , Object> ajaxValue) {
		int selectResult = 1;
		/* 맵퍼 계층의 selectIdCheck 메서드 호출 */
		System.out.println(selectResult + " <---selectResult");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("contract_bank_user_name", ajaxValue.get("sellerName"));
		map.put("contract_bank_user_birth", ajaxValue.get("sellerBirth"));
		map.put("contract_bank_name", ajaxValue.get("userAccountBank"));
		map.put("contract_bank_user_account_no", ajaxValue.get("userAccountNo"));
		System.out.println(map.get("contract_bank_name")+"contract_bank_namecontract_bank_name");
		System.out.println(map.get("contract_bank_user_name")+"contract_bank_namecontract_bank_name");
		System.out.println(map.get("contract_bank_user_birth")+"contract_bank_namecontract_bank_name");
		System.out.println(map.get("contract_bank_user_account_no")+"contract_bank_namecontract_bank_name");
		try {
		AccountCheckResultVo accountCheckResult = sellerMapper.selectAccountCheck(map);
		String bankUserAccountStatus = accountCheckResult.getContract_bank_user_account_status();
			if(!(bankUserAccountStatus==null)) {
				if(bankUserAccountStatus.equals("거래가능")) {
					selectResult = 0;
				} 
			}	
		}catch (Exception e) {
			selectResult=1;
		
		}
		return selectResult;
	} 


	/**
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
		System.out.println(allAddress + " <---allAddress");

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
	 * joinSellerDetail 대한 정보를 데이터베이스에 등록
	 *
	 * @param seller 입력된 샘플에 대한 정보
	 * @throws IOException 
	 */

	public void sellerFileUpload(SellerFileRequestVo sellerFileRequest, String realPath) throws IOException {

		MultipartFile[] multiPartFile = sellerFileRequest.getMultipartFile();
		SellerFileVo sellerFileVo = new SellerFileVo();
		
		// 5개의 각기 다른 사진을 업로드 하기 때문에 for문 반복때 순서대로 번호 부여
		int multipartInTheCounter = 0 ;
		/* sellerMapper.selectOneAutoMax()
		 *  select max(CAST(substring(document_seller_no_pk,17) AS DECIMAL)) from document_seller 쿼리 실행 후 
		 *  sellerMaxId에 대입한후  1증가 시킴
		 *
		 */
		int sellerMaxId = sellerMapper.selectOneAutoMax();
			sellerMaxId += 1;

		String documentSellerLetter = "document_seller_"+sellerMaxId;
		for (MultipartFile multipart : multiPartFile) {
			if (!multipart.isEmpty()) {
				multipartInTheCounter += 1;;
				Calendar cal = Calendar.getInstance();
				String uploaderName = sellerFileRequest.getSellerName();
				String originalFileName = multipart.getOriginalFilename();
				int index = originalFileName.indexOf(".");
				// 이름
				String fileName = originalFileName.substring(0, index);
				// 확장자
				String ext = originalFileName.substring(fileName.length() + 1, originalFileName.length());
				System.out.println(sellerFileRequest.getSellerId());
				// 날짜
				String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
				String year = Integer.toString(cal.get(Calendar.YEAR));
				// 내가 원하는 이름의 빈파일 생성
				String fileFolderName = "_" +  month + year;
				String fileFolderPath = realPath + "/"+fileFolderName;
				File fileDir = new File(fileFolderPath);
				
				// 월별 폴더가 없을시  생성
				if(!fileDir.exists()) {
					fileDir.mkdirs();
					System.out.println("Folder Not exists");
				}
				// 경로 + 날짜 + 업로더 이름 + 순서 + 확장자
				String databaseName = month+year+uploaderName+multipartInTheCounter+"."+ext;
				String realName = fileFolderPath+"/"+databaseName;
				File file = new File(realName);
				
				System.out.println("file insert!");
				try {
					multipart.transferTo(file); 
					System.out.println("file insert! ::Try");
					switch(multipartInTheCounter) {
					case 1 : 
						//초기에 한번만 담기위해 case1에 넣었음
						sellerFileVo.setSellerNoPk(documentSellerLetter);
						sellerFileVo.setSellerId(sellerFileRequest.getSellerId());
						sellerFileVo.setSellerName(sellerFileRequest.getSellerName());
						sellerFileVo.setSellerPath(fileFolderPath);
						sellerFileVo.setSellerPathFolder(fileFolderName);
			            sellerFileVo.setSellerLicence(databaseName); 
			            break;
			        case 2 : 
			            sellerFileVo.setSellerBankCopy(databaseName);
			            break;
			        case 3 : 
			            sellerFileVo.setSellerCertification(databaseName);
			            break; 
			        case 4 : 
			            sellerFileVo.setSellerCommunicationSales(databaseName);
			            break; 
			        case 5 : 
			            sellerFileVo.setSellerProductGrade(databaseName);
			            break;
					}

				} catch (Exception e) {
					System.out.println("Insert File Error");

				}
			
			}
		}
		try {
			//map에 담고 insertSellerFile mapper의 매개변수로 입력 
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println("map value Insert");
			map.put("document_seller_no_pk", sellerFileVo.getSellerNoPk());
			map.put("fk_seller__document_seller", sellerFileVo.getSellerId());
			System.out.println(map.get("fk_seller__document_seller"));
			map.put("document_seller_name", sellerFileVo.getSellerName());
			map.put("document_seller_path", sellerFileVo.getSellerPath());
			map.put("document_seller_path_folder", sellerFileVo.getSellerPathFolder());
			map.put("document_seller_license", sellerFileVo.getSellerLicence());
			map.put("document_seller_bank_copy", sellerFileVo.getSellerBankCopy());
			map.put("document_seller_certificate", sellerFileVo.getSellerCertification());
			map.put("document_seller_communication_sales", sellerFileVo.getSellerCommunicationSales());
			map.put("document_seller_product_grade", sellerFileVo.getSellerProductGrade());
			System.out.println("map value Insert");
			
			/* 맵퍼 계층의 insertSellerFile 메서드 호출 */
			sellerMapper.insertSellerFile(map);
			
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
