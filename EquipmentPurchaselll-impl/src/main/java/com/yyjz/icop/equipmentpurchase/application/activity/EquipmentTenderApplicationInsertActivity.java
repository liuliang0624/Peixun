package com.yyjz.icop.equipmentpurchase.application.activity;

import com.yyjz.icop.equipmentpurchase.application.rule.EquipmentPurchaseApplicationRule;
import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.AddAuditinfoRule;
import com.yyjz.icop.application.rule.AddFsAttachRule;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.InsertTemplate;

/**
 * <p>新增activity</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationInsertActivityExtend类中完成。 </p>
 */
@Activity
public abstract class EquipmentTenderApplicationInsertActivity {
	@Autowired
	protected InsertTemplate<EquipmentTenderApplicationEntity> insert;
	/**
	 * 引入审计信息公共rule
	 */
	@Autowired
	protected AddAuditinfoRule<EquipmentTenderApplicationEntity> addAuditinfoRule;
	@Autowired
	protected EquipmentPurchaseApplicationRule equipmentPurchaseApplicationRule;
	/**
	 * 引入附件公共rule
	 */
	@Autowired
	protected AddFsAttachRule<EquipmentTenderApplicationEntity> addFsAttachRule;

	public EquipmentTenderApplicationEntity insert(EquipmentTenderApplicationEntity entity) {
		insert.addBeforeRule(addAuditinfoRule);
		insert.addAfterRule(addFsAttachRule);
	    insert.addBeforeRule(equipmentPurchaseApplicationRule);

		EquipmentTenderApplicationEntity[] backEntity = insert.doAction(new EquipmentTenderApplicationEntity[] { entity });
		return backEntity[0];
	}
}
