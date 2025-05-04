package baibao.plugin.service.basic.api.task.pojo.query;

import baibao.common.dto.base.BaseQuery;
import kunlun.data.json.support.jackson.annotation.JsonSceneDeserialize;
import kunlun.data.json.support.jackson.model.Scene;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 异步处理的任务表的查询对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AsyncProcTaskQuery extends BaseQuery implements Serializable {

    /**
     * 主键Id
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> idList;
    /**
     * 业务类型：0 缺省
     */
    private Integer businessType;
    /**
     * 业务ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> businessIdList;
    /**
     * 任务类型：0 缺省，1 导出，2 导入
     */
    private Integer taskType;
    /**
     * 任务参数（JSON对象字符串）
     */
    private String taskParameters;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 原始文件（JSON对象数组）
     */
    private String originalFiles;
    /**
     * 原文件名称（支持模糊搜索）
     */
    private String originalFilenameLike;
    /**
     * 状态：0 缺省，1 待导入|导出，2 前置处理，3 导入|导出中，4 超时，5 失败，6 成功
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Integer> statusList;
    /**
     * 执行者名称（支持模糊搜索）
     */
    private String executorNameLike;
    /**
     * 平台信息
     */
    private String platform;
    /**
     * 租户ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> tenantIdList;
    /**
     * 数据的所属人ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> ownerIdList;
    /**
     * 数据的所属机构ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> ownOrgIdList;

}
