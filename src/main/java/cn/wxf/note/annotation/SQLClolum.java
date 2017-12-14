package cn.wxf.note.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wxf on 2017/12/12.
 * 目前只有这个几个常用属性，后面需要会继续添加
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLClolum {
    String name() default "";

    //boolean unique() default false;

    boolean nullable() default true;


    //String columnDefinition() default "";


    int length() default 255;

    String comment() default "";

}
