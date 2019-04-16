package com.yyjz.icop.equipmentpurchase.result.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.equipmentpurchase.result.activity.EquipmentTenderResultDeleteActivity;
import com.yyjz.icop.equipmentpurchase.result.activity.EquipmentTenderResultInsertActivity;
import com.yyjz.icop.equipmentpurchase.result.activity.EquipmentTenderResultUpdateActivity;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultService;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>操作接口实现</p>
 * <p>@author  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderResultServiceExtend类中完成。 </p>
 */
@Service
@Transactional
public abstract class EquipmentTenderResultServiceImpl implements IEquipmentTenderResultService {

	@Autowired
	protected EquipmentTenderResultInsertActivity equipmentTenderResultInsertActivity;
	@Autowired
	protected EquipmentTenderResultUpdateActivity equipmentTenderResultUpdateActivity;
	@Autowired
	protected EquipmentTenderResultDeleteActivity equipmentTenderResultDeleteActivity;

	@Override
	public EquipmentTenderResultVO insert(EquipmentTenderResultVO equipmentTenderResultVO) {
		try {
			EquipmentTenderResultEntity newEntity = new EquipmentTenderResultEntity();
			DataObjectUtils.copyVOToEntity(equipmentTenderResultVO, newEntity);
			EquipmentTenderResultEntity backEntity = equipmentTenderResultInsertActivity.insert(newEntity);
			EquipmentTenderResultVO backVO = new EquipmentTenderResultVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return equipmentTenderResultVO;

	}

	@Override
	public EquipmentTenderResultVO update(EquipmentTenderResultVO equipmentTenderResultVO) {
		try {
			EquipmentTenderResultEntity newEntity = new EquipmentTenderResultEntity();
			DataObjectUtils.copyVOToEntity(equipmentTenderResultVO, newEntity);
			EquipmentTenderResultEntity backEntity = equipmentTenderResultUpdateActivity.update(newEntity);
			EquipmentTenderResultVO backVO = new EquipmentTenderResultVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return equipmentTenderResultVO;
	}

	@Override
	public void delete(EquipmentTenderResultVO[] equipmentTenderResultVOs) {
		try {
			List<EquipmentTenderResultEntity> entityList = new ArrayList<>();
			for (EquipmentTenderResultVO vo : equipmentTenderResultVOs) {
				EquipmentTenderResultEntity newEntity = new EquipmentTenderResultEntity();
				DataObjectUtils.copyVOToEntity(vo, newEntity);
				entityList.add(newEntity);
			}
			equipmentTenderResultDeleteActivity.delete(entityList.toArray(new EquipmentTenderResultEntity[0]));
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

}
