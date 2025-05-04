package baibao.plugin.service.basic.api.task.acommon.enums.base;

import kunlun.data.CodeDefinition;

/**
 * 异步任务类型的枚举.
 *
 * @author Kahle
 * @since 2025-05-04
 */
public enum AsyncTaskType implements CodeDefinition {
    /**
     * 缺省
     */
    DEFAULT(0, ""),
    /**
     * 导出
     */
    EXPORT(1, "导出"),
    /**
     * 导入
     */
    IMPORT(2, "导入"),
    ;

    private final String  description;
    private final Integer code;

    AsyncTaskType(Integer code, String description) {
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

    public static AsyncTaskType parse(Object input) {
        if (input == null) { return null; }
        if (input instanceof AsyncTaskType) {
            return (AsyncTaskType) input;
        }
        int inputInt;
        if (!(input instanceof Integer)) {
            inputInt = Integer.parseInt(String.valueOf(input));
        }
        else { inputInt = (Integer) input; }
        AsyncTaskType[] values = values();
        for (AsyncTaskType value : values) {
            if (value.getCode().equals(inputInt)) { return value; }
        }
        return DEFAULT;
    }

}
