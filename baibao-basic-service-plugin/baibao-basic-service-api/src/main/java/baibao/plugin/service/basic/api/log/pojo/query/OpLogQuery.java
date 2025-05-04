package baibao.plugin.service.basic.api.log.pojo.query;

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
 * 操作日志表的查询对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpLogQuery extends BaseQuery implements Serializable {

    /**
     * 主键ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> idList;
    /**
     * 事件名称（支持模糊搜索）
     */
    private String nameLike;
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
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> userIdList;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户的展示名（支持模糊搜索）
     */
    private String userDisplayNameLike;
    /**
     * 用户所在的机构ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> orgIdList;
    /**
     * 用户所在的机构名称（支持模糊搜索）
     */
    private String orgNameLike;
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
     * 跟踪ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> traceIdList;
    /**
     * 请求的URI
     */
    private String requestApiUri;
    /**
     * 请求的方法
     */
    private String requestMethod;
    /**
     * 是否执行成功：0 未成功，1 成功
     * @see baibao.common.enums.Success
     */
    private Integer success;
    /**
     * 错误消息（支持模糊搜索）
     */
    private String errorLike;
    /**
     * 耗时（单位：毫秒）
     */
    private Integer timeSpent;
    /**
     * 客户端的应用的ID（标识是哪个应用）
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> clientAppIdList;
    /**
     * 客户端的设备的ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> clientDeviceIdList;
    /**
     * 客户端的用户代理（支持模糊搜索）
     */
    private String clientUserAgentLike;
    /**
     * 客户端的网络地址
     */
    private String clientNetAddress;
    /**
     * 客户端的地理地址
     */
    private String clientGeoAddress;
    /**
     * 服务器的名称（支持模糊搜索）
     */
    private String serverNameLike;
    /**
     * 服务器的应用名称（支持模糊搜索）
     */
    private String serverAppNameLike;

}
