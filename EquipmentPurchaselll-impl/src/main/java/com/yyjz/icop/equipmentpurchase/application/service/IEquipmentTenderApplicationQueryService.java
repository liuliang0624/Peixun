package com.yyjz.icop.equipmentpurchase.application.service;

import org.springframework.data.domain.Page;

import com.yyjz.icop.equipmentpurchase.application.vo.EquipmentTenderApplicationVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;

/**
 * <p>查询服务接口</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationQueryServiceExtend类中完成。 </p>
 */
public interface IEquipmentTenderApplicationQueryService {
	Page<EquipmentTenderApplicationVO> showList(QuerySchema querySchema) throws BusinessException;
	EquipmentTenderApplicationVO findById(String primaryKey) throws BusinessException;
}
