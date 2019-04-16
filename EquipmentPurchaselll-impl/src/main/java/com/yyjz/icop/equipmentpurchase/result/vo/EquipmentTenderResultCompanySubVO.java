package com.yyjz.icop.equipmentpurchase.result.vo;

import java.math.BigDecimal;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperSubVO;

/**
 * <p>EquipmentTenderResultCompanySubVO</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：该类为EquipmentTenderResultCompanySubEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class EquipmentTenderResultCompanySubVO extends SuperSubVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("分供方名称")
	private String deliveryUnit ;
	@Display("法人姓名")
	private String legalName ;
	@Display("法人联系电话")
	private String legalPhone ;
	@Display("主实体")
	private EquipmentTenderResultVO parent ;
	@Display("主实体ID")
	private String pid ;
	@Display("注册资金")
	private BigDecimal registeredCapital ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeliveryUnit() {
		return this.deliveryUnit;
	}
	public void setDeliveryUnit(String deliveryUnit) {
		this.deliveryUnit = deliveryUnit;
	}
	public String getLegalName() {
		return this.legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getLegalPhone() {
		return this.legalPhone;
	}
	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
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
	public BigDecimal getRegisteredCapital() {
		return this.registeredCapital;
	}
	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	
}