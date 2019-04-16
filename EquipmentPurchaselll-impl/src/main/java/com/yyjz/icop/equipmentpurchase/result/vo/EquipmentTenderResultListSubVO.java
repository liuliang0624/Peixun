package com.yyjz.icop.equipmentpurchase.result.vo;

import java.math.BigDecimal;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperSubVO;

/**
 * <p>EquipmentTenderResultListSubVO</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：该类为EquipmentTenderResultListSubEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class EquipmentTenderResultListSubVO extends SuperSubVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("设备名称")
	private String equipmentName ;
	@Display("数量")
	private BigDecimal number ;
	@Display("主实体")
	private EquipmentTenderResultVO parent ;
	@Display("主实体ID")
	private String pid ;
	@Display("规格型号")
	private String specification ;
	@Display("单价")
	private BigDecimal unitPrice ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEquipmentName() {
		return this.equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public BigDecimal getNumber() {
		return this.number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public EquipmentTenderResultVO getParent() {
		return this.parent;
	}
	public void setParent(EquipmentTenderResultVO parent) {
		this.parent = parent;
	}
	public String getPid() {
		return this.pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSpecification() {
		return this.specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}