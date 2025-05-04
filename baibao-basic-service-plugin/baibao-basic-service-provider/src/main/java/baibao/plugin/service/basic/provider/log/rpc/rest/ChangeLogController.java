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
import baibao.plugin.service.basic.api.log.pojo.entity.ChangeLog;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.ChangeLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.ChangeLogResult;
import baibao.plugin.service.basic.api.log.pojo.result.ChangeLogSmpResult;
import baibao.plugin.service.basic.api.log.service.ChangeLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据变动日志表的前端控制器.
 *
 * @folder 基础模块/数据变动日志
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@RestController
@RequestMapping("/base/change-log")
public class ChangeLogController {

    @Resource
    private ChangeLogService changeLogService;

    /**
     * 数据变动日志-增加
     *
     * @param param 待增加的数据
     * @return 增加的记录的ID
     */
    @OperationLog(name = "数据变动日志-增加")
    @PostMapping("/add")
    public Result<Number> add(@RequestBody @Validated ChangeLogAddParam param) {

        return Result.success(changeLogService.addRecord(param));
    }

    /**
     * 数据变动日志-编辑
     *
     * @param param 待编辑的数据
     * @return 操作结果
     */
    @OperationLog(name = "数据变动日志-编辑")
    @PostMapping("/edit")
    public Result<Void> edit(@RequestBody @Validated ChangeLogEditParam param) {
        changeLogService.editRecord(param);
        return Result.success();
    }

    /**
     * 数据变动日志-删除
     *
     * @param param 待删除的数据
     * @return 操作结果
     */
    @OperationLog(name = "数据变动日志-删除")
    @PostMapping("/delete")
    public Result<Void> delete(@RequestBody @Validated LongIdsDTO param) {
        changeLogService.deleteByLongIds(param.getIds());
        return Result.success();
    }

    /**
     * 数据变动日志-详情
     *
     * @param recordId 数据变动日志表的ID
     * @return 查询到的数据变动日志表详情
     */
    @OperationLog(name = "数据变动日志-详情")
    @GetMapping("/{recordId}")
    public Result<ChangeLogResult> detail(@PathVariable("recordId") Long recordId) {

        return Result.success(changeLogService.detailById(recordId));
    }

    /**
     * 数据变动日志-分页列表
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_change_log:data")
    @OperationLog(name = "数据变动日志-分页列表")
    @PostMapping("/query-page")
    public Result<Page<ChangeLogSmpResult>> queryPage(@RequestBody @Validated ChangeLogQuery query) {
        Page<ChangeLogResult> page = changeLogService.queryPage(query);
        return Result.success(PageUtil.handleResult(page, ChangeLogSmpResult.class));
    }

    /**
     * 数据变动日志-滚动分页
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_change_log:data")
    @OperationLog(name = "数据变动日志-滚动分页")
    @PostMapping("/scroll-page")
    public Result<Page<ChangeLogSmpResult>> scrollPage(@RequestBody @Validated ChangeLogQuery query) {
        Page<ChangeLogResult> page = changeLogService.queryScrollPage(query, ChangeLog::getId);
        return Result.success(PageUtil.handleResult(page, ChangeLogSmpResult.class));
    }

}
