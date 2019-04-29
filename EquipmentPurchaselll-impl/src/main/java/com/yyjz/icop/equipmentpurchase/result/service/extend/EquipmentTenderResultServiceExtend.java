package com.yyjz.icop.equipmentpurchase.result.service.extend;

import com.alibaba.dubbo.common.utils.CollectionUtils;   //导入正确的包
import com.yyjz.icop.database.util.ExceptionUtils;//导入正确的包
import com.yyjz.icop.equipmentpurchase.result.rule.ErrorMap;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultListSubVO;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.excel.ImportExcel;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultDeleteActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultInsertActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.activity.extend.EquipmentTenderResultUpdateActivityExtend;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultService;
import com.yyjz.icop.equipmentpurchase.result.service.impl.EquipmentTenderResultServiceImpl;
import com.yyjz.icop.equipmentpurchase.result.rule.ErrorMap;

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


    public ErrorMap importExcel(ImportExcel importExcel) throws BusinessException {
        JsonBackData back = new JsonBackData();
        List<EquipmentTenderResultListSubVO> exportList = new ArrayList<>();
        Map<String, List<String>> errMap = new LinkedHashMap<>();//记录错误信息
        ErrorMap errorMap = new ErrorMap();
        try {

            exportList = importExcel.getDataList(EquipmentTenderResultListSubVO.class, errMap);
            List<String>  stringList= new ArrayList<>();
            if (CollectionUtils.isNotEmpty(exportList)) {
                if (!errMap.isEmpty()) {

                    for (String sKey : errMap.keySet()) {
                        List<String> valueList = errMap.get(sKey);
                        if (CollectionUtils.isNotEmpty(valueList)) {
                            String errMsg = valueList.get(0);
                            errorMap.setErrorNumbers(errMap.size());
                            String str=new String();
                            str=sKey+errMsg;
                            stringList.add(str);
                            errorMap.setStringList(stringList);
                            errorMap.setErrorDetail(stringList);

                           // throw new BusinessException(sKey + errMsg);
                        }
                    }
                }

            }
        } catch (Exception e) {
           // ExceptionUtils.marsh(e);
            e.printStackTrace();
        }
        errorMap.setList(exportList);
        errorMap.setNumbers(exportList);
        return errorMap;
    }
}
