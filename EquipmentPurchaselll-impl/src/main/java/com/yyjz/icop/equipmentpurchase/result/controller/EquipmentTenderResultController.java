package com.yyjz.icop.equipmentpurchase.result.controller;

import com.yyjz.icop.pubapp.platform.context.AppContext;
import com.yyjz.icop.support.api.service.IRegConfigAPIService;
import com.yyjz.icop.support.vo.RegConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultQueryService;
import com.yyjz.icop.equipmentpurchase.result.service.IEquipmentTenderResultService;
import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;


/**
 * <p>前台交互rest服务</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderResultControllerExtend类中完成。 </p>
 */
@Controller
@RequestMapping(value = "equipmentTenderResult")
public abstract class EquipmentTenderResultController {
	@Autowired
	protected IEquipmentTenderResultService equipmentTenderResultService;
	@Autowired
	protected IEquipmentTenderResultQueryService equipmentTenderResultQueryService;
	@Autowired
	protected IRegConfigAPIService iRegConfigAPIService; //注入参数接口

	/**
	 * 新增保存时
	 * 
	 * @param equipmentTenderResultVO
	 * @return
	 */
	@RequestMapping(value = "insert")
	@ResponseBody
	public JsonBackData insert(@RequestBody EquipmentTenderResultVO equipmentTenderResultVO) {
		JsonBackData back = new JsonBackData();

		try {
			RegConfigVO findByCode=iRegConfigAPIService.findByCode(AppContext.getCurCompanyId(),"SeveralCompanies" );//抛异常
			equipmentTenderResultVO.setParameter(findByCode.getRegValue()); //给参数赋值
			

			EquipmentTenderResultVO backVO = equipmentTenderResultService.insert(equipmentTenderResultVO);
			back.setBackData(backVO);
			back.setBackMsg("新增成功");
		} catch (Exception e) {
			back.setSuccess(false);
			back.setBackMsg("新增失败:"+e.getMessage());
		}
		return back;

	}

	/**
	 * 修改保存
	 * 
	 * @param equipmentTenderResultVO
	 * @return
	 */
/*	@RequestMapping(value = "update")
	@ResponseBody
	public JsonBackData update(@RequestBody EquipmentTenderResultVO equipmentTenderResultVO) {
		JsonBackData back = new JsonBackData();
		try {
			EquipmentTenderResultVO vo = equipmentTenderResultService.update(equipmentTenderResultVO);
			back.setBackData(vo);
			back.setBackMsg("更新成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("更新失败:"+e.getMessage());
		}
		return back;
	}*/

	@RequestMapping(value = "update")
	@ResponseBody
	public JsonBackData update(@RequestBody EquipmentTenderResultVO equipmentTenderResultVO) {
		JsonBackData back = new JsonBackData();
		try {

			EquipmentTenderResultVO vo = equipmentTenderResultService.update(equipmentTenderResultVO);
			back.setBackData(vo);
			back.setBackMsg("更新成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("更新失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 删除
	 * 
	 * @param equipmentTenderResultVOs
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonBackData delete(@RequestBody EquipmentTenderResultVO[] equipmentTenderResultVOs) {
		JsonBackData back = new JsonBackData();
		try {
			equipmentTenderResultService.delete(equipmentTenderResultVOs);
			back.setSuccess(true);
			back.setBackMsg("删除成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("删除失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 查询详细信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "queryDetail")
	@ResponseBody
	public JsonBackData queryDetail(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			EquipmentTenderResultVO vo = equipmentTenderResultQueryService.findById(id);
			back.setBackData(vo);
			back.setSuccess(true);
			back.setBackMsg("查询详细信息成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("查询详细信息失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 查询
	 * 
	 * @param QuerySchema
	 * @return
	 */
	@RequestMapping(value = "queryList")
	@ResponseBody
	public JsonBackData queryList(@RequestBody(required = false) QuerySchema querySchema) {
		JsonBackData back = new JsonBackData();
		try {
			Page<EquipmentTenderResultVO> page = equipmentTenderResultQueryService.showList(querySchema);
			back.setBackData(page);
			back.setSuccess(true);
			back.setBackMsg("查询列表信息成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("查询列表信息失败:"+e.getMessage());
		}
		return back;
	}

}
