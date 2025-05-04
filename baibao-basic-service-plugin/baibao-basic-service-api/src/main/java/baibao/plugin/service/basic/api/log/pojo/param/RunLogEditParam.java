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
 * 运行日志表的编辑操作的入参对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
public class RunLogEditParam implements Serializable {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空")
    @FieldMeta(description = "主键ID")
    private Long id;
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
     * 时间
     */
    @NotNull(message = "时间不能为空")
    @FieldMeta(description = "时间")
    private Date time;
    /**
     * 模块名
     */
    @NotBlank(message = "模块名不能为空")
    @FieldMeta(description = "模块名")
    private String module;
    /**
     * 消息
     */
    @FieldMeta(description = "消息")
    private String message;
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
