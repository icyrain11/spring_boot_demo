package com.icyrain11.project_template.common.idempotent.aspectj;

import org.aspectj.lang.annotation.Aspect;

/**
 * @author icyrain11
 * @version 17
 */
@Aspect
public class RepeatSubmitAspect {

    private static final ThreadLocal<String> KEY_CACHE = new ThreadLocal<>();


}
