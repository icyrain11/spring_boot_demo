package com.icyrain11.project_template.common.idempotent.annotation;

import java.util.concurrent.TimeUnit;

/**
 * @author icyrain11
 * @version 1.8
 */
public @interface RepeatSubmit {

    /**
     * 间隔时间(ms)，小于此时间视为重复提交
     */
    int interval() default 5000;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * 提示消息 支持国际化 格式为 {code}
     */
    String message() default "{repeat.submit.message}";

}
