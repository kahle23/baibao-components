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
 * 运行日志表的结果对象.
 *
 * @author Kahle
 * @since 2025-05-04
 */
@Data
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class RunLogResult implements Serializable {

    // region ======== 区域 ========// endregion
    /**
     * 主键ID
     */
    @ExcelProperty("主键ID")
    private Long id;
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
     * 时间
     */
    @ExcelProperty("时间")
    private Date time;
    /**
     * 模块名
     */
    @ExcelProperty("模块名")
    private String module;
    /**
     * 消息
     */
    @ExcelProperty("消息")
    private String message;
    /**
     * 是否执行成功：0 未成功，1 成功
     */
    @ExcelProperty("是否执行成功：0 未成功，1 成功")
    private Integer success;
    /**
     * 错误消息
     */
    @ExcelProperty("错误消息")
    private String error;
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
