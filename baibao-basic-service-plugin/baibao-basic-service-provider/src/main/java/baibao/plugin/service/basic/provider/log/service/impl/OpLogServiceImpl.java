package baibao.plugin.service.basic.provider.log.service.impl;

import baibao.common.enums.QueryMode;
import baibao.common.enums.Success;
import baibao.db.jdbc.mybatisplus.base.BaseServiceImpl;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import kunlun.data.Dict;
import kunlun.data.bean.BeanUtil;
import kunlun.data.fill.classic.DataCfg;
import kunlun.data.fill.classic.FillCfg;
import kunlun.data.fill.classic.support.EnumSupplier;
import kunlun.io.fileprocessor.ProcConfig;
import kunlun.io.fileprocessor.ProcResult;
import kunlun.io.fileprocessor.support.EasyExcelByteArrayBasedExportProcessor;
import kunlun.io.fileprocessor.support.EasyExcelOneTimeImportProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.provider.log.mapper.OpLogMapper;
import baibao.plugin.service.basic.api.log.pojo.entity.OpLog;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.OpLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.OpLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.OpLogResult;
import baibao.plugin.service.basic.api.log.service.OpLogService;

import java.util.*;

import static cn.hutool.core.collection.CollUtil.isNotEmpty;
import static cn.hutool.core.convert.Convert.toBool;
import static cn.hutool.core.convert.Convert.toStr;
import static cn.hutool.core.util.StrUtil.isNotBlank;
import static java.util.Objects.nonNull;
import static kunlun.io.fileprocessor.ProcResult.Statistic;

/**
 * 操作日志表的服务实现类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@Service
public class OpLogServiceImpl extends BaseServiceImpl<OpLogMapper, OpLog
        , OpLogAddParam, OpLogEditParam, OpLogQuery, OpLogResult> implements OpLogService {

    @Override
    protected OpLog fromAddParam(OpLogAddParam param) {
        // 默认值处理
        if (param.getData() == null) {
            param.setData(Dict.of());
        }
        // 转换成实体
        OpLog entity = BeanUtil.beanToBean(param, OpLog.class);
        entity.setDataJson(JSONUtil.toJsonStr(param.getData()));
        return entity;
    }

    @Override
    protected OpLog fromEditParam(OpLogResult old, OpLogEditParam param) {
        // OpLog entity = BeanUtil.beanToBean(param, OpLog.class);
        // return entity;
        return BeanUtil.beanToBean(param, OpLog.class);
    }

    @Override
    public Long addRecord(OpLogAddParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(OpLog::getCode
                    , param.getCode(), OpLog::getId, null), "该编码已存在！");
        }*/
        return super.addRecord(param);
    }

    @Override
    public void editRecord(OpLogEditParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(OpLog::getCode
                    , param.getCode(), OpLog::getId, param.getId()), "该编码已存在！");
        }*/
        super.editRecord(param);
    }

    /*@Override
    public Page<OpLogResult> queryPage(OpLogQuery query) {

        return super.queryPage(query);
    }*/

    @Override
    protected MPJLambdaWrapper<OpLog> buildQueryWrapper(OpLogQuery query) {
        return JoinWrappers.lambda(OpLog.class)
                .in(isNotEmpty(query.getIdList()), OpLog::getId, query.getIdList())
                .like(isNotBlank(query.getNameLike()), OpLog::getName, query.getNameLike())
                .eq(nonNull(query.getTime()), OpLog::getTime, query.getTime())
                .eq(isNotBlank(query.getMessage()), OpLog::getMessage, query.getMessage())
                .in(isNotEmpty(query.getUserIdList()), OpLog::getUserId, query.getUserIdList())
                .eq(isNotBlank(query.getUserType()), OpLog::getUserType, query.getUserType())
                .like(isNotBlank(query.getUserDisplayNameLike()), OpLog::getUserDisplayName, query.getUserDisplayNameLike())
                .in(isNotEmpty(query.getOrgIdList()), OpLog::getOrgId, query.getOrgIdList())
                .like(isNotBlank(query.getOrgNameLike()), OpLog::getOrgName, query.getOrgNameLike())
                .eq(isNotBlank(query.getPlatform()), OpLog::getPlatform, query.getPlatform())
                .in(isNotEmpty(query.getTenantIdList()), OpLog::getTenantId, query.getTenantIdList())
                .in(isNotEmpty(query.getTraceIdList()), OpLog::getTraceId, query.getTraceIdList())
                .eq(isNotBlank(query.getRequestApiUri()), OpLog::getRequestApiUri, query.getRequestApiUri())
                .eq(isNotBlank(query.getRequestMethod()), OpLog::getRequestMethod, query.getRequestMethod())
                .eq(nonNull(query.getSuccess()), OpLog::getSuccess, query.getSuccess())
                .like(isNotBlank(query.getErrorLike()), OpLog::getError, query.getErrorLike())
                .eq(nonNull(query.getTimeSpent()), OpLog::getTimeSpent, query.getTimeSpent())
                .in(isNotEmpty(query.getClientAppIdList()), OpLog::getClientAppId, query.getClientAppIdList())
                .in(isNotEmpty(query.getClientDeviceIdList()), OpLog::getClientDeviceId, query.getClientDeviceIdList())
                .like(isNotBlank(query.getClientUserAgentLike()), OpLog::getClientUserAgent, query.getClientUserAgentLike())
                .eq(isNotBlank(query.getClientNetAddress()), OpLog::getClientNetAddress, query.getClientNetAddress())
                .eq(isNotBlank(query.getClientGeoAddress()), OpLog::getClientGeoAddress, query.getClientGeoAddress())
                .like(isNotBlank(query.getServerNameLike()), OpLog::getServerName, query.getServerNameLike())
                .like(isNotBlank(query.getServerAppNameLike()), OpLog::getServerAppName, query.getServerAppNameLike())
                // 排序需要增加判断条件 isNull(query.getScrollByAsc())，是为了滚动分页查询而服务的
                .orderByDesc(ObjUtil.isNull(query.getScrollByAsc()), OpLog::getId)
        ;
    }


    /**
     * 统一的操作日志表数据的处理逻辑
     */
    @Override
    protected void processData(OpLogQuery qry, List<OpLogResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 数据处理
        data.forEach(item -> {
        });
        // 数据提取
        /*List<Long> idList = data.stream().filter(Objects::nonNull)
                .map(OpLogResult::getId)
                .distinct().collect(Collectors.toList());*/
    }

    /**
     * 统一的操作日志表数据的填充逻辑
     */
    @Override
    protected void fillingData(OpLogQuery qry, List<OpLogResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 数据填充
        FillCfg.of(data)/*.addDataConfig(DataCfg.of(MpServIdsSupplier.of(UserService.class, User::getId))
                .addFieldConfig("userId", "userName", "name")
        ).addDataConfig(DataCfg.of(MpServIdsSupplier.of(CompanyService.class, Company::getId))
                .addFieldConfig("companyId", "companyName", "name")
        )*/.addDataConfig(DataCfg.of(EnumSupplier.of(Success.class))
                .addFieldConfig("success", "successName", "description")
        ).fill();
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
