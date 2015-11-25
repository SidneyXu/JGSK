package com.bookislife.jgsk.java._33_reflect_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by SidneyXu on 2015/11/25.
 */
/*
    Retention means how to save the annotation, in class or source or runtime,
    only runtime can be reflected.
    Target means which location can the annotation put.
  */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Bean {
    String name();
}
