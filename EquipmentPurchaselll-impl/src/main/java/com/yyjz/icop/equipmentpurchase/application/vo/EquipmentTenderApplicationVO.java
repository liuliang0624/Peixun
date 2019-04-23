package com.yyjz.icop.equipmentpurchase.application.vo;

import java.util.List;
import java.util.ArrayList;

import com.yyjz.icop.excel.annotation.ExcelField;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperExtendMainVO;
import com.yyjz.icop.pubapp.platform.vo.SuperMainVO;

/**
 * <p>EquipmentTenderApplicationVO</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：该类为EquipmentTenderApplicationEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class EquipmentTenderApplicationVO extends SuperExtendMainVO {
	private static final long serialVersionUID = 1L;

	@Display("主键")
	private String id ;
	@Display("申请编号")
	private String applicationNumber ;
	@Display("子表实体")
	private List<EquipmentTenderApplicationSubVO> editTable  = new ArrayList<>();
	@Display("我的名字")
	private String myName ;
	@Display("备注")
	private String remarks ;
	@Display("租赁方式")
	private String rentalMethod ;
	@Display("集中采购区域")
	private String tenderArea ;
	@Display("招标方式")
	private String tenderMethod ;
	@Display("集采招标名称")
	private String tenderName ;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplicationNumber() {
		return this.applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public List<EquipmentTenderApplicationSubVO> getEditTable() {
		return this.editTable;
	}
	public void setEditTable(List<EquipmentTenderApplicationSubVO> editTable) {
		this.editTable = editTable;
	}
	@ExcelField(title = "我的名字" ,sort = 1)  //导出注解
	public String getMyName() {
		return this.myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	@ExcelField(title = "注解" ,sort = 1)  //导出注解
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@ExcelField(title = "租赁方法" ,sort = 1)  //导出注解
	public String getRentalMethod() {
		return this.rentalMethod;
	}
	public void setRentalMethod(String rentalMethod) {
		this.rentalMethod = rentalMethod;
	}
	@ExcelField(title = "集采区域" ,sort = 1)  //导出注解
	public String getTenderArea() {
		return this.tenderArea;
	}
	public void setTenderArea(String tenderArea) {
		this.tenderArea = tenderArea;
	}
	public String getTenderMethod() {
		return this.tenderMethod;
	}
	public void setTenderMethod(String tenderMethod) {
		this.tenderMethod = tenderMethod;
	}
	public String getTenderName() {
		return this.tenderName;
	}
	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}

}