package com.porfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_users")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactUserId;
	private String contactUserName;
	private String contactUserEmail;
	private String contactUserMsg;
	public Contact() {}
	public Contact(int contactUserId, String contactUserName, String contactUserEmail, String contactuserMsg) {
		super();
		this.contactUserId = contactUserId;
		this.contactUserName = contactUserName;
		this.contactUserEmail = contactUserEmail;
		this.contactUserMsg = contactuserMsg;
	}
	public int getContactUserId() {
		return contactUserId;
	}
	public void setContactUserId(int contactUserId) {
		this.contactUserId = contactUserId;
	}
	public String getContactUserName() {
		return contactUserName;
	}
	public void setContactUserName(String contactUserName) {
		this.contactUserName = contactUserName;
	}
	public String getContactUserEmail() {
		return contactUserEmail;
	}
	public void setContactUserEmail(String contactUserEmail) {
		this.contactUserEmail = contactUserEmail;
	}
	public String getContactuserMsg() {
		return contactUserMsg;
	}
	public void setContactuserMsg(String contactuserMsg) {
		this.contactUserMsg = contactuserMsg;
	}
	@Override
	public String toString() {
		return "Contact [contactUserId=" + contactUserId + ", contactUserName=" + contactUserName
				+ ", contactUserEmail=" + contactUserEmail + ", contactuserMsg=" + contactUserMsg + "]";
	}
	
}
