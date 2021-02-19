package com.gd.terminalmanager.glidetransformationdemo;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2019/10/28
 * @updatelog
 * 定义该类，可以不用再去设置options，可以像以前一样直接使用.placeholder()等方法，将Glide.with()替换为GlideApp。with()
 * 需要加上注解@GlideModule，然后rebuild
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule {
}
