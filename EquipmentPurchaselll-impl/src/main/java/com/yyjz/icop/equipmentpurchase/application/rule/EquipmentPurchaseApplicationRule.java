package com.yyjz.icop.equipmentpurchase.application.rule;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import com.yyjz.icop.pubapp.platform.annotation.Rule;
import com.yyjz.icop.pubapp.platform.rule.IcopRule;
@Rule   //注解是路由
public class EquipmentPurchaseApplicationRule implements IcopRule<EquipmentTenderApplicationEntity> {

    @Override
    public void process(EquipmentTenderApplicationEntity[] entitys) {
        EquipmentTenderApplicationEntity entity = entitys[0];
        String myName = "小刘";
        entity.setMyName(myName);
    }

    @Override
    public int order() {
        return 10000;
    }
}