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
 * 数据变动日志表的编辑操作的入参对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
public class ChangeLogEditParam implements Serializable {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空")
    @FieldMeta(description = "主键ID")
    private Long id;
    /**
     * 时间
     */
    @NotNull(message = "时间不能为空")
    @FieldMeta(description = "时间")
    private Date time;
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
     * 业务ID
     */
    @NotBlank(message = "业务ID不能为空")
    @FieldMeta(description = "业务ID")
    private String businessId;
    /**
     * 业务类型：0 缺省
     */
    @NotNull(message = "业务类型：0 缺省不能为空")
    @FieldMeta(description = "业务类型：0 缺省")
    private Integer businessType;
    /**
     * 消息
     */
    @FieldMeta(description = "消息")
    private String message;
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
