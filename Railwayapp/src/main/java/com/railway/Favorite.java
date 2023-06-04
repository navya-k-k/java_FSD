package com.railway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Favorite 
{
	@Id
	@Column(unique = true)
	private int rid;
	private String rname;
	private String raddress;
	private String rlandmark;
	private String rschedule;
	private String rperson;
	private String rstatus;
	public int getRid() {
		return rid;
	}
	
	

	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRlandmark() {
		return rlandmark;
	}
	public void setRlandmark(String rlandmark) {
		this.rlandmark = rlandmark;
	}
	public String getRschedule() {
		return rschedule;
	}
	public void setRschedule(String rschedule) {
		this.rschedule = rschedule;
	}
	public String getRperson() {
		return rperson;
	}
	public void setRperson(String rperson) {
		this.rperson = rperson;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	
}
