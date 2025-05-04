package baibao.plugin.service.basic.api.log.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 操作日志表的数据库实体.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("base_op_log")
public class OpLog implements Serializable {

    /* (Start) This will be overridden, please do not modify. */
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 事件名称
     */
    private String name;
    /**
     * 时间
     */
    private Date time;
    /**
     * 消息
     */
    private String message;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户的展示名
     */
    private String userDisplayName;
    /**
     * 用户所在的机构ID
     */
    private String orgId;
    /**
     * 用户所在的机构名称
     */
    private String orgName;
    /**
     * 平台信息
     */
    @TableField(fill = FieldFill.INSERT)
    private String platform;
    /**
     * 租户ID
     */
    @TableField(fill = FieldFill.INSERT)
    private String tenantId;
    /**
     * 跟踪ID
     */
    private String traceId;
    /**
     * 请求的URI
     */
    private String requestApiUri;
    /**
     * 请求的方法
     */
    private String requestMethod;
    /**
     * 请求参数（JSON）
     */
    private String input;
    /**
     * 返回结果（JSON）
     */
    private String output;
    /**
     * 是否执行成功：0 未成功，1 成功
     */
    private Integer success;
    /**
     * 错误消息
     */
    private String error;
    /**
     * 耗时（单位：毫秒）
     */
    private Integer timeSpent;
    /**
     * 客户端的应用的ID（标识是哪个应用）
     */
    private String clientAppId;
    /**
     * 客户端的设备的ID
     */
    private String clientDeviceId;
    /**
     * 客户端的用户代理
     */
    private String clientUserAgent;
    /**
     * 客户端的网络地址
     */
    private String clientNetAddress;
    /**
     * 客户端的地理地址
     */
    private String clientGeoAddress;
    /**
     * 客户端的地理位置（经纬度JSON）
     */
    private String clientGeoLocation;
    /**
     * 服务器的名称
     */
    private String serverName;
    /**
     * 服务器的应用名称
     */
    private String serverAppName;
    /**
     * 其他数据的JSON
     */
    private String dataJson;
    /**
     * 删除状态：0 未删除，1 已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteStatus;
    /* (End) This will be overridden, please do not modify. */

}
