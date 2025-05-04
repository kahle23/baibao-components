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
 * 数据变动日志表的查询对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChangeLogQuery extends BaseQuery implements Serializable {

    /**
     * 主键ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> idList;
    /**
     * 时间
     */
    private Date time;
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
     * 业务ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<String> businessIdList;
    /**
     * 业务类型：0 缺省
     */
    private Integer businessType;
    /**
     * 消息（支持模糊搜索）
     */
    private String messageLike;
    /**
     * 服务器的名称（支持模糊搜索）
     */
    private String serverNameLike;
    /**
     * 服务器的应用名称（支持模糊搜索）
     */
    private String serverAppNameLike;

}
