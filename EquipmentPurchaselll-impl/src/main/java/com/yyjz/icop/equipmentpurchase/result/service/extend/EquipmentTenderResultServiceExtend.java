package com.yyjz.icop.equipmentpurchase.result.service.extend;

import com.alibaba.dubbo.common.utils.CollectionUtils;   //导入正确的包
import com.yyjz.icop.database.util.ExceptionUtils;//导入正确的包
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultListSubVO;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.excel.ImportExcel;
import com.yyjz.icop.exception.BusinessException;
import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultDeleteActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultInsertActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultUpdateActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultService;
import com.yyjz.icop.equipmentpurchase.result.service.impl.EquipmentTenderResultServiceImpl;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


	public List<EquipmentTenderResultListSubVO> importExcel(ImportExcel importExcel) throws BusinessException {

		List<EquipmentTenderResultListSubVO> exportList = new ArrayList<>();
		try {
			Map<String, List<String>> errMap = new LinkedHashMap<>();//记录错误信息
			exportList = importExcel.getDataList(EquipmentTenderResultListSubVO.class, errMap);
			if(CollectionUtils.isNotEmpty(exportList)){
				if(!errMap.isEmpty()){
					for (String sKey:errMap.keySet()){
						List<String> valueList=errMap.get(sKey);
						if(CollectionUtils.isNotEmpty(valueList)){
							String errMsg=valueList.get(0);
							throw  new BusinessException(sKey+errMsg);
						}
					}
				}
			}
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return exportList;
	}
}
