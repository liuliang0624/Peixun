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
 * <p>EquipmentTenderResultListSubEntity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name = "equipment_tender_result_list_sub")
@Display("设备结果清单（子表）")
public class EquipmentTenderResultListSubEntity extends SuperSubEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    @Display("主键")
    private String id;
    @Display("设备名称")
    @Column(name = "equipment_name")
    private String equipmentName;
    @Display("数量")
    @Column(name = "number")
    private BigDecimal number;
    @Display("主实体")
    @ManyToOne
    @JoinColumn(name = "pid", insertable = false, updatable = false)
    private EquipmentTenderResultEntity parent;
    @Display("主实体ID")
    @Column(name = "pid")
    private String pid;
    @Display("规格型号")
    @Column(name = "specification")
    private String specification;
    @Display("单价")
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    //增加总金额字段

    @Display("总金额")
    @Column(name = "total_equipment")
    private BigDecimal totalEquipment;

    public BigDecimal getTotalEquipment() {
        return totalEquipment;
    }

    public void setTotalEquipment(BigDecimal totalEquipment) {
        this.totalEquipment = totalEquipment;
    }

    //增加总金额字段
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