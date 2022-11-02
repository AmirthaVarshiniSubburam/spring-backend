package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "Userdetails")
public class UserDetails {
	@Id
	@Column(name = "EmailId")
	String id;
	@Column(name = "Name")
	String name;
	@Column(name = "Address")
	String emailid;
	@Column(name = "MobileNumber")
	String mobno;
	@Column(name = "AccountNumber")
	String accno;
	@Column(name = "Password")
	String Password;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String id, String name, String emailid, String mobno, String accno, String password) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobno = mobno;
		this.accno = accno;
		Password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword1(String password) {
		Password = password;
	}
		
	public void setPassword(String password) {
			
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encryptedPwd = pwdEncoder.encode(password);
		this.Password = encryptedPwd;				
	
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobno=" + mobno + ", accno="
				+ accno + ", Password=" + Password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Password, accno, emailid, id, mobno, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(Password, other.Password) && Objects.equals(accno, other.accno)
				&& Objects.equals(emailid, other.emailid) && Objects.equals(id, other.id)
				&& Objects.equals(mobno, other.mobno) && Objects.equals(name, other.name);
	}
		
	
}
