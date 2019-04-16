package com.yyjz.icop.equipmentpurchase.result.service.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultDeleteActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultInsertActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultUpdateActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultService;
import com.yyjz.icop.equipmentpurchase.result.service.impl.EquipmentTenderResultServiceImpl;

/**
 * <p>操作接口扩展</p>
 * <p>@author  2019-04-15</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Service
@Transactional
public class EquipmentTenderResultServiceExtend extends EquipmentTenderResultServiceImpl implements IEquipmentTenderResultService {
	
	@Autowired
	private EquipmentTenderResultInsertActivityExtend equipmentTenderResultInsertActivityExtend;
	
	@Autowired
	private EquipmentTenderResultUpdateActivityExtend equipmentTenderResultUpdateActivityExtend;
	
	@Autowired
	private EquipmentTenderResultDeleteActivityExtend equipmentTenderResultDeleteActivityExtend;

	
}
