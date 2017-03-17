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

package me.yifeiyuan.pagetransformer;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 程序亦非猿 on 16/5/11.
 */
public class SimplePagerAdapter extends PagerAdapter{


    private Context mContext;

    SimplePagerAdapter(Context context) {

        mContext = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v =  new View(mContext);
//                v.setLayoutParams(new ViewPager.LayoutParams());
        v.setPadding(20,0,20,0);
        if (position % 2 == 0) {
            v.setBackgroundColor(Color.parseColor("#00ff00"));
        }else{
            v.setBackgroundColor(Color.parseColor("#00ffff"));
        }
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
