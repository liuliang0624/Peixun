package com.yyjz.icop.equipmentpurchase.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.equipmentpurchase.application.entity.EquipmentTenderApplicationEntity;
import com.yyjz.icop.equipmentpurchase.application.service.IEquipmentTenderApplicationQueryService;
import com.yyjz.icop.equipmentpurchase.application.vo.EquipmentTenderApplicationVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.BillQuery;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>查询接口实现现</p>
 * <p>@author  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationQueryServiceExtend类中完成。 </p>
 */
@Service
public abstract class EquipmentTenderApplicationQueryServiceImpl implements IEquipmentTenderApplicationQueryService {

	@Autowired
	protected BillQuery<EquipmentTenderApplicationEntity> query;

	@Override
	public Page<EquipmentTenderApplicationVO> showList(QuerySchema querySchema) {
		Page<EquipmentTenderApplicationEntity> page = query.findPage(EquipmentTenderApplicationEntity.class, querySchema);
		Pageable pageable = new PageRequest(querySchema.getPageNumber(), querySchema.getPageSize());
		List<EquipmentTenderApplicationEntity> list = page.getContent();
		List<EquipmentTenderApplicationVO> vos = new ArrayList<>();
		for (EquipmentTenderApplicationEntity entity : list) {
			EquipmentTenderApplicationVO vo = new EquipmentTenderApplicationVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			vos.add(vo);
		}
		Page<EquipmentTenderApplicationVO> retVal = new PageImpl<EquipmentTenderApplicationVO>(vos, pageable, page.getTotalElements());
		return retVal;
	}

	@Override
	public EquipmentTenderApplicationVO findById(String primaryKey) throws BusinessException {
		try {
			EquipmentTenderApplicationEntity entity = query.findOne(EquipmentTenderApplicationEntity.class, primaryKey);
			EquipmentTenderApplicationVO vo = new EquipmentTenderApplicationVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			return vo;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

}
