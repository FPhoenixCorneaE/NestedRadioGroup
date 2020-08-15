package com.fphoenixcorneae.demo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fphoenixcorneae.radiogroup.NestedRadioGroup;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NestedRadioGroup.OnCheckedChangeListener, TextWatcher {

    private AppCompatImageView mIvLeft;
    private LinearLayout mLlLeft;
    /**
     * 星币充值
     */
    private TextView mTvTitle;
    private RelativeLayout mRlTitleBar;
    private RadioButton mRbStarNote100;
    private RadioButton mRbStarNote500;
    private RadioButton mRbStarNote1000;
    private RadioButton mRbStarNote5000;
    private RadioButton mRbStarNote10000;
    private RadioButton mRbStarNoteAtWill;
    /**
     * 其他金额
     */
    private TextView mTvStarNoteAtWill;
    private EditText mEtStarNoteAtWill;
    private LinearLayout mLlStarNoteAtWill;
    private NestedRadioGroup mRgStarNote;
    private RadioButton mRbRechargeAlipay;
    private RelativeLayout mRlRechargeAlipay;
    private RadioButton mRbRechargeWechat;
    private RelativeLayout mRlRechargeWechat;
    private RadioButton mRbRechargeUnion;
    private RelativeLayout mRlRechargeUnion;
    private RadioButton mRbRechargeQq;
    private RelativeLayout mRlRechargeQq;
    private NestedRadioGroup mRgRecharge;
    private RelativeLayout mRlRechargeMore;
    private ImageView mIvArrowDiscount;
    /**
     * 1个可用
     */
    private TextView mTvUsableDiscount;
    private RelativeLayout mRlDiscount;
    /**
     * 立即支付100元
     */
    private TextView mTvRechargeImmediately;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        mIvLeft = findViewById(R.id.iv_left);
        mLlLeft = findViewById(R.id.ll_left);
        mTvTitle = findViewById(R.id.tv_title);
        mRlTitleBar = findViewById(R.id.rl_title_bar);
        mRbStarNote100 = findViewById(R.id.rb_star_note_100);
        mRbStarNote500 = findViewById(R.id.rb_star_note_500);
        mRbStarNote1000 = findViewById(R.id.rb_star_note_1000);
        mRbStarNote5000 = findViewById(R.id.rb_star_note_5000);
        mRbStarNote10000 = findViewById(R.id.rb_star_note_10000);
        mRbStarNoteAtWill = findViewById(R.id.rb_star_note_at_will);
        mTvStarNoteAtWill = findViewById(R.id.tv_star_note_at_will);
        mEtStarNoteAtWill = findViewById(R.id.et_star_note_at_will);
        mLlStarNoteAtWill = findViewById(R.id.ll_star_note_at_will);
        mRgStarNote = findViewById(R.id.rg_star_note);
        mRbRechargeAlipay = findViewById(R.id.rb_recharge_alipay);
        mRlRechargeAlipay = findViewById(R.id.rl_recharge_alipay);
        mRbRechargeWechat = findViewById(R.id.rb_recharge_wechat);
        mRlRechargeWechat = findViewById(R.id.rl_recharge_wechat);
        mRbRechargeUnion = findViewById(R.id.rb_recharge_union);
        mRlRechargeUnion = findViewById(R.id.rl_recharge_union);
        mRbRechargeQq = findViewById(R.id.rb_recharge_qq);
        mRlRechargeQq = findViewById(R.id.rl_recharge_qq);
        mRgRecharge = findViewById(R.id.rg_recharge);
        mRlRechargeMore = findViewById(R.id.rl_recharge_more);
        mIvArrowDiscount = findViewById(R.id.iv_arrow_discount);
        mTvUsableDiscount = findViewById(R.id.tv_usable_discount);
        mRlDiscount = findViewById(R.id.rl_discount);
        mTvRechargeImmediately = findViewById(R.id.tv_recharge_immediately);
    }

    private void initListener() {
        mRlRechargeMore.setOnClickListener(this);
        mRgStarNote.setOnCheckedChangeListener(this);
        mRgRecharge.setOnCheckedChangeListener(this);
        mEtStarNoteAtWill.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_recharge_more:
                mRlRechargeUnion.setVisibility(View.VISIBLE);
                mRlRechargeQq.setVisibility(View.VISIBLE);
                mRlRechargeMore.setVisibility(View.GONE);
            break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(NestedRadioGroup group, int checkedId) {
        if (group == mRgStarNote) {
            //充值数量
            if (checkedId == mRbStarNoteAtWill.getId()) {
                mTvStarNoteAtWill.setVisibility(View.GONE);
                mLlStarNoteAtWill.setVisibility(View.VISIBLE);
                mEtStarNoteAtWill.setSelection(mEtStarNoteAtWill.getText().length());
                KeyboardUtils.showSoftInput(this,mEtStarNoteAtWill);
                if (TextUtils.isEmpty(mEtStarNoteAtWill.getText())) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 0));
                } else {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%s元", mEtStarNoteAtWill.getText().toString()));
                }
            } else {
                mTvStarNoteAtWill.setVisibility(View.VISIBLE);
                mLlStarNoteAtWill.setVisibility(View.GONE);
                if (checkedId == mRbStarNote100.getId()) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 100));
                } else if (checkedId == mRbStarNote500.getId()) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 500));
                } else if (checkedId == mRbStarNote1000.getId()) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 1000));
                } else if (checkedId == mRbStarNote5000.getId()) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 5000));
                } else if (checkedId == mRbStarNote10000.getId()) {
                    mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 10000));
                }
            }
        } else if (group == mRgRecharge) {
            //支付方式

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (View.GONE == mEtStarNoteAtWill.getVisibility()) {
            return;
        }
        if (TextUtils.isEmpty(s)) {
            mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%d元", 0));
        } else {
            mTvRechargeImmediately.setText(String.format(Locale.getDefault(), "立即支付%s元", s.toString()));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
