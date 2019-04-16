package com.yyjz.icop.equipmentpurchase.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyjz.icop.equipmentpurchase.application.service.IEquipmentTenderApplicationQueryService;
import com.yyjz.icop.equipmentpurchase.application.service.IEquipmentTenderApplicationService;
import com.yyjz.icop.equipmentpurchase.application.vo.EquipmentTenderApplicationVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;

/**
 * <p>前台交互rest服务</p>
 * <p>@author ICOP  2019-04-15</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在EquipmentTenderApplicationControllerExtend类中完成。 </p>
 */
@Controller
@RequestMapping(value = "equipmentTenderApplication")
public abstract class EquipmentTenderApplicationController {
	@Autowired
	protected IEquipmentTenderApplicationService equipmentTenderApplicationService;
	@Autowired
	protected IEquipmentTenderApplicationQueryService equipmentTenderApplicationQueryService;

	/**
	 * 新增保存
	 * 
	 * @param equipmentTenderApplicationVO
	 * @return
	 */
	@RequestMapping(value = "insert")
	@ResponseBody
	public JsonBackData insert(@RequestBody EquipmentTenderApplicationVO equipmentTenderApplicationVO) {
		JsonBackData back = new JsonBackData();
		try {
			EquipmentTenderApplicationVO backVO = equipmentTenderApplicationService.insert(equipmentTenderApplicationVO);

			back.setBackData(backVO);
			back.setBackMsg("新增成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("新增失败:"+e.getMessage());
		}
		return back;

	}

	/**
	 * 修改保存
	 * 
	 * @param equipmentTenderApplicationVO
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public JsonBackData update(@RequestBody EquipmentTenderApplicationVO equipmentTenderApplicationVO) {
		JsonBackData back = new JsonBackData();
		try {
			EquipmentTenderApplicationVO vo = equipmentTenderApplicationService.update(equipmentTenderApplicationVO);
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
	 * @param equipmentTenderApplicationVOs
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonBackData delete(@RequestBody EquipmentTenderApplicationVO[] equipmentTenderApplicationVOs) {
		JsonBackData back = new JsonBackData();
		try {
			equipmentTenderApplicationService.delete(equipmentTenderApplicationVOs);
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
			EquipmentTenderApplicationVO vo = equipmentTenderApplicationQueryService.findById(id);
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
			Page<EquipmentTenderApplicationVO> page = equipmentTenderApplicationQueryService.showList(querySchema);
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
