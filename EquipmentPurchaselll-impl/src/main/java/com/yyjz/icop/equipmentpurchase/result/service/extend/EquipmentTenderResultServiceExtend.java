package com.yyjz.icop.equipmentpurchase.result.service.extend;

import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultListSubVO;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.excel.ImportExcel;
import com.yyjz.icop.exception.BusinessException;
import net.sf.cglib.core.CollectionUtils;
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

			if(!errMap.isEmpty()){
				for(String sKey:errMap.keySet()){
					List<String> valueList=errMap.get(sKey);
					//if(CollectionUtils.i)
				}
			}


		} catch (Exception e) {
			System.out.println(e);
		}
		return exportList;
	}
}
