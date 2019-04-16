package com.yyjz.icop.equipmentpurchase.application.service.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.equipmentpurchase.application.activity.extend.EquipmentTenderApplicationDeleteActivityExtend;
import com.yyjz.icop.equipmentpurchase.application.activity.extend.EquipmentTenderApplicationInsertActivityExtend;
import com.yyjz.icop.equipmentpurchase.application.activity.extend.EquipmentTenderApplicationUpdateActivityExtend;
import com.yyjz.icop.equipmentpurchase.application.service.IEquipmentTenderApplicationService;
import com.yyjz.icop.equipmentpurchase.application.service.impl.EquipmentTenderApplicationServiceImpl;

/**
 * <p>操作接口扩展</p>
 * <p>@author  2019-04-15</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Service
@Transactional
public class EquipmentTenderApplicationServiceExtend extends EquipmentTenderApplicationServiceImpl implements IEquipmentTenderApplicationService {
	
	@Autowired
	private EquipmentTenderApplicationInsertActivityExtend equipmentTenderApplicationInsertActivityExtend;
	
	@Autowired
	private EquipmentTenderApplicationUpdateActivityExtend equipmentTenderApplicationUpdateActivityExtend;
	
	@Autowired
	private EquipmentTenderApplicationDeleteActivityExtend equipmentTenderApplicationDeleteActivityExtend;

	
}
