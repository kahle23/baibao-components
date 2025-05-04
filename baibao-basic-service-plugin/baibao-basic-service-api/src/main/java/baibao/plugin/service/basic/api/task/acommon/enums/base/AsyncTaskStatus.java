package baibao.plugin.service.basic.api.task.acommon.enums.base;

import kunlun.data.CodeDefinition;

/**
 * 异步任务状态的枚举.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public enum AsyncTaskStatus implements CodeDefinition {
    /**
     * 缺省
     */
    DEFAULT(0, ""),
    /**
     * 待处理（待导入|待导出）
     */
    N1(1, "待处理"),
    /**
     * 预处理：异步任务开始之前的处理
     */
    N2(2, "预处理"),
    /**
     * 处理中（导入中|导出中）
     */
    N3(3, "处理中"),
    /**
     * 超时
     */
    N4(4, "超时"),
    /**
     * 失败
     */
    N5(5, "失败"),
    /**
     * 成功
     */
    N6(6, "成功"),
    ;

    private final String  description;
    private final Integer code;

    AsyncTaskStatus(Integer code, String description) {
        this.description = description;
        this.code = code;
    }

    @Override
    public Integer getCode() {

        return code;
    }

    @Override
    public String getDescription() {

        return description;
    }

    public static AsyncTaskStatus parse(Object input) {
        if (input == null) { return null; }
        if (input instanceof AsyncTaskStatus) {
            return (AsyncTaskStatus) input;
        }
        int inputInt;
        if (!(input instanceof Integer)) {
            inputInt = Integer.parseInt(String.valueOf(input));
        }
        else { inputInt = (Integer) input; }
        AsyncTaskStatus[] values = values();
        for (AsyncTaskStatus value : values) {
            if (value.getCode().equals(inputInt)) { return value; }
        }
        return DEFAULT;
    }

}
