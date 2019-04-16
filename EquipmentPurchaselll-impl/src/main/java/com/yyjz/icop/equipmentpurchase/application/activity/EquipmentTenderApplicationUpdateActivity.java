package com.yyjz.icop.equipmentpurchase.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.UpdateAuditinfoRule;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.UpdateTemplate;

/**
 * <p>修改activity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationUpdateActivityExtend类中完成。 </p>
 */
@Activity
public abstract class EquipmentTenderApplicationUpdateActivity {

	@Autowired
	protected UpdateAuditinfoRule<EquipmentTenderApplicationEntity> updateAuditinfoRule;
	@Autowired
	protected UpdateTemplate<EquipmentTenderApplicationEntity> update;

	public EquipmentTenderApplicationEntity update(EquipmentTenderApplicationEntity entity) {
			update.addBeforeRule(updateAuditinfoRule);
			update.addAfterRule(null);
			EquipmentTenderApplicationEntity[] backEntity = update.doAction(new EquipmentTenderApplicationEntity[] { entity });
			return backEntity[0];
	}
}
