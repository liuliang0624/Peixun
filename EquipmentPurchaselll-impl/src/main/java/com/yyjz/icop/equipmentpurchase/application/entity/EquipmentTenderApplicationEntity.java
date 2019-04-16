package com.yyjz.icop.equipmentpurchase.application.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import com.yyjz.icop.refer.annotation.Refer;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import java.util.ArrayList;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperMainEntity;

/**
 * <p>EquipmentTenderApplicationEntity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="equipment_tender_applicationlll")
@Refer(referCode = "EquipmentTender_Applicationlll", id = "id", name = "tenderName", code = "billCode")
@Display("设备集中采购招标申请（主表）")
public class EquipmentTenderApplicationEntity extends SuperMainEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("申请编号")
	@Column(name="application_number")
	private String applicationNumber ;
	@Display("子表实体")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
	private List<EquipmentTenderApplicationSubEntity> editTable  = new ArrayList<>();
	@Display("我的名字")
	@Column(name="my_name")
	private String myName ;
	@Display("备注")
	@Column(name="remarks")
	private String remarks ;
	@Display("租赁方式")
	@Column(name="rental_method")
	private String rentalMethod ;
	@Display("集中采购区域")
	@Column(name="tender_area")
	private String tenderArea ;
	@Display("招标方式")
	@Column(name="tender_method")
	private String tenderMethod ;
	@Display("集采招标名称")
	@Column(name="tender_name")
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
	public List<EquipmentTenderApplicationSubEntity> getEditTable() {
		return this.editTable;
	}
	public void setEditTable(List<EquipmentTenderApplicationSubEntity> editTable) {
		this.editTable = editTable;
	}
	public String getMyName() {
		return this.myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRentalMethod() {
		return this.rentalMethod;
	}
	public void setRentalMethod(String rentalMethod) {
		this.rentalMethod = rentalMethod;
	}
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