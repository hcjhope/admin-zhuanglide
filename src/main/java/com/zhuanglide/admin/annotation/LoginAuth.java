package com.zhuanglide.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登陆授权注解
 * @author wwj
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAuth {
	public enum Auth {
        OPTION(0), REQUIRED(1);
        private int priority;
        Auth(int priority) {
            this.priority = priority;
        }
        public int getPriority() {
            return priority;
        }
    }
}
