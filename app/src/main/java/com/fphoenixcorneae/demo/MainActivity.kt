package com.fphoenixcorneae.demo

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fphoenixcorneae.radiogroup.NestedRadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, NestedRadioGroup.OnCheckedChangeListener, TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        mRlRechargeMore.setOnClickListener(this)
        mRgStarNote.setOnCheckedChangeListener(this)
        mRgRecharge.setOnCheckedChangeListener(this)
        mEtStarNoteAtWill.addTextChangedListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            mRlRechargeMore -> {
                mRlRechargeUnion.visibility = View.VISIBLE
                mRlRechargeQq.visibility = View.VISIBLE
                mRlRechargeMore.visibility = View.GONE
            }
            else -> {
            }
        }
    }

    override fun onCheckedChanged(group: NestedRadioGroup?, checkedId: Int) {
        when (group) {
            mRgStarNote -> {
                //充值数量
                when (checkedId) {
                    mRbStarNoteAtWill.id -> {
                        mTvStarNoteAtWill.visibility = View.GONE
                        mLlStarNoteAtWill.visibility = View.VISIBLE
                        mEtStarNoteAtWill.setSelection(mEtStarNoteAtWill.text.length)
                        KeyboardUtils.showSoftInput(this, mEtStarNoteAtWill)
                        when {
                            TextUtils.isEmpty(mEtStarNoteAtWill.text) -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 0)
                            }
                            else -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%s元", mEtStarNoteAtWill.text.toString())
                            }
                        }
                    }
                    else -> {
                        mTvStarNoteAtWill.visibility = View.VISIBLE
                        mLlStarNoteAtWill.visibility = View.GONE
                        when (checkedId) {
                            mRbStarNote100.id -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 100)
                            }
                            mRbStarNote500.id -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 500)
                            }
                            mRbStarNote1000.id -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 1000)
                            }
                            mRbStarNote5000.id -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 5000)
                            }
                            mRbStarNote10000.id -> {
                                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 10000)
                            }
                        }
                    }
                }
            }
            mRgRecharge -> {
                //支付方式
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (View.GONE == mEtStarNoteAtWill.visibility) {
            return
        }
        if (TextUtils.isEmpty(s)) {
            mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 0)
        } else {
            mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%s元", s.toString())
        }
    }

    override fun afterTextChanged(s: Editable) {}
}