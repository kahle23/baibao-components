package baibao.plugin.service.basic.api.log.pojo.param;

import kunlun.core.annotation.FieldMeta;
import kunlun.data.Dict;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 操作日志表的增加的入参对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
public class OpLogAddParam implements Serializable {

    /**
     * 事件名称
     */
    @NotBlank(message = "事件名称不能为空")
    @FieldMeta(description = "事件名称")
    private String name;
    /**
     * 时间
     */
    @NotNull(message = "时间不能为空")
    @FieldMeta(description = "时间")
    private Date time;
    /**
     * 消息
     */
    @NotBlank(message = "消息不能为空")
    @FieldMeta(description = "消息")
    private String message;
    /**
     * 用户ID
     */
    @FieldMeta(description = "用户ID")
    private String userId;
    /**
     * 用户类型
     */
    @FieldMeta(description = "用户类型")
    private String userType;
    /**
     * 用户的展示名
     */
    @FieldMeta(description = "用户的展示名")
    private String userDisplayName;
    /**
     * 用户所在的机构ID
     */
    @FieldMeta(description = "用户所在的机构ID")
    private String orgId;
    /**
     * 用户所在的机构名称
     */
    @FieldMeta(description = "用户所在的机构名称")
    private String orgName;
    /**
     * 平台信息
     */
    @FieldMeta(description = "平台信息")
    private String platform;
    /**
     * 租户ID
     */
    @FieldMeta(description = "租户ID")
    private String tenantId;
    /**
     * 跟踪ID
     */
    @FieldMeta(description = "跟踪ID")
    private String traceId;
    /**
     * 请求的URI
     */
    @FieldMeta(description = "请求的URI")
    private String requestApiUri;
    /**
     * 请求的方法
     */
    @FieldMeta(description = "请求的方法")
    private String requestMethod;
    /**
     * 请求参数（JSON）
     */
    @FieldMeta(description = "请求参数")
    private String input;
    /**
     * 返回结果（JSON）
     */
    @FieldMeta(description = "返回结果")
    private String output;
    /**
     * 是否执行成功：0 未成功，1 成功
     */
    @NotNull(message = "是否执行成功不能为空")
    @FieldMeta(description = "是否执行成功")
    private Integer success;
    /**
     * 错误消息
     */
    @FieldMeta(description = "错误消息")
    private String error;
    /**
     * 耗时（单位：毫秒）
     */
    @FieldMeta(description = "耗时（单位：毫秒）")
    private Integer timeSpent;
    /**
     * 客户端的应用的ID（标识是哪个应用）
     */
    @FieldMeta(description = "客户端的应用的ID")
    private String clientAppId;
    /**
     * 客户端的设备的ID
     */
    @FieldMeta(description = "客户端的设备的ID")
    private String clientDeviceId;
    /**
     * 客户端的用户代理
     */
    @FieldMeta(description = "客户端的用户代理")
    private String clientUserAgent;
    /**
     * 客户端的网络地址
     */
    @FieldMeta(description = "客户端的网络地址")
    private String clientNetAddress;
    /**
     * 客户端的地理地址
     */
    @FieldMeta(description = "客户端的地理地址")
    private String clientGeoAddress;
    /**
     * 客户端的地理位置（经纬度JSON）
     */
    @FieldMeta(description = "客户端的地理位置")
    private String clientGeoLocation;
    /**
     * 服务器的名称
     */
    @FieldMeta(description = "服务器的名称")
    private String serverName;
    /**
     * 服务器的应用名称
     */
    @FieldMeta(description = "服务器的应用名称")
    private String serverAppName;
    /**
     * 其他的数据
     */
    @FieldMeta(description = "其他的数据")
    private Dict data;

}
