package com.yyjz.icop.equipmentpurchase.result.controller.extend;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultListSubVO;
import com.yyjz.icop.excel.ImportExcel;
import net.sf.cglib.core.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyjz.icop.equipmentpurchase.result.controller.EquipmentTenderResultController;
import com.yyjz.icop.equipmentpurchase.result.service.extend.EquipmentTenderResultQueryServiceExtend;
import com.yyjz.icop.equipmentpurchase.result.service.extend.EquipmentTenderResultServiceExtend;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.pubapp.platform.print.PrintAttributeConvert;
import com.yyjz.icop.pubapp.platform.print.PrintUtil;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.pubapp.platform.export.ExportConvertUtil;
import com.yyjz.icop.pubapp.platform.export.ExportDataConvert;
import com.yyjz.icop.pubapp.platform.export.ExportDataScope;
import com.yyjz.icop.pubapp.platform.export.ExportParams;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.exception.BusinessException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>前台交互rest服务扩展</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Controller
@RequestMapping(value = "equipmentTenderResult")
public class EquipmentTenderResultControllerExtend extends EquipmentTenderResultController {

    @Autowired
    protected EquipmentTenderResultServiceExtend equipmentTenderResultServiceExtend;


    @Autowired
    protected EquipmentTenderResultQueryServiceExtend equipmentTenderResultQueryServiceExtend;


    @RequestMapping(value = "print", method = RequestMethod.GET)
    @ResponseBody
    public JsonBackData queryPrint(@RequestParam String id) {
        JsonBackData back = new JsonBackData();
        try {
            EquipmentTenderResultVO vo = equipmentTenderResultQueryService.findById(id);
            JSONObject json = PrintUtil.convertPrintData(vo, new PrintAttributeConvert() {
                @Override
                public void convert(JSONObject entityJson) {
                    // TODO 根据业务需求将某些字段进行转换，例如：sex = true 转换为sex = "男"等。
                }
            });
            back.setBackData(json);
            back.setSuccess(true);
            back.setBackMsg("查询打印数据成功");
        } catch (BusinessException e) {
            back.setSuccess(false);
            back.setBackMsg("查询打印数据失败:" + e.getMessage());
        }
        return back;
    }

    /**
     * 导出Excel
     *
     * @param response
     * @param params
     * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public void exportExcel(HttpServletResponse response, @RequestBody ExportParams<EquipmentTenderResultVO> params) {
        List<EquipmentTenderResultVO> dataList = null;
        try {
            if (ExportDataScope.ALL.name().equalsIgnoreCase(params.getScope())) {
                QuerySchema queryScheme = params.getQueryScheme();
                if (queryScheme != null) {
                    // 根据查询方案查询所有数据
                    queryScheme.setPageNumber(0);
                    queryScheme.setPageSize(ExportParams.maxExportSize);
                    Page<EquipmentTenderResultVO> page = equipmentTenderResultQueryServiceExtend.showList(queryScheme);
                    dataList = page.getContent();
                } else {
                    dataList = Collections.emptyList();
                }
            } else {
                // 前端传递页面数据
                dataList = params.getData();
            }
            // 数据转换
            dataList = ExportConvertUtil.convertDatas(dataList, new ExportDataConvert<EquipmentTenderResultVO>() {
                @Override
                public void convert(EquipmentTenderResultVO vo) {
                    // 自定义数据转换
                }
            });
        } catch (BusinessException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        if (params.getUseTemplate()) { // 使用模板
            String templatePath = this.getClass().getResource("../../").getPath() + "template/text.xlsx"; // 模板路径
            ExportExcelUtils.exportWithTemplete(response, params.getFileName(), templatePath, 4, 0, dataList,
                    EquipmentTenderResultVO.class);
        } else { // 不使用模板
            ExportExcelUtils.export(response, params.getFileName(), params.getTitle(), dataList, EquipmentTenderResultVO.class);
        }
    }

    /**
     * 导入Excel
     *
     * @param response
     * @param params
     * @return
     */
    @RequestMapping(value = "editImport")
    @ResponseBody
    public JsonBackData editImportExcel(@RequestParam(value = "file") MultipartFile file) {
        JsonBackData back = new JsonBackData();
        try {
            /*导出的时候的起始列跟表格编号 都是以0开始，3表示从第4行开始解析*/
            ImportExcel importExcel = new ImportExcel(file, 3, 0);

            List<EquipmentTenderResultListSubVO> exportList = equipmentTenderResultServiceExtend.importExcel(importExcel);
            back.setBackData(exportList);
            back.setSuccess(true);
            back.setBackMsg("导入成功");
        } catch (Exception e) {
//            ExceptionUtils.marsh(e);
            back.setSuccess(false);
            back.setBackMsg("导入失败:" + e.getMessage());
        }
        return back;
    }



}
