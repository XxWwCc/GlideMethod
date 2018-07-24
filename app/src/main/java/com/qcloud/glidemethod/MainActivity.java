package com.qcloud.glidemethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv_3)
    ImageView iv3;
    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1532348160532&di=8cbb513e5528ea68aa62a160ff3ef7b4&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F02%2F20140802232108_3BfUe.jpeg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Glide.with(this)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv1);

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)//加载成功之前占位图
                .error(R.mipmap.ic_launcher)	//加载错误之后的错误图
                .override(100,100)//指定图片的尺寸,一般不指定,glide可以自适应
                .fitCenter() //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .centerCrop()  //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                .skipMemoryCache(true)//跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL);//缓存所有版本的图像
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1532410390899&di=e738e4102d1c45cc12a2522439e9f8c5&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F85cc5ccbgy1ffnelotn8cg20dw0jg1cd.jpg")
                .apply(requestOptions
                        .placeholder(R.mipmap.ic_launcher)//加载成功之前占位图
                        .error(R.mipmap.ic_launcher)	//加载错误之后的错误图
                        .override(500,500)//指定图片的尺寸,一般不指定,glide可以自适应
                        .fitCenter() //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                        .centerCrop()  //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                        .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                        .skipMemoryCache(true)//跳过内存缓存
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(iv2);

        Glide.with(this)
                .load(R.drawable.smoker)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv3);
    }
}
