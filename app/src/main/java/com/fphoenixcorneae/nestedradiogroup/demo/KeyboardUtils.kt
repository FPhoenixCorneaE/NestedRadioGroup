package com.fphoenixcorneae.nestedradiogroup.demo

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * 键盘相关工具类
 */
class KeyboardUtils private constructor() {
    companion object {
        /*
      避免输入法面板遮挡
      <p>在manifest.xml中activity中设置</p>
      <p>android:windowSoftInputMode="adjustPan"</p>
     */
        /**
         * 动态隐藏软键盘
         *
         * @param activity activity
         */
        fun hideSoftInput(activity: Activity) {
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        /**
         * 动态隐藏软键盘
         *
         * @param context 上下文
         * @param view    视图
         */
        fun hideSoftInput(context: Context, view: View) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        /**
         * 点击屏幕空白区域隐藏软键盘
         *
         * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
         *
         * 需重写dispatchTouchEvent
         *
         * 参照以下注释代码
         */
        fun clickBlankArea2HideSoftInput() {
            Log.d("tips", "U should copy the following code.")
            /*
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (isShouldHideKeyboard(v, ev)) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
        private boolean isShouldHideKeyboard(View v, MotionEvent event) {
            if (v != null && (v instanceof EditText)) {
                int[] l = {0, 0};
                v.getLocationInWindow(l);
                int left = l[0],
                        top = l[1],
                        bottom = top + v.getHeight(),
                        right = left + v.getWidth();
                return !(event.getX() > left && event.getX() < right
                        && event.getY() > top && event.getY() < bottom);
            }
            return false;
        }
        */
        }

        /**
         * 动态显示软键盘
         *
         * @param edit 输入框
         */
        fun showSoftInput(context: Context, edit: EditText?) {
            edit!!.isFocusable = true
            edit.isFocusableInTouchMode = true
            edit.requestFocus()
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            imm.showSoftInput(edit, 0)
        }

        /**
         * 切换键盘显示与否状态
         */
        fun toggleSoftInput(context: Context) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    ?: return
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        /**
         * EditText获取焦点并显示软键盘
         */
        fun showSoftInputFromWindow(activity: Activity, editText: EditText) {
            editText.isFocusable = true
            editText.isFocusableInTouchMode = true
            editText.requestFocus()
            if (activity.window != null) {
                activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            }
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}