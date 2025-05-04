


CREATE TABLE `base_async_proc_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `business_type` int(5) NOT NULL DEFAULT '0' COMMENT '业务类型：0 缺省',
  `business_id` bigint(20) DEFAULT NULL COMMENT '业务ID',
  `task_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '任务类型：0 缺省，1 导出，2 导入',
  `task_parameters` text COMMENT '任务参数（JSON对象字符串）',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `original_files` text COMMENT '原始文件（JSON对象数组）',
  `original_filename` varchar(200) DEFAULT '' COMMENT '原文件名称',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0 缺省，1 待导入|导出，2 前置处理，3 导入|导出中，4 超时，5 失败，6 成功',
  `executor_name` varchar(150) NOT NULL DEFAULT '' COMMENT '执行者名称',
  `exec_failure_count` int(5) NOT NULL DEFAULT '0' COMMENT '执行失败的次数',
  `success_count` int(11) DEFAULT NULL COMMENT '成功条数',
  `failure_count` int(11) DEFAULT NULL COMMENT '失败条数',
  `total_count` int(11) DEFAULT NULL COMMENT '总条数',
  `result_file` varchar(500) NOT NULL DEFAULT '' COMMENT '结果文件信息',
  `error_message` varchar(500) DEFAULT '' COMMENT '错误信息（失败信息）',
  `platform` varchar(50) NOT NULL DEFAULT '' COMMENT '平台信息',
  `tenant_id` varchar(50) NOT NULL DEFAULT '' COMMENT '租户ID',
  `owner_id` bigint(20) NOT NULL COMMENT '数据的所属人ID',
  `own_org_id` bigint(20) NOT NULL COMMENT '数据的所属机构ID',
  `create_user` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_user` bigint(20) NOT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0 未删除，1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_business_id` (`business_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='异步处理的任务表';






