package com.gd.terminalmanager.glidetransformationdemo.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2019/10/28
 * @updatelog
 */
public class MyTransform extends BitmapTransformation {

    private static final int VERSION = 1;
    private static final String ID = "com.gd.terminalmanager.glidetransformationdemo.transform.MyTransform." + VERSION;
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }

    @Override
    public int hashCode() {//必须重写，确保唯一
        return ID.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {//必须重写，确保唯一
        return obj instanceof MyTransform;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        BitmapShader shader = new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);// 获取可复用的bitmap对象
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        }
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(shader);
        Path path = new Path();
        /*心形*/
//        path.addArc(0,0,toTransform.getWidth()/2,toTransform.getHeight()/2,-225,225);
//        path.lineTo(toTransform.getWidth()/2,toTransform.getHeight());
//        path.addArc(toTransform.getWidth()/2,0,toTransform.getWidth(),toTransform.getHeight()/2,-180,225);
//        path.lineTo(toTransform.getWidth()/2,toTransform.getHeight());

        /*五角形*/
//        path.moveTo(width/2,0);
//        path.lineTo(width/5,height);
//        path.lineTo(width,height/3);
//        path.lineTo(0,height/3);
//        path.lineTo(width*4/5,height);
//        path.lineTo(width/2,0);
//        path.setFillType(Path.FillType.WINDING);

        /*六边形*/
//        path.moveTo(width/2,0);
//        path.lineTo(0,height*2/3);
//        path.lineTo(width,height*2/3);
//        path.close();
//
//        path.moveTo(0,height/3);
//        path.lineTo(width/2,height);
//        path.lineTo(width,height/3);
//        path.close();
//        path.setFillType(Path.FillType.WINDING);

//        Canvas canvas = new Canvas(result);
//        canvas.drawPath(path,paint);

        /*圆形加边框*/
        //实际中 int min = Math.min(toTransform.getWidth(), toTransform.getHeight());应该取款高中的最小那个去获取半径
//        Canvas canvas = new Canvas(result);
//        Paint strokePaint  =new Paint(Paint.ANTI_ALIAS_FLAG);
//        strokePaint.setColor(Color.BLUE);
//        canvas.drawCircle(width/2,height/2,width/2,strokePaint);
//        canvas.drawCircle(width/2,height/2,width/2-10,paint);

        /*花边*/
        Canvas canvas = new Canvas(result);
        canvas.drawCircle(width/2,height/2,width/2-50,paint);

        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);

        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.parseColor("#FFD000"));

        path.addCircle(width/2,height/2,width/2-30, Path.Direction.CW);
        paint1.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path, paint1);
        return result;

        /*滤镜，高亮显示*/
//        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
//        Canvas canvas = new Canvas(toTransform);
//        ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
//        paint1.setColorFilter(colorFilter1);
//        canvas.drawBitmap(toTransform,0,0,paint1);
//                return toTransform;

       /* 去掉饱和度，灰色*/
//        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
//        Canvas canvas = new Canvas(toTransform);
//        ColorMatrix colorMatrix = new ColorMatrix();
//        colorMatrix.setSaturation(0);
//        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
//        paint1.setColorFilter(colorMatrixColorFilter);
//        canvas.drawBitmap(toTransform,0,0,paint1);
//
//        return toTransform;
    }
}
