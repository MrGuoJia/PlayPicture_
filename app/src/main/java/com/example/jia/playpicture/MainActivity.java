package com.example.jia.playpicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    int dogs[]=new int[]{//如果是网络图片资源必须开网络权限,这个是本地图片资源
            R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4, R.drawable.dog5,
            R.drawable.dog6, R.drawable.dog7, R.drawable.dog8, R.drawable.dog9, R.drawable.dog10,
    };
    List list=new ArrayList();
    String dogTitls[]=new String[]{"一号小伊","二号萌萌","三号小爱","四号小梦","五号小午"
            ,"六号小柳","七号小琪","八号小巴","九号小鸠","十号小石头"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<dogs.length;i++){
            list.add(dogs[i]);
        }
        inintViews();
    }
    private void inintViews() {
        banner= (Banner) findViewById(R.id.banner);
        // 设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);
        banner.setIndicatorGravity(Banner.CENTER);//Banner.CENTER 指示器居中
        banner.setBannerTitle(dogTitls); //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        banner.isAutoPlay(true) ;//设置是否自动轮播（不设置则默认自动）
        banner.setDelayTime(5000);

        banner.setImages( list, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                //Glide.with(getApplicationContext()).load(url).into(view);

                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(getApplicationContext()).load(url).into(view);

            }
        });
        //设置点击事件，下标是从1开始
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "你点击了：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
