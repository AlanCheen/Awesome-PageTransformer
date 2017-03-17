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
 */
public class AlphaPageTransformer extends BasePageTransformer {

    private Transformer mAlphaTransformer;

    public AlphaPageTransformer() {
        this(0f, 1f);
    }

    public AlphaPageTransformer(float minAlpha,float maxAlpha) {
        mAlphaTransformer = new AlphaTransformer(minAlpha,maxAlpha);
    }

    @Override
    public void onScreenOffToLeft(View page, float position) {
        mAlphaTransformer.onScreenOffToLeft(page, position);
    }

    @Override
    public void onLeftRange(View page, float position) {
        mAlphaTransformer.onLeftRange(page, position);
    }

    @Override
    public void onRightRange(View page, float position) {
        mAlphaTransformer.onRightRange(page, position);
    }

    @Override
    public void onScreenOffToRight(View page, float position) {
        mAlphaTransformer.onScreenOffToRight(page, position);
    }
}
