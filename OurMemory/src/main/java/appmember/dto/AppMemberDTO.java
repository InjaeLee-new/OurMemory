package appmember.dto;

public class AppMemberDTO {

	private String id;			//아이디
	private String cate1;		//카테고리1
	private String cate2;		//카테고리2
	private String cate3;		//카테고리3
	private String google_Id;	//구글고유아이디
    private String kakao_Id;	//카카오고유아이디
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCate1() {
		return cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}
	public String getCate2() {
		return cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}
	public String getCate3() {
		return cate3;
	}
	public void setCate3(String cate3) {
		this.cate3 = cate3;
	}
	public String getGoogle_Id() {
		return google_Id;
	}
	public void setGoogle_Id(String google_Id) {
		this.google_Id = google_Id;
	}
	public String getKakao_Id() {
		return kakao_Id;
	}
	public void setKakao_Id(String kakao_Id) {
		this.kakao_Id = kakao_Id;
	}
	
    
}
