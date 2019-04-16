package com.yyjz.icop.equipmentpurchase.result.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.equipmentpurchase.result.entity.EquipmentTenderResultEntity;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultQueryService;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.BillQuery;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>查询接口实现现</p>
 * <p>@author  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderResultQueryServiceExtend类中完成。 </p>
 */
@Service
public abstract class EquipmentTenderResultQueryServiceImpl implements IEquipmentTenderResultQueryService {

	@Autowired
	protected BillQuery<EquipmentTenderResultEntity> query;

	@Override
	public Page<EquipmentTenderResultVO> showList(QuerySchema querySchema) {
		Page<EquipmentTenderResultEntity> page = query.findPage(EquipmentTenderResultEntity.class, querySchema);
		Pageable pageable = new PageRequest(querySchema.getPageNumber(), querySchema.getPageSize());
		List<EquipmentTenderResultEntity> list = page.getContent();
		List<EquipmentTenderResultVO> vos = new ArrayList<>();
		for (EquipmentTenderResultEntity entity : list) {
			EquipmentTenderResultVO vo = new EquipmentTenderResultVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			vos.add(vo);
		}
		Page<EquipmentTenderResultVO> retVal = new PageImpl<EquipmentTenderResultVO>(vos, pageable, page.getTotalElements());
		return retVal;
	}

	@Override
	public EquipmentTenderResultVO findById(String primaryKey) throws BusinessException {
		try {
			EquipmentTenderResultEntity entity = query.findOne(EquipmentTenderResultEntity.class, primaryKey);
			EquipmentTenderResultVO vo = new EquipmentTenderResultVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			return vo;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

}
