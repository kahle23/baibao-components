package baibao.plugin.service.basic.provider.task.rpc.rest;

import baibao.common.dto.EnableDTO;
import baibao.common.dto.LongIdsDTO;
import baibao.common.enums.QueryMode;
import cn.hutool.core.collection.CollUtil;
import kunlun.common.Page;
import kunlun.common.Result;
import kunlun.core.annotation.OperationLog;
import kunlun.util.PageUtil;
import kunlun.io.fileprocessor.ProcResult;
import kunlun.core.annotation.Permission;
import kunlun.data.Dict;
import kunlun.data.bean.BeanUtil;
import kunlun.data.validation.support.javax.group.Create;
import kunlun.data.validation.support.javax.group.Query;
import kunlun.data.validation.support.javax.group.Update;
import kunlun.exception.util.VerifyUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import baibao.plugin.service.basic.api.task.pojo.entity.AsyncProcTask;
import baibao.plugin.service.basic.api.task.pojo.query.AsyncProcTaskQuery;
import baibao.plugin.service.basic.api.task.pojo.result.AsyncProcTaskResult;
import baibao.plugin.service.basic.api.task.pojo.result.AsyncProcTaskSmpResult;
import baibao.plugin.service.basic.api.task.service.AsyncProcTaskService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * 异步处理的任务表的前端控制器.
 *
 * @folder 基础模块/异步任务
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@RestController
@RequestMapping("/base/async-proc-task")
public class AsyncProcTaskController {

    @Resource
    private AsyncProcTaskService asyncProcTaskService;

    /**
     * 异步任务-详情
     *
     * @param recordId 异步处理的任务表的ID
     * @return 查询到的异步处理的任务表详情
     */
    @OperationLog(name = "异步任务-详情")
    @GetMapping("/{recordId}")
    public Result<AsyncProcTaskResult> detail(@PathVariable("recordId") Long recordId) {

        return Result.success(asyncProcTaskService.detailById(recordId));
    }

    /**
     * 异步任务-分页列表
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_async_proc_task:data")
    @OperationLog(name = "异步任务-分页列表")
    @PostMapping("/query-page")
    public Result<Page<AsyncProcTaskSmpResult>> queryPage(@RequestBody @Validated AsyncProcTaskQuery query) {
        Page<AsyncProcTaskResult> page = asyncProcTaskService.queryPage(query);
        return Result.success(PageUtil.handleResult(page, AsyncProcTaskSmpResult.class));
    }

    /**
     * 异步任务-滚动分页
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_async_proc_task:data")
    @OperationLog(name = "异步任务-滚动分页")
    @PostMapping("/scroll-page")
    public Result<Page<AsyncProcTaskSmpResult>> scrollPage(@RequestBody @Validated AsyncProcTaskQuery query) {
        Page<AsyncProcTaskResult> page = asyncProcTaskService.queryScrollPage(query, AsyncProcTask::getId);
        return Result.success(PageUtil.handleResult(page, AsyncProcTaskSmpResult.class));
    }

}
