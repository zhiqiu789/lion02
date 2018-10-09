package com.lion.convert;

/**
 *
 * @param <S>   S代表转换前的内容,
 * @param <T>   T代表你期望转换的类型
 */
public interface Convert<S,T> {
    /**
     * 转换数据
     * @param source 原始类型
     * @return 将要转换的类型
     */
    T convert(S source);
}
