package baibao.plugin.service.basic.provider.log.service.impl;

import baibao.common.enums.QueryMode;
import baibao.db.jdbc.mybatisplus.base.BaseServiceImpl;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import kunlun.data.Dict;
import kunlun.data.bean.BeanUtil;
import kunlun.io.fileprocessor.ProcConfig;
import kunlun.io.fileprocessor.ProcResult;
import kunlun.io.fileprocessor.support.EasyExcelByteArrayBasedExportProcessor;
import kunlun.io.fileprocessor.support.EasyExcelOneTimeImportProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import baibao.plugin.service.basic.provider.log.mapper.ChangeLogMapper;
import baibao.plugin.service.basic.api.log.pojo.entity.ChangeLog;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogAddParam;
import baibao.plugin.service.basic.api.log.pojo.param.ChangeLogEditParam;
import baibao.plugin.service.basic.api.log.pojo.query.ChangeLogQuery;
import baibao.plugin.service.basic.api.log.pojo.result.ChangeLogResult;
import baibao.plugin.service.basic.api.log.service.ChangeLogService;

import java.util.*;

import static cn.hutool.core.collection.CollUtil.isNotEmpty;
import static cn.hutool.core.convert.Convert.toBool;
import static cn.hutool.core.convert.Convert.toStr;
import static cn.hutool.core.util.StrUtil.isNotBlank;
import static java.util.Objects.nonNull;
import static kunlun.common.constant.Numbers.FIVE_HUNDRED;
import static kunlun.common.constant.Numbers.ZERO;
import static kunlun.io.fileprocessor.ProcResult.Statistic;

/**
 * 数据变动日志表的服务实现类.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Slf4j
@Service
public class ChangeLogServiceImpl extends BaseServiceImpl<ChangeLogMapper, ChangeLog
        , ChangeLogAddParam, ChangeLogEditParam, ChangeLogQuery, ChangeLogResult> implements ChangeLogService {

    @Override
    protected ChangeLog fromAddParam(ChangeLogAddParam param) {
        // 默认值处理
        if (param.getData() == null) {
            param.setData(Dict.of());
        }
        // 转换成实体
        ChangeLog entity = BeanUtil.beanToBean(param, ChangeLog.class);
        entity.setDataJson(JSONUtil.toJsonStr(param.getData()));
        return entity;
    }

    @Override
    protected ChangeLog fromEditParam(ChangeLogResult old, ChangeLogEditParam param) {
        // ChangeLog entity = BeanUtil.beanToBean(param, ChangeLog.class);
        // return entity;
        return BeanUtil.beanToBean(param, ChangeLog.class);
    }

    @Override
    public Long addRecord(ChangeLogAddParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(ChangeLog::getCode
                    , param.getCode(), ChangeLog::getId, null), "该编码已存在！");
        }*/
        return super.addRecord(param);
    }

    @Override
    public void editRecord(ChangeLogEditParam param) {
        // 编码校验
        /*if (StrUtil.isNotBlank(param.getCode())) {
            isFalse(existBy(ChangeLog::getCode
                    , param.getCode(), ChangeLog::getId, param.getId()), "该编码已存在！");
        }*/
        super.editRecord(param);
    }

    /*@Override
    public Page<ChangeLogResult> queryPage(ChangeLogQuery query) {

        return super.queryPage(query);
    }*/


    @Override
    protected MPJLambdaWrapper<ChangeLog> buildQueryWrapper(ChangeLogQuery query) {
        return JoinWrappers.lambda(ChangeLog.class)
                .in(isNotEmpty(query.getIdList()), ChangeLog::getId, query.getIdList())
                .eq(nonNull(query.getTime()), ChangeLog::getTime, query.getTime())
                .in(isNotEmpty(query.getUserIdList()), ChangeLog::getUserId, query.getUserIdList())
                .eq(isNotBlank(query.getUserType()), ChangeLog::getUserType, query.getUserType())
                .like(isNotBlank(query.getUserDisplayNameLike()), ChangeLog::getUserDisplayName, query.getUserDisplayNameLike())
                .in(isNotEmpty(query.getOrgIdList()), ChangeLog::getOrgId, query.getOrgIdList())
                .like(isNotBlank(query.getOrgNameLike()), ChangeLog::getOrgName, query.getOrgNameLike())
                .eq(isNotBlank(query.getPlatform()), ChangeLog::getPlatform, query.getPlatform())
                .in(isNotEmpty(query.getTenantIdList()), ChangeLog::getTenantId, query.getTenantIdList())
                .in(isNotEmpty(query.getBusinessIdList()), ChangeLog::getBusinessId, query.getBusinessIdList())
                .eq(nonNull(query.getBusinessType()), ChangeLog::getBusinessType, query.getBusinessType())
                .like(isNotBlank(query.getMessageLike()), ChangeLog::getMessage, query.getMessageLike())
                .like(isNotBlank(query.getServerNameLike()), ChangeLog::getServerName, query.getServerNameLike())
                .like(isNotBlank(query.getServerAppNameLike()), ChangeLog::getServerAppName, query.getServerAppNameLike())
                // 排序需要增加判断条件 isNull(query.getScrollByAsc())，是为了滚动分页查询而服务的
                .orderByDesc(ObjUtil.isNull(query.getScrollByAsc()), ChangeLog::getId)
        ;
    }


    /**
     * 统一的数据变动日志表数据的处理逻辑
     */
    @Override
    protected void processData(ChangeLogQuery qry, List<ChangeLogResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 数据处理
        data.forEach(item -> {
            if (StrUtil.isNotBlank(item.getMessage())) {
                item.setMessage(StrUtil.sub(item.getMessage(), ZERO, FIVE_HUNDRED));
            }
        });
        // 数据提取
        /*List<Long> idList = data.stream().filter(Objects::nonNull)
                .map(ChangeLogResult::getId)
                .distinct().collect(Collectors.toList());*/
    }

    /**
     * 统一的数据变动日志表数据的填充逻辑
     */
    @Override
    protected void fillingData(ChangeLogQuery qry, List<ChangeLogResult> data) {
        if (CollUtil.isEmpty(data)) { return; }
        // 数据填充
        /*FillCfg.of(data).addDataConfig(DataCfg.of(MpServIdsSupplier.of(UserService.class, User::getId))
                .addFieldConfig("userId", "userName", "name")
        ).addDataConfig(DataCfg.of(MpServIdsSupplier.of(CompanyService.class, Company::getId))
                .addFieldConfig("companyId", "companyName", "name")
        ).addDataConfig(DataCfg.of(EnumSupplier.of(ChangeLogStatus.class))
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
