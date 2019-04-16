package com.yyjz.icop.equipmentpurchase.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.equipmentpurchase.application.activity.EquipmentTenderApplicationDeleteActivity;
import com.yyjz.icop.equipmentpurchase.application.activity.EquipmentTenderApplicationInsertActivity;
import com.yyjz.icop.equipmentpurchase.application.activity.EquipmentTenderApplicationUpdateActivity;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import com.yyjz.icop.equipmentpurchase.application.service.IEquipmentTenderApplicationService;
import com.yyjz.icop.equipmentpurchase.application.vo.EquipmentTenderApplicationVO;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>操作接口实现</p>
 * <p>@author  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationServiceExtend类中完成。 </p>
 */
@Service
@Transactional
public abstract class EquipmentTenderApplicationServiceImpl implements IEquipmentTenderApplicationService {

	@Autowired
	protected EquipmentTenderApplicationInsertActivity equipmentTenderApplicationInsertActivity;
	@Autowired
	protected EquipmentTenderApplicationUpdateActivity equipmentTenderApplicationUpdateActivity;
	@Autowired
	protected EquipmentTenderApplicationDeleteActivity equipmentTenderApplicationDeleteActivity;

	@Override
	public EquipmentTenderApplicationVO insert(EquipmentTenderApplicationVO equipmentTenderApplicationVO) {
		try {
			EquipmentTenderApplicationEntity newEntity = new EquipmentTenderApplicationEntity();
			DataObjectUtils.copyVOToEntity(equipmentTenderApplicationVO, newEntity);
			EquipmentTenderApplicationEntity backEntity = equipmentTenderApplicationInsertActivity.insert(newEntity);
			EquipmentTenderApplicationVO backVO = new EquipmentTenderApplicationVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return equipmentTenderApplicationVO;

	}

	@Override
	public EquipmentTenderApplicationVO update(EquipmentTenderApplicationVO equipmentTenderApplicationVO) {
		try {
			EquipmentTenderApplicationEntity newEntity = new EquipmentTenderApplicationEntity();
			DataObjectUtils.copyVOToEntity(equipmentTenderApplicationVO, newEntity);
			EquipmentTenderApplicationEntity backEntity = equipmentTenderApplicationUpdateActivity.update(newEntity);
			EquipmentTenderApplicationVO backVO = new EquipmentTenderApplicationVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return equipmentTenderApplicationVO;
	}

	@Override
	public void delete(EquipmentTenderApplicationVO[] equipmentTenderApplicationVOs) {
		try {
			List<EquipmentTenderApplicationEntity> entityList = new ArrayList<>();
			for (EquipmentTenderApplicationVO vo : equipmentTenderApplicationVOs) {
				EquipmentTenderApplicationEntity newEntity = new EquipmentTenderApplicationEntity();
				DataObjectUtils.copyVOToEntity(vo, newEntity);
				entityList.add(newEntity);
			}
			equipmentTenderApplicationDeleteActivity.delete(entityList.toArray(new EquipmentTenderApplicationEntity[0]));
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

}
