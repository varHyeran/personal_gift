package com.gift.futurestrading.member.vo;

import org.springframework.web.multipart.MultipartFile;
/**
 * @author 정진우
 * @ClassName : SellerFileRequestVo
 * @Version : JDK1.8
 * @LatestUpdate : 2018-12-28
 * Multifileupload 시 바인딩 되는 객체 
 */


public class SellerFileRequestVo {
		private String sellerId;
		private String sellerName;
		private MultipartFile[] multipartFile;

		public String getSellerId() {
			return sellerId;
		}
		public void setSellerId(String sellerId) {
			this.sellerId = sellerId;
		}
		public String getSellerName() {
			return sellerName;
		}
		public void setSellerName(String sellerName) {
			this.sellerName = sellerName;
		}
		public MultipartFile[] getMultipartFile() {
			return multipartFile;
		}
		public void setMultipartFile(MultipartFile[] multipartFile) {
			this.multipartFile = multipartFile;
		}
		
}
