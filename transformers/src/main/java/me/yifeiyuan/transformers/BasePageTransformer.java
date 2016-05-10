/*
 * Copyright (C) 2015, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.transformers;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 程序亦非猿 on 16/5/10.
 *
 *      -1    0      1      2
 * 负无穷|left|手机屏幕|right|正无穷
 */
public abstract class BasePageTransformer implements ViewPager.PageTransformer ,Transformer{

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) { //[-infinity,-1)
            onScreenOffToLeft(page, position);
        } else if (position <= 0) { //[-1,0]
            onLeftRange(page, position);
        } else if (position <= 1) { //(0,1]
            onRightRange(page, position);
        } else { //(1,infinity]
            onScreenOffToRight(page, position);
        }
    }

    /**
     * page在屏幕的左边 并且已经不可见了
     *
     * @param page
     * @param position [-infinity,-1)
     */
    public abstract void onScreenOffToLeft(View page, float position);

    /**
     * 在左边第一个屏幕以及手机屏幕之间移动
     *
     * @param page
     * @param position [-1,0]
     */
    public abstract void onLeftRange(View page, float position);

    /**
     * 在右边第一个屏幕以及手机屏幕之间移动
     *
     * @param page
     * @param position (0,1]
     */
    public abstract void onRightRange(View page, float position);

    /**
     * page在屏幕的右边 并且已经不可见了
     *
     * @param page
     * @param position (1,infinity]
     */
    public abstract void onScreenOffToRight(View page, float position);

}

