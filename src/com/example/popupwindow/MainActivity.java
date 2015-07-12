package com.example.popupwindow;

import android.support.v7.app.ActionBarActivity;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements OnClickListener{

	private CommonPopupWindow pop;
	private Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (Button) findViewById(R.id.btnPop);
		mButton.setOnClickListener(this);
		initPop();
	}
	

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		popShow(R.id.rl_main);
	}
	
	private void initPop() {
		// TODO Auto-generated method stub
		pop =new CommonPopupWindow(MainActivity.this, new OnClickListener() {
			/****** popwindow点击事件   ***/
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.linear_add_collect:
					Toast.makeText(MainActivity.this, "添加收藏", Toast.LENGTH_SHORT).show();
					break;
				case R.id.linear_comment:
					Toast.makeText(MainActivity.this, "评论", Toast.LENGTH_SHORT).show();
					break;
				case R.id.linear_zan:
					Toast.makeText(MainActivity.this, "点赞", Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
				}

			}
		});
	}
	
	/** 开启或者关闭popwindow */
	public void popShow(int id) {
		View view = findViewById(id);
		if (pop.isShowing()) {
			pop.dismiss();
		} else {
//			/** 显示在view的左下角 */
//			pop.showAsDropDown(view);
			pop.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);
		}
	}



}
