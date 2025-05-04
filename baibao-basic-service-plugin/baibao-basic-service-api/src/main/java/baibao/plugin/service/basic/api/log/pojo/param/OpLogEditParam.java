package baibao.plugin.service.basic.api.log.pojo.param;

import kunlun.core.annotation.FieldMeta;
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
 * 操作日志表的编辑操作的入参对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
public class OpLogEditParam implements Serializable {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空")
    @FieldMeta(description = "主键ID")
    private Long id;
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
    @FieldMeta(description = "消息")
    private String message;
    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空")
    @FieldMeta(description = "用户ID")
    private String userId;
    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空")
    @FieldMeta(description = "用户类型")
    private String userType;
    /**
     * 用户的展示名
     */
    @NotBlank(message = "用户的展示名不能为空")
    @FieldMeta(description = "用户的展示名")
    private String userDisplayName;
    /**
     * 用户所在的机构ID
     */
    @NotBlank(message = "用户所在的机构ID不能为空")
    @FieldMeta(description = "用户所在的机构ID")
    private String orgId;
    /**
     * 用户所在的机构名称
     */
    @NotBlank(message = "用户所在的机构名称不能为空")
    @FieldMeta(description = "用户所在的机构名称")
    private String orgName;
    /**
     * 平台信息
     */
    @NotBlank(message = "平台信息不能为空")
    @FieldMeta(description = "平台信息")
    private String platform;
    /**
     * 租户ID
     */
    @NotBlank(message = "租户ID不能为空")
    @FieldMeta(description = "租户ID")
    private String tenantId;
    /**
     * 跟踪ID
     */
    @NotBlank(message = "跟踪ID不能为空")
    @FieldMeta(description = "跟踪ID")
    private String traceId;
    /**
     * 请求的URI
     */
    @NotBlank(message = "请求的URI不能为空")
    @FieldMeta(description = "请求的URI")
    private String requestApiUri;
    /**
     * 请求的方法
     */
    @NotBlank(message = "请求的方法不能为空")
    @FieldMeta(description = "请求的方法")
    private String requestMethod;
    /**
     * 请求参数（JSON）
     */
    @FieldMeta(description = "请求参数（JSON）")
    private String input;
    /**
     * 返回结果（JSON）
     */
    @FieldMeta(description = "返回结果（JSON）")
    private String output;
    /**
     * 是否执行成功：0 未成功，1 成功
     */
    @NotNull(message = "是否执行成功：0 未成功，1 成功不能为空")
    @FieldMeta(description = "是否执行成功：0 未成功，1 成功")
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
    @NotBlank(message = "客户端的应用的ID（标识是哪个应用）不能为空")
    @FieldMeta(description = "客户端的应用的ID（标识是哪个应用）")
    private String clientAppId;
    /**
     * 客户端的设备的ID
     */
    @NotBlank(message = "客户端的设备的ID不能为空")
    @FieldMeta(description = "客户端的设备的ID")
    private String clientDeviceId;
    /**
     * 客户端的用户代理
     */
    @NotBlank(message = "客户端的用户代理不能为空")
    @FieldMeta(description = "客户端的用户代理")
    private String clientUserAgent;
    /**
     * 客户端的网络地址
     */
    @NotBlank(message = "客户端的网络地址不能为空")
    @FieldMeta(description = "客户端的网络地址")
    private String clientNetAddress;
    /**
     * 客户端的地理地址
     */
    @NotBlank(message = "客户端的地理地址不能为空")
    @FieldMeta(description = "客户端的地理地址")
    private String clientGeoAddress;
    /**
     * 客户端的地理位置（经纬度JSON）
     */
    @NotBlank(message = "客户端的地理位置（经纬度JSON）不能为空")
    @FieldMeta(description = "客户端的地理位置（经纬度JSON）")
    private String clientGeoLocation;
    /**
     * 服务器的名称
     */
    @NotBlank(message = "服务器的名称不能为空")
    @FieldMeta(description = "服务器的名称")
    private String serverName;
    /**
     * 服务器的应用名称
     */
    @NotBlank(message = "服务器的应用名称不能为空")
    @FieldMeta(description = "服务器的应用名称")
    private String serverAppName;
    /**
     * 其他数据的JSON
     */
    @FieldMeta(description = "其他数据的JSON")
    private String dataJson;
    /**
     * 删除状态：0 未删除，1 已删除
     */
    @NotNull(message = "删除状态：0 未删除，1 已删除不能为空")
    @FieldMeta(description = "删除状态：0 未删除，1 已删除")
    private Integer deleteStatus;

}
