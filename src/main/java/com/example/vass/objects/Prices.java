package com.example.vass.objects;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="Prices")
public class Prices implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="BRAND_ID")
	@Getter
	private int brandId;

	@Getter
	@Column(name="START_DATE")
	private String startDate;
	
	@Getter
	@Column(name="END_DATE")
	private String endDate;
	
	@Getter
	@JsonIgnore
	@Column(name="PRICE_LIST")
	private int priceList;
	
	@Getter
	@Column(name="PRODUCT_ID")
	private String productId;
	
	@Getter
	@JsonIgnore
	@Column(name="PRIORITY")
	private int priority;
	
	@Getter
	@Column(name="PRICE")
	private Double price;
	
	@Getter
	@JsonIgnore
	@Column(name="CURR")
	private String curr;
	
	
}
