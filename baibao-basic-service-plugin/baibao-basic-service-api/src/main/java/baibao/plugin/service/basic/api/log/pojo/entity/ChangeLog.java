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
 * 数据变动日志表的数据库实体.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("base_change_log")
public class ChangeLog implements Serializable {

    /* (Start) This will be overridden, please do not modify. */
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 时间
     */
    private Date time;
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
     * 业务ID
     */
    private String businessId;
    /**
     * 业务类型：0 缺省
     */
    private Integer businessType;
    /**
     * 消息
     */
    private String message;
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
