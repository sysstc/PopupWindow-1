package com.example.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class CommonPopupWindow extends PopupWindow {
	private View mMenuView;

	public CommonPopupWindow(Context context, OnClickListener listener) {
		super();
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.pop_collection, null);
		LinearLayout linear_add_collect = (LinearLayout) mMenuView
				.findViewById(R.id.linear_add_collect);
		LinearLayout linear_comment = (LinearLayout) mMenuView
				.findViewById(R.id.linear_comment);
		LinearLayout linear_zan = (LinearLayout) mMenuView
				.findViewById(R.id.linear_zan);
		linear_add_collect.setOnClickListener(listener);
		linear_comment.setOnClickListener(listener);
		linear_zan.setOnClickListener(listener);

		ImageView imgExit = (ImageView) mMenuView.findViewById(R.id.img_exit);
		// 取消按钮
		imgExit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 销毁弹出框
				dismiss();
			}
		});
		/** 初始化按钮并监听 */

		// 设置SelectPicPopupWindow的View
		this.setContentView(mMenuView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.MATCH_PARENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.AnimBottom);
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// 设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);
		// mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
		mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});
	}

}
