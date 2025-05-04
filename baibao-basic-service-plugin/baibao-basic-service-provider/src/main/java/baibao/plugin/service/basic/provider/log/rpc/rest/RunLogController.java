package baibao.plugin.service.basic.provider.log.rpc.rest;

import baibao.common.dto.EnableDTO;
import baibao.common.dto.LongIdsDTO;
import baibao.common.enums.QueryMode;
import kunlun.common.Page;
import kunlun.common.Result;
import kunlun.core.annotation.OperationLog;
import kunlun.util.PageUtil;
import kunlun.io.fileprocessor.ProcResult;
import kunlun.data.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.api.log.pojo.entity.RunLog;
import baibao.plugin.service.basic.api.log.pojo.param.RunLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.RunLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.RunLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.RunLogResult;
import baibao.plugin.service.basic.api.log.pojo.result.RunLogSmpResult;
import baibao.plugin.service.basic.api.log.service.RunLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 运行日志表的前端控制器.
 *
 * @folder 基础模块/运行日志
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@RestController
@RequestMapping("/base/run-log")
public class RunLogController {

    @Resource
    private RunLogService runLogService;

    /**
     * 运行日志-增加
     *
     * @param param 待增加的数据
     * @return 增加的记录的ID
     */
    @OperationLog(name = "运行日志-增加")
    @PostMapping("/add")
    public Result<Number> add(@RequestBody @Validated RunLogAddParam param) {

        return Result.success(runLogService.addRecord(param));
    }

    /**
     * 运行日志-编辑
     *
     * @param param 待编辑的数据
     * @return 操作结果
     */
    @OperationLog(name = "运行日志-编辑")
    @PostMapping("/edit")
    public Result<Void> edit(@RequestBody @Validated RunLogEditParam param) {
        runLogService.editRecord(param);
        return Result.success();
    }

    /**
     * 运行日志-删除
     *
     * @param param 待删除的数据
     * @return 操作结果
     */
    @OperationLog(name = "运行日志-删除")
    @PostMapping("/delete")
    public Result<Void> delete(@RequestBody @Validated LongIdsDTO param) {
        runLogService.deleteByLongIds(param.getIds());
        return Result.success();
    }

    /**
     * 运行日志-详情
     *
     * @param recordId 运行日志表的ID
     * @return 查询到的运行日志表详情
     */
    @OperationLog(name = "运行日志-详情")
    @GetMapping("/{recordId}")
    public Result<RunLogResult> detail(@PathVariable("recordId") Long recordId) {

        return Result.success(runLogService.detailById(recordId));
    }

    /**
     * 运行日志-分页列表
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_run_log:data")
    @OperationLog(name = "运行日志-分页列表")
    @PostMapping("/query-page")
    public Result<Page<RunLogSmpResult>> queryPage(@RequestBody @Validated RunLogQuery query) {
        Page<RunLogResult> page = runLogService.queryPage(query);
        return Result.success(PageUtil.handleResult(page, RunLogSmpResult.class));
    }

    /**
     * 运行日志-滚动分页
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_run_log:data")
    @OperationLog(name = "运行日志-滚动分页")
    @PostMapping("/scroll-page")
    public Result<Page<RunLogSmpResult>> scrollPage(@RequestBody @Validated RunLogQuery query) {
        Page<RunLogResult> page = runLogService.queryScrollPage(query, RunLog::getId);
        return Result.success(PageUtil.handleResult(page, RunLogSmpResult.class));
    }

}
