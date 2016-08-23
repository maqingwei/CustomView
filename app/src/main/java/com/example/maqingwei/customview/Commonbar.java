package com.example.maqingwei.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by maqingwei
 * Date on 16/8/23 上午11:31
 *
 * @Description:
 */
public class Commonbar extends RelativeLayout {

    //定义需要的View控件
    private TextView mLeftBtn,mRightBtn,mTitle;

    //定义所需要的属性
    private String mLeftText,mTitleText,mRightText;
    private int    mLeftColor,mRightColor,mTitleColor;
    private Drawable mLeftBackground,mRigthBackground;

    private float mTitleTextSize;

    private  LayoutParams  mLeftParmas,mTiteParmas,mRightParmas;


    //如果要在xml中使用该view 构造方法就需要写带有attribute的参数.
    public Commonbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //将xml中定义的自定义属性映射要attrs中

        TypedArray  ta = context.obtainStyledAttributes(attrs,R.styleable.Commonbar);

        //从ta中取出需要的属性的值,并赋值给相应变量.
        //类似于map 通过key-value存取,并赋值给相应变量

        mLeftText = ta.getString(R.styleable.Commonbar_leftText);
        mLeftColor = ta.getColor(R.styleable.Commonbar_leftTextColor,0);
        mLeftBackground = ta.getDrawable(R.styleable.Commonbar_leftBackground);

        mTitleText = ta.getString(R.styleable.Commonbar_titles);
        mTitleColor = ta.getColor(R.styleable.Commonbar_titleClolor,0);
        mTitleTextSize = ta.getDimension(R.styleable.Commonbar_titleSize,0);

        mRightText = ta.getString(R.styleable.Commonbar_rightText);
        mRightColor = ta.getColor(R.styleable.Commonbar_rightTextColor,0);
        mRigthBackground = ta.getDrawable(R.styleable.Commonbar_rightBackground);

        //回收typearray 避免浪费资源 避免缓存造成的错误
        ta.recycle();
        intiView(context);


    }

    private void intiView(Context context){

        mTitle = new TextView(context);
        mLeftBtn = new TextView(context);
        mRightBtn = new TextView(context);

        mTitle.setText(mTitleText);
        mTitle.setTextSize(mTitleTextSize);
        mTitle.setTextColor(mTitleColor);
        mTitle.setGravity(Gravity.CENTER);

        mLeftBtn.setText(mLeftText);
        mLeftBtn.setTextColor(mLeftColor);
        mLeftBtn.setBackground(mLeftBackground);
        mLeftBtn.setTextSize(mTitleTextSize);
        mLeftBtn.setGravity(Gravity.CENTER_VERTICAL);


        mRightBtn.setText(mRightText);
        mRightBtn.setTextColor(mRightColor);
        mRightBtn.setBackground(mRigthBackground);
        mRightBtn.setTextSize(mTitleTextSize);
        mRightBtn.setGravity(Gravity.CENTER_VERTICAL);

        //设置控件在ViewGroup中的位置

        mLeftParmas = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mLeftParmas.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        addView(mLeftBtn,mLeftParmas);


        mRightParmas = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mRightParmas.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,CENTER_VERTICAL);
        addView(mRightBtn,mRightParmas);

        mTiteParmas = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mTiteParmas.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitle,mTiteParmas);

        //点击事件的回调
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onrightclick();
            }
        });

        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onleftclick();
            }
        });
    }

    private ClickListener listener;

    public void setTopOnclickListener(ClickListener listener){
        this.listener = listener;
    }

    public interface ClickListener{
         void onleftclick();
         void onrightclick();
    }
}
