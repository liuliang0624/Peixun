CREATE TABLE `equipment_tender_result` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`bill_code` VARCHAR(255) DEFAULT NULL COMMENT '单据编号',
	`bill_state` INT(11) DEFAULT NULL COMMENT '单据状态',
	`bill_type` VARCHAR(255) DEFAULT NULL COMMENT '单据类型',
	`company_id` VARCHAR(36) DEFAULT NULL COMMENT '公司id',
	`createtime` DATETIME DEFAULT NULL COMMENT '创建时间',
	`creator` VARCHAR(255) DEFAULT NULL COMMENT '创建人',
	`creatorid` VARCHAR(36) DEFAULT NULL COMMENT '创建人id',
	`dr` INT(1) DEFAULT NULL COMMENT 'dr',
	`list_bool` BIT(10) DEFAULT NULL COMMENT '是否有清单',
	`modifier` VARCHAR(255) DEFAULT NULL COMMENT '修改人',
	`modifierid` VARCHAR(36) DEFAULT NULL COMMENT '修改人id',
	`modifytime` DATETIME DEFAULT NULL COMMENT '修改时间',
	`opening_tender_data` DATETIME DEFAULT NULL COMMENT '开标日期',
	`parameter` VARCHAR(255) DEFAULT NULL COMMENT '参数',
	`remarks` VARCHAR(255) DEFAULT NULL COMMENT '备注',
	`reviewer` VARCHAR(255) DEFAULT NULL COMMENT '审核人',
	`reviewerid` VARCHAR(36) DEFAULT NULL COMMENT '审核人id',
	`reviewtime` DATETIME DEFAULT NULL COMMENT '审核时间',
	`tenantid` VARCHAR(36) DEFAULT NULL COMMENT '租户id',
	`tender_area` VARCHAR(255) DEFAULT NULL COMMENT '集中采购区域',
	`tender_data` DATETIME DEFAULT NULL COMMENT '招标日期',
	`tender_method` VARCHAR(255) DEFAULT NULL COMMENT '招标方式',
	`tender_name` VARCHAR(255) DEFAULT NULL COMMENT '集采招标名称',
	`total_money` DECIMAL(100,0) DEFAULT NULL COMMENT '总金额',
	`ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
