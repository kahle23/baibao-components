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
 * 运行日志表的查询对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RunLogQuery extends BaseQuery implements Serializable {


    /**
     * 主键ID
     */
    @JsonSceneDeserialize(Scene.SINGLE_TO_LIST)
    private List<Long> idList;
    /**
     * 服务器的名称（支持模糊搜索）
     */
    private String serverNameLike;
    /**
     * 服务器的应用名称（支持模糊搜索）
     */
    private String serverAppNameLike;
    /**
     * 时间
     */
    private Date time;
    /**
     * 模块名（支持模糊搜索）
     */
    private String moduleLike;
    /**
     * 消息（支持模糊搜索）
     */
    private String messageLike;
    /**
     * 是否执行成功：0 未成功，1 成功
     */
    private Integer success;
    /**
     * 错误消息（支持模糊搜索）
     */
    private String errorLike;

}
