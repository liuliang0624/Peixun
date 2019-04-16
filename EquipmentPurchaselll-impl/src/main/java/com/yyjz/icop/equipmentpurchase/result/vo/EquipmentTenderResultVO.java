package com.yyjz.icop.equipmentpurchase.result.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperMainVO;
import com.yyjz.icop.refer.annotation.ReferDeserialTransfer;
import com.yyjz.icop.refer.annotation.ReferSerialTransfer;

/**
 * <p>EquipmentTenderResultVO</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：该类为EquipmentTenderResultEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class EquipmentTenderResultVO extends SuperMainVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("子表中标单位")
	private List<EquipmentTenderResultCompanySubVO> companyTable  = new ArrayList<>();
	@Display("是否有清单")
	private boolean listBool ;
	@Display("子表设备清单")
	private List<EquipmentTenderResultListSubVO> listTable  = new ArrayList<>();
	@Display("开标日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openingTenderData ;
	@Display("参数")
	private String parameter ;
	@Display("备注")
	private String remarks ;
	@Display("集中采购区域")
	private String tenderArea ;
	@Display("招标日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date tenderData ;
	@Display("招标方式")
	private String tenderMethod ;
	@Display("集采招标名称")
	private String tenderName ;
	@Display("总金额")
	private BigDecimal totalMoney ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<EquipmentTenderResultCompanySubVO> getCompanyTable() {
		return this.companyTable;
	}
	public void setCompanyTable(List<EquipmentTenderResultCompanySubVO> companyTable) {
		this.companyTable = companyTable;
	}
	public boolean getListBool() {
		return this.listBool;
	}
	public void setListBool(boolean listBool) {
		this.listBool = listBool;
	}
	public List<EquipmentTenderResultListSubVO> getListTable() {
		return this.listTable;
	}
	public void setListTable(List<EquipmentTenderResultListSubVO> listTable) {
		this.listTable = listTable;
	}
	public Date getOpeningTenderData() {
		return this.openingTenderData;
	}
	public void setOpeningTenderData(Date openingTenderData) {
		this.openingTenderData = openingTenderData;
	}
	public String getParameter() {
		return this.parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTenderArea() {
		return this.tenderArea;
	}
	public void setTenderArea(String tenderArea) {
		this.tenderArea = tenderArea;
	}
	public Date getTenderData() {
		return this.tenderData;
	}
	public void setTenderData(Date tenderData) {
		this.tenderData = tenderData;
	}
	public String getTenderMethod() {
		return this.tenderMethod;
	}
	public void setTenderMethod(String tenderMethod) {
		this.tenderMethod = tenderMethod;
	}
	@ReferSerialTransfer(referCode="EquipmentTender_Applicationlll")
	public String getTenderName() {
		return this.tenderName;
	}
	@ReferDeserialTransfer
	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}
	public BigDecimal getTotalMoney() {
		return this.totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}