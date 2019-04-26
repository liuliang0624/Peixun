package com.yyjz.icop.equipmentpurchase.result.activity;

import com.yyjz.icop.equipmentpurchase.result.rule.EquipmentPurchaseResultRule;
import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.AddAuditinfoRule;
import com.yyjz.icop.application.rule.AddFsAttachRule;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.InsertTemplate;

/**
 * <p>新增activity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderResultInsertActivityExtend类中完成。 </p>
 */
@Activity
public abstract class EquipmentTenderResultInsertActivity {
	@Autowired
	protected InsertTemplate<EquipmentTenderResultEntity> insert;
	/**
	 * 引入审计信息公共rule
	 */
	@Autowired
	protected AddAuditinfoRule<EquipmentTenderResultEntity> addAuditinfoRule;

	@Autowired
	protected EquipmentPurchaseResultRule equipmentPurchaseResultRule;//引入我的规则

	/**
	 * 引入附件公共rule
	 */
	@Autowired
	protected AddFsAttachRule<EquipmentTenderResultEntity> addFsAttachRule;

	public EquipmentTenderResultEntity insert(EquipmentTenderResultEntity entity) {
		insert.addBeforeRule(addAuditinfoRule);
		insert.addAfterRule(addFsAttachRule);
		insert.addAfterRule(equipmentPurchaseResultRule);
		EquipmentTenderResultEntity[] backEntity = insert.doAction(new EquipmentTenderResultEntity[] { entity });
		return backEntity[0];
	}
}
