package com.xie.utils;


import com.xie.annotation.FieldValue;

/**
 * FieldValue工具
 *
 * @author zhaojian
 * @version 2016检核重构
 * @createDay 2016-1-29
 */
public class FieldValueUtils {

	/**
	 * 获取枚举的FieldValue
	 *
	 * @param aEnum
	 * @return FieldId
	 */
	public static <T extends Enum<T>> String get(final T aEnum) {
		final FieldValue value = aEnum.getClass().getFields()[aEnum.ordinal()].getAnnotation(FieldValue.class);
		return value.value();
	}

}
