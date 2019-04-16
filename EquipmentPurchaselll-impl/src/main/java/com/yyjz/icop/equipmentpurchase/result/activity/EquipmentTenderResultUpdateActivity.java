package com.yyjz.icop.equipmentpurchase.result.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.UpdateAuditinfoRule;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.UpdateTemplate;

/**
 * <p>修改activity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderResultUpdateActivityExtend类中完成。 </p>
 */
@Activity
public abstract class EquipmentTenderResultUpdateActivity {

	@Autowired
	protected UpdateAuditinfoRule<EquipmentTenderResultEntity> updateAuditinfoRule;
	@Autowired
	protected UpdateTemplate<EquipmentTenderResultEntity> update;

	public EquipmentTenderResultEntity update(EquipmentTenderResultEntity entity) {
			update.addBeforeRule(updateAuditinfoRule);
			update.addAfterRule(null);
			EquipmentTenderResultEntity[] backEntity = update.doAction(new EquipmentTenderResultEntity[] { entity });
			return backEntity[0];
	}
}
