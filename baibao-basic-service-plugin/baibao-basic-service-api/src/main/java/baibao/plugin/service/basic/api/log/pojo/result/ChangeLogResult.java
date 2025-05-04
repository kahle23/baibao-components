package baibao.plugin.service.basic.api.log.pojo.result;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 数据变动日志表的结果对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class ChangeLogResult implements Serializable {

    // region ======== 区域 ========// endregion
    /**
     * 主键ID
     */
    @ExcelProperty("主键ID")
    private Long id;
    /**
     * 时间
     */
    @ExcelProperty("时间")
    private Date time;
    /**
     * 用户ID
     */
    @ExcelProperty("用户ID")
    private String userId;
    /**
     * 用户类型
     */
    @ExcelProperty("用户类型")
    private String userType;
    /**
     * 用户的展示名
     */
    @ExcelProperty("用户的展示名")
    private String userDisplayName;
    /**
     * 用户所在的机构ID
     */
    @ExcelProperty("用户所在的机构ID")
    private String orgId;
    /**
     * 用户所在的机构名称
     */
    @ExcelProperty("用户所在的机构名称")
    private String orgName;
    /**
     * 平台信息
     */
    @ExcelProperty("平台信息")
    private String platform;
    /**
     * 租户ID
     */
    @ExcelProperty("租户ID")
    private String tenantId;
    /**
     * 业务ID
     */
    @ExcelProperty("业务ID")
    private String businessId;
    /**
     * 业务类型：0 缺省
     */
    @ExcelProperty("业务类型：0 缺省")
    private Integer businessType;
    /**
     * 消息
     */
    @ExcelProperty("消息")
    private String message;
    /**
     * 服务器的名称
     */
    @ExcelProperty("服务器的名称")
    private String serverName;
    /**
     * 服务器的应用名称
     */
    @ExcelProperty("服务器的应用名称")
    private String serverAppName;
    /**
     * 其他数据的JSON
     */
    @ExcelProperty("其他数据的JSON")
    private String dataJson;
    /**
     * 删除状态：0 未删除，1 已删除
     */
    @ExcelProperty("删除状态：0 未删除，1 已删除")
    private Integer deleteStatus;

}
