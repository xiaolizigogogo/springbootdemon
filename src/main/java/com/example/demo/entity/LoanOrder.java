package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document(indexName = "loanorder", type = "LoanOrder", shards = 1, replicas = 0)
@Data
public class LoanOrder implements Serializable {
	/**
	 * 订单号
	 */
	@Field(type = FieldType.text, index = false, store = true)
	private String orderNo;
	/**
	 * id
	 */
	@Id
	@Field(index = false, store = true)
	private String id;
	/**
	 * 来源APP
	 */
	@Field(type = FieldType.text, index = false, store = true)
	private String fromApp;
	/**
	 * 贷款金额
	 */
	@Field(type = FieldType.Double, index = false, store = true)
	private BigDecimal loanMoney;
	/**
	 * 客户姓名
	 */
	@Field(type = FieldType.text, index = true, store = true)
	private String customerName;
	/**
	 * 客户手机号
	 */
	@Field(type = FieldType.text, index = true, store = true)
	private String mobile;
	/**
	 * 车行名称
	 */
	@Field(type = FieldType.text, index = true, store = true)
	private String carShopName;
	/**
	 * 经销商手机号
	 */
	@Field(type = FieldType.text, index = true, store = true)
	private String dealerPhone;
	/**
	 * 流程状态
	 */
	@Field(type = FieldType.text, index = false, store = true)
	private String taskName;
	/**
	 * 生成时间
	 */
	@Field(type = FieldType.Date, index = true, store = true, format = DateFormat.date_time)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
	private Date createTime;

	/**
	 * 申请状态
	 */
	@Field(type = FieldType.text, index = false, store = true)
	private String applyStatus;
	/**
	 * 
	 */
	@Field(type = FieldType.text, index = false, store = true)
	private String taskKey;
	@Field(type = FieldType.text, index = false, store = true)
	private String applyId;
}
