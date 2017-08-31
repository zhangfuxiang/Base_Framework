package com.example.fuxiangzhang.base_framwork.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Fuxiang.Zhang on 2017/7/25.
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
