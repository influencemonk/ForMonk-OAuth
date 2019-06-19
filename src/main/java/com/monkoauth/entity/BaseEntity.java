package com.monkoauth.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public class BaseEntity  {

	@CreatedDate
	private Date createdOn;

	@LastModifiedDate
	private Date updatedOn;

	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



}