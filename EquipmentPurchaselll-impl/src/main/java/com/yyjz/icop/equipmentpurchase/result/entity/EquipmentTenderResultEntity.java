package com.yyjz.icop.equipmentpurchase.result.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import com.yyjz.icop.refer.annotation.ReferDeserialTransfer;
import com.yyjz.icop.refer.annotation.ReferSerialTransfer;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.ManyToOne;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultListSubEntity;
import javax.persistence.CascadeType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultCompanySubEntity;
import java.util.ArrayList;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperMainEntity;

/**
 * <p>EquipmentTenderResultEntity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="equipment_tender_result")
@Display("设备集中采购招标结果（主表）")
public class EquipmentTenderResultEntity extends SuperMainEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("子表中标单位")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
	private List<EquipmentTenderResultCompanySubEntity> companyTable  = new ArrayList<>();
	@Display("是否有清单")
	@Column(name="list_bool")
	private boolean listBool ;
	@Display("子表设备清单")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
	private List<EquipmentTenderResultListSubEntity> listTable  = new ArrayList<>();
	@Display("开标日期")
	@Column(name="opening_tender_data")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date openingTenderData ;
	@Display("参数")
	@Column(name="parameter")
	private String parameter ;
	@Display("备注")
	@Column(name="remarks")
	private String remarks ;
	@Display("集中采购区域")
	@Column(name="tender_area")
	private String tenderArea ;
	@Display("招标日期")
	@Column(name="tender_data")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date tenderData ;
	@Display("招标方式")
	@Column(name="tender_method")
	private String tenderMethod ;
	@Display("集采招标名称")
	@Column(name="tender_name")
	private String tenderName ;
	@Display("总金额")
	@Column(name="total_money")
	private BigDecimal totalMoney ;




	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<EquipmentTenderResultCompanySubEntity> getCompanyTable() {
		return this.companyTable;
	}
	public void setCompanyTable(List<EquipmentTenderResultCompanySubEntity> companyTable) {
		this.companyTable = companyTable;
	}
	public boolean getListBool() {
		return this.listBool;
	}
	public void setListBool(boolean listBool) {
		this.listBool = listBool;
	}
	public List<EquipmentTenderResultListSubEntity> getListTable() {
		return this.listTable;
	}
	public void setListTable(List<EquipmentTenderResultListSubEntity> listTable) {
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

	@ReferSerialTransfer(referCode="EquipmentTender_Applicationlll")  //招标名称引入参照
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