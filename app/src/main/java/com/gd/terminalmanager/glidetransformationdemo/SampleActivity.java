package com.gd.terminalmanager.glidetransformationdemo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2019/10/31
 * @updatelog
 */
public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
//        Glide.with(this).load(R.drawable.oppo).into(imageView);
        Glide.with(this).load("https://hbimg.b0.upaiyun.com/12d9aab22322829a2beb01000a549156fc3e65902f415-Xw2YIl_fw658").into(imageView);
        Glide.with(this).load("https://hbimg.b0.upaiyun.com/12d9aab22322829a2beb01000a549156fc3e65902f415-Xw2YIl_fw658").dontTransform().into(imageView1);
        Glide.with(this).load("https://hbimg.b0.upaiyun.com/12d9aab22322829a2beb01000a549156fc3e65902f415-Xw2YIl_fw658").override(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL).into(imageView2);

    }
}
