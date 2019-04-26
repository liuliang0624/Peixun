package com.yyjz.icop.equipmentpurchase.result.rule;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import com.yyjz.icop.pubapp.platform.annotation.Rule;
import com.yyjz.icop.pubapp.platform.rule.IcopRule;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;

@Rule
public class EquipmentPurchaseResultRule implements IcopRule<EquipmentTenderResultEntity> {
    @Override
    public void process(EquipmentTenderResultEntity[] entitys) {
        EquipmentTenderResultEntity entity = entitys[0];

       // entity.setSelectedState("1");  //当单将据被选择时，将此单据的selectedState属性设置为1，表示已被选择
    }




}
