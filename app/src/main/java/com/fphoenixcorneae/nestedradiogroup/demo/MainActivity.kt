package com.fphoenixcorneae.nestedradiogroup.demo

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fphoenixcorneae.nestedradiogroup.demo.databinding.ActivityMainBinding
import com.fphoenixcorneae.radiogroup.NestedRadioGroup
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, NestedRadioGroup.OnCheckedChangeListener, TextWatcher {

    private var mViewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding!!.root)
        initListener()
    }

    private fun initListener() {
        mViewBinding?.apply {
            mRlRechargeMore.setOnClickListener(this@MainActivity)
            mRgStarNote.setOnCheckedChangeListener(this@MainActivity)
            mRgRecharge.setOnCheckedChangeListener(this@MainActivity)
            mEtStarNoteAtWill.addTextChangedListener(this@MainActivity)
        }
    }

    override fun onClick(v: View) {
        mViewBinding?.apply {
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
    }

    override fun onCheckedChanged(group: NestedRadioGroup?, checkedId: Int) {
        mViewBinding?.apply {
            when (group) {
                mRgStarNote -> {
                    //充值数量
                    when (checkedId) {
                        mRbStarNoteAtWill.id -> {
                            mTvStarNoteAtWill.visibility = View.GONE
                            mLlStarNoteAtWill.visibility = View.VISIBLE
                            mEtStarNoteAtWill.setSelection(mEtStarNoteAtWill.text.length)
                            KeyboardUtils.showSoftInput(this@MainActivity, mEtStarNoteAtWill)
                            when {
                                TextUtils.isEmpty(mEtStarNoteAtWill.text) -> {
                                    mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 0)
                                }
                                else -> {
                                    mTvRechargeImmediately.text =
                                        String.format(Locale.getDefault(), "立即支付%s元", mEtStarNoteAtWill.text.toString())
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
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        mViewBinding?.apply {
            if (View.GONE == mEtStarNoteAtWill.visibility) {
                return
            }
            if (TextUtils.isEmpty(s)) {
                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%d元", 0)
            } else {
                mTvRechargeImmediately.text = String.format(Locale.getDefault(), "立即支付%s元", s.toString())
            }
        }
    }

    override fun afterTextChanged(s: Editable) {}
}