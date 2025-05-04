package baibao.plugin.service.basic.provider.task.service.impl;

import baibao.common.enums.QueryMode;
import baibao.db.jdbc.mybatisplus.base.BaseServiceImpl;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kunlun.action.ActionUtil;
import kunlun.action.event.support.difference.FieldDifferenceBuilder;
import kunlun.common.Page;
import kunlun.common.constant.Nil;
import kunlun.data.Event;
import kunlun.data.bean.BeanUtil;
import kunlun.data.fill.classic.DataCfg;
import kunlun.data.fill.classic.FillCfg;
import kunlun.data.fill.classic.support.EnumSupplier;
import kunlun.data.fill.classic.support.MpServIdsSupplier;
import kunlun.data.validation.support.javax.ValidationUtil;
import kunlun.data.validation.support.javax.group.Create;
import kunlun.data.validation.support.javax.group.Query;
import kunlun.data.validation.support.javax.group.Update;
import kunlun.exception.util.VerifyUtil;
import kunlun.io.fileprocessor.ProcConfig;
import kunlun.io.fileprocessor.ProcResult;
import kunlun.io.fileprocessor.support.EasyExcelByteArrayBasedExportProcessor;
import kunlun.io.fileprocessor.support.EasyExcelOneTimeImportProcessor;
import kunlun.util.PageUtil;
import kunlun.util.function.difference.FieldCompareResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.provider.task.mapper.AsyncProcTaskMapper;
import baibao.plugin.service.basic.api.task.pojo.entity.AsyncProcTask;
import baibao.plugin.service.basic.api.task.pojo.param.AsyncProcTaskAddParam;
import baibao.plugin.service.basic.api.task.pojo.param.AsyncProcTaskEditParam;
import baibao.plugin.service.basic.api.task.pojo.query.AsyncProcTaskQuery;
import baibao.plugin.service.basic.api.task.pojo.result.AsyncProcTaskResult;
import baibao.plugin.service.basic.api.task.service.AsyncProcTaskService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.hutool.core.collection.CollUtil.isNotEmpty;
import static cn.hutool.core.convert.Convert.toBool;
import static cn.hutool.core.convert.Convert.toStr;
import static cn.hutool.core.text.CharSequenceUtil.EMPTY;
import static cn.hutool.core.util.StrUtil.isNotBlank;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static kunlun.common.Errors.*;
import static kunlun.common.constant.Numbers.ONE;
import static kunlun.common.constant.Numbers.ZERO;
import static kunlun.data.validation.support.javax.ValidationUtil.validateToThrow;
import static kunlun.exception.util.VerifyUtil.*;
import static kunlun.io.fileprocessor.ProcResult.Statistic;
import static kunlun.io.fileprocessor.support.EasyExcelByteArrayBasedExportProcessor.ExcelExportContext;
import static kunlun.io.fileprocessor.support.EasyExcelOneTimeImportProcessor.ExcelImportContext;

/**
 * 异步处理的任务表的服务实现类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@Service
public class AsyncProcTaskServiceImpl extends BaseServiceImpl<AsyncProcTaskMapper, AsyncProcTask
        , AsyncProcTaskAddParam, AsyncProcTaskEditParam, AsyncProcTaskQuery, AsyncProcTaskResult> implements AsyncProcTaskService {

    @Override
    protected AsyncProcTask fromAddParam(AsyncProcTaskAddParam param) {
        // AsyncProcTask entity = BeanUtil.beanToBean(param, AsyncProcTask.class);
        // return entity;
        return BeanUtil.beanToBean(param, AsyncProcTask.class);
    }

    @Override
    protected AsyncProcTask fromEditParam(AsyncProcTaskResult old, AsyncProcTaskEditParam param) {
        // AsyncProcTask entity = BeanUtil.beanToBean(param, AsyncProcTask.class);
        // return entity;
        return BeanUtil.beanToBean(param, AsyncProcTask.class);
    }

    @Override
    public Long addRecord(AsyncProcTaskAddParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(AsyncProcTask::getCode
                    , param.getCode(), AsyncProcTask::getId, null), "该编码已存在！");
        }*/
        return super.addRecord(param);
    }

    @Override
    public void editRecord(AsyncProcTaskEditParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(AsyncProcTask::getCode
                    , param.getCode(), AsyncProcTask::getId, param.getId()), "该编码已存在！");
        }*/
        super.editRecord(param);
    }

    /*@Override
    public Page<AsyncProcTaskResult> queryPage(AsyncProcTaskQuery query) {

        return super.queryPage(query);
    }*/

    @Override
    protected MPJLambdaWrapper<AsyncProcTask> buildQueryWrapper(AsyncProcTaskQuery query) {
        return JoinWrappers.lambda(AsyncProcTask.class)
                .in(isNotEmpty(query.getIdList()), AsyncProcTask::getId, query.getIdList())
                .eq(nonNull(query.getBusinessType()), AsyncProcTask::getBusinessType, query.getBusinessType())
                .in(isNotEmpty(query.getBusinessIdList()), AsyncProcTask::getBusinessId, query.getBusinessIdList())
                .eq(nonNull(query.getTaskType()), AsyncProcTask::getTaskType, query.getTaskType())
                .eq(isNotBlank(query.getTaskParameters()), AsyncProcTask::getTaskParameters, query.getTaskParameters())
                .eq(nonNull(query.getBeginTime()), AsyncProcTask::getBeginTime, query.getBeginTime())
                .eq(nonNull(query.getEndTime()), AsyncProcTask::getEndTime, query.getEndTime())
                .eq(isNotBlank(query.getOriginalFiles()), AsyncProcTask::getOriginalFiles, query.getOriginalFiles())
                .like(isNotBlank(query.getOriginalFilenameLike()), AsyncProcTask::getOriginalFilename, query.getOriginalFilenameLike())
                .in(isNotEmpty(query.getStatusList()), AsyncProcTask::getStatus, query.getStatusList())
                .like(isNotBlank(query.getExecutorNameLike()), AsyncProcTask::getExecutorName, query.getExecutorNameLike())
                .eq(isNotBlank(query.getPlatform()), AsyncProcTask::getPlatform, query.getPlatform())
                .in(isNotEmpty(query.getTenantIdList()), AsyncProcTask::getTenantId, query.getTenantIdList())
                .in(isNotEmpty(query.getOwnerIdList()), AsyncProcTask::getOwnerId, query.getOwnerIdList())
                .in(isNotEmpty(query.getOwnOrgIdList()), AsyncProcTask::getOwnOrgId, query.getOwnOrgIdList())
                // 排序需要增加判断条件 isNull(query.getScrollByAsc())，是为了滚动分页查询而服务的
                .orderByDesc(ObjUtil.isNull(query.getScrollByAsc()), AsyncProcTask::getId)
        ;
    }


    /**
     * 统一的异步处理的任务表数据的处理逻辑
     */
    @Override
    protected void processData(AsyncProcTaskQuery qry, List<AsyncProcTaskResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 判断查询模式
        List<QueryMode> allow = Arrays.asList(QueryMode.FULL, QueryMode.ONLY_PROCESS);
        if (nonNull(qry) && nonNull(qry.getQueryMode()) && !allow.contains(qry.getQueryMode())) { return; }
        // 数据处理
        data.forEach(item -> {
        });
        // 数据提取
        /*List<Long> idList = data.stream().filter(Objects::nonNull)
                .map(AsyncProcTaskResult::getId)
                .distinct().collect(Collectors.toList());*/
    }

    /**
     * 统一的异步处理的任务表数据的填充逻辑
     */
    @Override
    protected void fillingData(AsyncProcTaskQuery qry, List<AsyncProcTaskResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 判断查询模式
        List<QueryMode> allow = Arrays.asList(QueryMode.FULL, QueryMode.ONLY_FILL);
        if (nonNull(qry) && nonNull(qry.getQueryMode()) && !allow.contains(qry.getQueryMode())) { return; }
        // 数据填充
        /*FillCfg.of(data).addDataConfig(DataCfg.of(MpServIdsSupplier.of(UserService.class, User::getId))
                .addFieldConfig("userId", "userName", "name")
        ).addDataConfig(DataCfg.of(MpServIdsSupplier.of(CompanyService.class, Company::getId))
                .addFieldConfig("companyId", "companyName", "name")
        ).addDataConfig(DataCfg.of(EnumSupplier.of(AsyncProcTaskStatus.class))
                .addFieldConfig("status", "statusTxt", "description")
        ).fill();*/
    }


    /**
     * 记录数据的变动日志.
     * @param bizId 业务数据的主键ID
     * @param newData 改动后的业务数据对象
     * @param oldData 改动前的业务数据对象
     * @param targetClz 目标类型
     * @param arguments 留有的额外的口子，用于灵活的传递其他参数
     *                  在大部分场景下，arguments[0] = String methodLabel
     *                                arguments[1] = boolean ignoreNullNewValue
     */
    @Override
    protected void changeLog(Object bizId, Object oldData, Object newData, Class<?> targetClz, Object... arguments) {
        /*boolean ignoreNullNewValue = toBool(ArrayUtil.get(arguments, ONE), Boolean.FALSE);
        String methodLabel = toStr(ArrayUtil.get(arguments, ZERO), EMPTY);
        ActionUtil.execute(Event.ofChangeLog()
                //.setBusinessType(null)
                .setBusinessId(bizId)
                .appendMessage(new FieldDifferenceBuilder(oldData, newData, targetClz, ignoreNullNewValue) {
                    @Override
                    protected void preProcess(List<FieldCompareResult> results) {
                        for (FieldCompareResult result : results) {
                            if (result == null) { continue; }
//                            if ("type".equals(result.getName())) {
//                                BizType oldVal = BizType.parse(result.getOldValue());
//                                BizType newVal = BizType.parse(result.getNewValue());
//                                result.setOldValue(nonNull(oldVal) ? oldVal.getDescription() : null);
//                                result.setNewValue(nonNull(newVal) ? newVal.getDescription() : null);
//                                FillCfg.of(result).addDataConfig(DataCfg.of(EnumSupplier.of(BizType.class))
//                                        .addFieldConfig("oldValue", "oldValue", "description")
//                                        .addFieldConfig("newValue", "newValue", "description")
//                                ).fill();
//                            }
                        }
                    }
                })
        );*/
    }

}
