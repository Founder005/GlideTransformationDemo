package com.gd.terminalmanager.glidetransformationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gd.terminalmanager.glidetransformationdemo.transform.MyTransform;

import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ImageView imageView, imageView1, imageView2, imageView3, imageView4;
    String url = "https://hbimg.b0.upaiyun.com/12d9aab22322829a2beb01000a549156fc3e65902f415-Xw2YIl_fw658";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        //圆角变化
        RoundedCorners roundedCorners = new RoundedCorners(8);
//        Glide.with(this).load("").transform(roundedCorners).into(imageView);
//        Glide.with(this).load("").transform(new MultiTransformation<>(new CenterCrop(),new RoundedCorners(8))).into(imageView);

        Glide.with(this).load(url).transform(new CircleCrop()).into(imageView);

        Glide.with(this).load(url).transform(new RoundedCorners(20)).into(imageView1);

        Glide.with(this).load(url).transform(new MyTransform()).into(imageView2);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        requestOptions.dontTransform();//禁止变换
        //requestOptions.override(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL);//使用原始图片的尺寸

        Log.d(TAG, "ImageView的默认缩放模式: " + imageView3.getScaleType());

        //以下两张图片发现最终还是以imageview的scaleType缩放，毕竟imageview的默认是fitCenter，并不会影响Glide的centerCrop的效果
        //一般我们使用Glide显示一张网络图片的时候，imageView通常是不设置scaleType的
        GlideApp.with(this).load(R.drawable.oppo).centerCrop().into(imageView3);

        Glide.with(this).load(R.drawable.oppo).apply(requestOptions).into(imageView4);


        byte[] radiusData = ByteBuffer.allocate(32).putInt(6).putInt(5).array();//1个int占4个字节
        Log.d(TAG,"radiusData="+ radiusData.toString());


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SampleActivity.class));
            }
        });
    }


}
