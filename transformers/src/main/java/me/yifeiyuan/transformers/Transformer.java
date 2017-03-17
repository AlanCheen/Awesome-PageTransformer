package me.yifeiyuan.transformers;

import android.view.View;

/**
 * Created by 程序亦非猿 on 16/5/10.
 *
 * Transformer抽象了PageTransformer的真正执行行为
 */
public interface Transformer {
    /**
     * page在屏幕的左边 并且已经不可见了
     *
     * @param page
     * @param position [-infinity,-1)
     */
    void onScreenOffToLeft(View page, float position);

    /**
     * 在左边第一个屏幕以及手机屏幕之间移动
     * [-1,0]
     *
     * @param page
     * @param position [-1,0]
     */
    void onLeftRange(View page, float position);

    /**
     * 在右边第一个屏幕以及手机屏幕之间移动
     * (0,1]
     *
     * @param page
     * @param position (0,1]
     */
    void onRightRange(View page, float position);

    /**
     * page在屏幕的右边 并且已经不可见了
     *
     * @param page
     * @param position (1,infinity]
     */
    void onScreenOffToRight(View page, float position);
}
