package com.yyjz.icop.equipmentpurchase.result.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperSubEntity;

/**
 * <p>EquipmentTenderResultCompanySubEntity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="equipment_tender_result_company_sub")
@Display("中标单位（子表）")
public class EquipmentTenderResultCompanySubEntity extends SuperSubEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("分供方名称")
	@Column(name="delivery_unit")
	private String deliveryUnit ;
	@Display("法人姓名")
	@Column(name="legal_name")
	private String legalName ;
	@Display("法人联系电话")
	@Column(name="legal_phone")
	private String legalPhone ;
	@Display("主实体")
	@ManyToOne
	@JoinColumn(name = "pid" , insertable = false, updatable = false)
	private EquipmentTenderResultEntity parent ;
	@Display("主实体ID")
	@Column(name="pid")
	private String pid ;
	@Display("注册资金")
	@Column(name="registered_capital")
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
	public EquipmentTenderResultEntity getParent() {
		return this.parent;
	}
	public void setParent(EquipmentTenderResultEntity parent) {
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