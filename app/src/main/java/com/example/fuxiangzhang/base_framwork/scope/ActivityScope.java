package com.example.fuxiangzhang.base_framwork.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 10109 on 2017/7/19.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
