package com.xie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 占坑
 * 
 * @author zhaojian
 * @version 2016检核重构
 * @createDay 2016-1-12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldValue {
	String value();
}
