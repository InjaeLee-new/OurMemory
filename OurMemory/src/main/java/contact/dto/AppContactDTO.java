package contact.dto;

public class AppContactDTO {
	private int contact_num;
	private String contact_name;
	private String contact_id;
	private String contact_email; 
	private String contact_tel;  
	private String contact_callback; 
	private String contact_subject; 
	private String contact_content;
	private String contact_file;
	
	public String getContact_file() {
		return contact_file;
	}
	public void setContact_file(String contact_file) {
		this.contact_file = contact_file;
	}
	private String contact_logtime;
	
	public int getContact_num() {
		return contact_num;
	}
	public void setContact_num(int contact_num) {
		this.contact_num = contact_num;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getContact_tel() {
		return contact_tel;
	}
	public void setContact_tel(String contact_tel) {
		this.contact_tel = contact_tel;
	}
	public String getContact_callback() {
		return contact_callback;
	}
	public void setContact_callback(String contact_callback) {
		this.contact_callback = contact_callback;
	}
	public String getContact_subject() {
		return contact_subject;
	}
	public void setContact_subject(String contact_subject) {
		this.contact_subject = contact_subject;
	}
	public String getContact_content() {
		return contact_content;
	}
	public void setContact_content(String contact_content) {
		this.contact_content = contact_content;
	}
	public String getContact_logtime() {
		return contact_logtime;
	}
	public void setContact_logtime(String contact_logtime) {
		this.contact_logtime = contact_logtime;
	}
	
}
