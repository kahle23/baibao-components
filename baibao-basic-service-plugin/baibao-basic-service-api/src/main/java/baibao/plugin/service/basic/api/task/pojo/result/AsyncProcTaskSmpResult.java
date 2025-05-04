package baibao.plugin.service.basic.api.task.pojo.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 异步处理的任务表的简单结果对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
public class AsyncProcTaskSmpResult implements Serializable {

    /**
     * 序号
     */
    private Long serialNumber;

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 业务类型：0 缺省
     */
    private Integer businessType;
    /**
     * 业务ID
     */
    private Long businessId;
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
     * 原文件名称
     */
    private String originalFilename;
    /**
     * 状态：0 缺省，1 待导入|导出，2 前置处理，3 导入|导出中，4 超时，5 失败，6 成功
     */
    private Integer status;
    /**
     * 执行者名称
     */
    private String executorName;
    /**
     * 执行失败的次数
     */
    private Integer execFailureCount;
    /**
     * 成功条数
     */
    private Integer successCount;
    /**
     * 失败条数
     */
    private Integer failureCount;
    /**
     * 总条数
     */
    private Integer totalCount;
    /**
     * 结果文件信息
     */
    private String resultFile;
    /**
     * 错误信息（失败信息）
     */
    private String errorMessage;
    /**
     * 平台信息
     */
    private String platform;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 数据的所属人ID
     */
    private Long ownerId;
    /**
     * 数据的所属机构ID
     */
    private Long ownOrgId;
    /**
     * 创建者
     */
    private Long createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改者
     */
    private Long modifyUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 删除状态：0 未删除，1 已删除
     */
    private Integer deleteStatus;

}
