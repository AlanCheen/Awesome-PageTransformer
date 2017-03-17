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

import android.view.View;

/**
 * Created by 程序亦非猿 on 16/5/10.
 *
 * 对Page进行Alpha Transform
 */
public class AlphaTransformer implements Transformer {

    private float mMinAlpha;
    private float mMaxAlpha;

    public AlphaTransformer() {
        this(0f, 1f);
    }
    public AlphaTransformer(float minAlpha,float maxAlpha) {
        mMinAlpha = minAlpha;
        mMaxAlpha = maxAlpha;
    }
    @Override
    public void onScreenOffToLeft(View page, float position) {
        page.setAlpha(0f);
    }

    @Override
    public void onLeftRange(View page, float position) {
//        page.setAlpha(Math.min(mMaxAlpha,(mMaxAlpha + mMinAlpha) * Math.abs(position)));
        page.setAlpha(1+position);
    }

    @Override
    public void onRightRange(View page, float position) {
//        page.setAlpha(mMaxAlpha - position);
        page.setAlpha(1-position);
    }

    @Override
    public void onScreenOffToRight(View page, float position) {
        page.setAlpha(0f);
    }
}
