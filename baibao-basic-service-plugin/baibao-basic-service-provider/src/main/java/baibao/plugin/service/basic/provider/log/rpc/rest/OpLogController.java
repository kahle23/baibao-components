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
import baibao.plugin.service.basic.api.log.pojo.entity.OpLog;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.OpLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.OpLogResult;
import baibao.plugin.service.basic.api.log.pojo.result.OpLogSmpResult;
import baibao.plugin.service.basic.api.log.service.OpLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志表的前端控制器.
 *
 * @folder 基础模块/操作日志
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@RestController
@RequestMapping("/base/op-log")
public class OpLogController {

    @Resource
    private OpLogService opLogService;

    /**
     * 操作日志-增加
     *
     * @param param 待增加的数据
     * @return 增加的记录的ID
     */
    @OperationLog(name = "操作日志-增加")
    @PostMapping("/add")
    public Result<Number> add(@RequestBody @Validated OpLogAddParam param) {

        return Result.success(opLogService.addRecord(param));
    }

    /**
     * 操作日志-编辑
     *
     * @param param 待编辑的数据
     * @return 操作结果
     */
    @OperationLog(name = "操作日志-编辑")
    @PostMapping("/edit")
    public Result<Void> edit(@RequestBody @Validated OpLogEditParam param) {
        opLogService.editRecord(param);
        return Result.success();
    }

    /**
     * 操作日志-删除
     *
     * @param param 待删除的数据
     * @return 操作结果
     */
    @OperationLog(name = "操作日志-删除")
    @PostMapping("/delete")
    public Result<Void> delete(@RequestBody @Validated LongIdsDTO param) {
        opLogService.deleteByLongIds(param.getIds());
        return Result.success();
    }

    /**
     * 操作日志-详情
     *
     * @param recordId 操作日志表的ID
     * @return 查询到的操作日志表详情
     */
    @OperationLog(name = "操作日志-详情")
    @GetMapping("/{recordId}")
    public Result<OpLogResult> detail(@PathVariable("recordId") Long recordId) {

        return Result.success(opLogService.detailById(recordId));
    }

    /**
     * 操作日志-分页列表
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_op_log:data")
    @OperationLog(name = "操作日志-分页列表")
    @PostMapping("/query-page")
    public Result<Page<OpLogSmpResult>> queryPage(@RequestBody @Validated OpLogQuery query) {
        Page<OpLogResult> page = opLogService.queryPage(query);
        return Result.success(PageUtil.handleResult(page, OpLogSmpResult.class));
    }

    /**
     * 操作日志-滚动分页
     *
     * @param query 查询条件
     * @return 查询结果
     */
//    @Permission("base_op_log:data")
    @OperationLog(name = "操作日志-滚动分页")
    @PostMapping("/scroll-page")
    public Result<Page<OpLogSmpResult>> scrollPage(@RequestBody @Validated OpLogQuery query) {
        Page<OpLogResult> page = opLogService.queryScrollPage(query, OpLog::getId);
        return Result.success(PageUtil.handleResult(page, OpLogSmpResult.class));
    }

}
