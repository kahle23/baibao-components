package baibao.plugin.service.basic.api.task.service;

import baibao.db.jdbc.mybatisplus.base.BaseService;
import baibao.plugin.service.basic.api.task.pojo.entity.AsyncProcTask;
import baibao.plugin.service.basic.api.task.pojo.param.AsyncProcTaskAddParam;
import baibao.plugin.service.basic.api.task.pojo.param.AsyncProcTaskEditParam;
import baibao.plugin.service.basic.api.task.pojo.query.AsyncProcTaskQuery;
import baibao.plugin.service.basic.api.task.pojo.result.AsyncProcTaskResult;

/**
 * 异步处理的任务表的服务类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public interface AsyncProcTaskService extends BaseService<AsyncProcTask
        , AsyncProcTaskAddParam, AsyncProcTaskEditParam, AsyncProcTaskQuery, AsyncProcTaskResult> {

}
