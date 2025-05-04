


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



CREATE TABLE `base_op_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '事件名称',
  `time` datetime NOT NULL COMMENT '时间',
  `message` text COMMENT '消息',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户ID',
  `user_type` varchar(50) NOT NULL DEFAULT '' COMMENT '用户类型',
  `user_display_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户的展示名',
  `org_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户所在的机构ID',
  `org_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户所在的机构名称',
  `platform` varchar(50) NOT NULL DEFAULT '' COMMENT '平台信息',
  `tenant_id` varchar(50) NOT NULL DEFAULT '' COMMENT '租户ID',
  `trace_id` varchar(50) NOT NULL DEFAULT '' COMMENT '跟踪ID',
  `request_api_uri` varchar(500) NOT NULL DEFAULT '' COMMENT '请求的URI',
  `request_method` varchar(30) NOT NULL DEFAULT '' COMMENT '请求的方法',
  `input` text COMMENT '请求参数（JSON）',
  `output` text COMMENT '返回结果（JSON）',
  `success` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否执行成功：0 未成功，1 成功',
  `error` text COMMENT '错误消息',
  `time_spent` int(8) DEFAULT NULL COMMENT '耗时（单位：毫秒）',
  `client_app_id` varchar(40) NOT NULL DEFAULT '' COMMENT '客户端的应用的ID（标识是哪个应用）',
  `client_device_id` varchar(40) NOT NULL DEFAULT '' COMMENT '客户端的设备的ID',
  `client_user_agent` varchar(500) NOT NULL DEFAULT '' COMMENT '客户端的用户代理',
  `client_net_address` varchar(60) NOT NULL DEFAULT '' COMMENT '客户端的网络地址',
  `client_geo_address` varchar(60) NOT NULL DEFAULT '' COMMENT '客户端的地理地址',
  `client_geo_location` varchar(200) NOT NULL DEFAULT '' COMMENT '客户端的地理位置（经纬度JSON）',
  `server_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的名称',
  `server_app_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的应用名称',
  `data_json` text COMMENT '其他数据的JSON',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0 未删除，1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE,
  KEY `idx_time` (`time`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_org_id` (`org_id`) USING BTREE,
  KEY `idx_platform` (`platform`) USING BTREE,
  KEY `idx_tenant_id` (`tenant_id`) USING BTREE,
  KEY `idx_request_api_uri` (`request_api_uri`) USING BTREE,
  KEY `idx_success` (`success`) USING BTREE,
  KEY `idx_client_device_id` (`client_device_id`) USING BTREE,
  KEY `idx_client_net_address` (`client_net_address`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='操作日志表';


CREATE TABLE `base_change_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `time` datetime NOT NULL COMMENT '时间',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户ID',
  `user_type` varchar(50) NOT NULL DEFAULT '' COMMENT '用户类型',
  `user_display_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户的展示名',
  `org_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户所在的机构ID',
  `org_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户所在的机构名称',
  `platform` varchar(50) NOT NULL DEFAULT '' COMMENT '平台信息',
  `tenant_id` varchar(50) NOT NULL DEFAULT '' COMMENT '租户ID',
  `business_id` varchar(50) NOT NULL DEFAULT '' COMMENT '业务ID',
  `business_type` smallint(4) NOT NULL DEFAULT '0' COMMENT '业务类型：0 缺省',
  `message` text COMMENT '消息',
  `server_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的名称',
  `server_app_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的应用名称',
  `data_json` text COMMENT '其他数据的JSON',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0 未删除，1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_time` (`time`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_org_id` (`org_id`) USING BTREE,
  KEY `idx_platform` (`platform`) USING BTREE,
  KEY `idx_tenant_id` (`tenant_id`) USING BTREE,
  KEY `idx_business_id` (`business_id`) USING BTREE,
  KEY `idx_business_type` (`business_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='数据变动日志表';


CREATE TABLE `base_run_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `server_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的名称',
  `server_app_name` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的应用名称',
  `time` datetime NOT NULL COMMENT '时间',
  `module` varchar(300) NOT NULL DEFAULT '' COMMENT '模块名',
  `message` text COMMENT '消息',
  `success` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否执行成功：0 未成功，1 成功',
  `error` text COMMENT '错误消息',
  `data_json` text COMMENT '其他数据的JSON',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0 未删除，1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_server_name` (`server_name`) USING BTREE,
  KEY `idx_server_app_name` (`server_app_name`) USING BTREE,
  KEY `idx_time` (`time`) USING BTREE,
  KEY `idx_success` (`success`) USING BTREE,
  KEY `idx_module` (`module`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='运行日志表';




