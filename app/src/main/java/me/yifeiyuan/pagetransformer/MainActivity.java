package me.yifeiyuan.pagetransformer;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import me.yifeiyuan.transformers.AlphaPageTransformer;
import me.yifeiyuan.transformers.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {


    ViewPager mVp;
    ViewPager mVp2;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mVp = (ViewPager) findViewById(R.id.vp);
        mVp.setAdapter(new SimplePagerAdapter(mContext));
        mVp.setPageTransformer(false,new AlphaPageTransformer(0.2f,0.3f));

        mVp2 = (ViewPager) findViewById(R.id.vp2);
        mVp2.setAdapter(new SimplePagerAdapter(mContext));
        mVp2.setPageTransformer(false,new ZoomOutPageTransformer());
        mVp2.setPageMargin(10);
        mVp2.setOffscreenPageLimit(2);
        mVp2.setCurrentItem(1);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.alpha) {
            mVp.setPageTransformer(false, new AlphaPageTransformer(0.3f,0.8f));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
