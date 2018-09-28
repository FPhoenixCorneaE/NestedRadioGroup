# RadioGroup
可以实现任意嵌套RadioButton的RadioGroup
==========================

-------------------

![图片预览](https://github.com/FPhoenixCorneaE/RadioGroup/blob/master/preview/preview.jpg)

----------------------

```
<com.wkz.radiogroup.RadioGroup
    android:id="@+id/rg_recharge"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="15dp">

    <RelativeLayout
        android:id="@+id/rl_recharge_alipay"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@drawable/shape_background_white_cornersfive">

        <ImageView
            android:layout_width="22dp"
            android:layout_height="22dp"
            android:layout_centerVertical="true"
            android:layout_marginLeft="15dp"
            android:src="@mipmap/ic_recharge_alipay"
            tools:ignore="ContentDescription,RtlHardcoded" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_marginLeft="53dp"
            android:text="支付宝支付"
            android:textColor="@android:color/black"
            android:textSize="14sp"
            tools:ignore="HardcodedText,RtlHardcoded" />

        <RadioButton
            android:id="@+id/rb_recharge_alipay"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentRight="true"
            android:layout_alignParentTop="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            android:checked="true"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/rl_recharge_wechat"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="10dp"
        android:background="@drawable/shape_background_white_cornersfive">

        <ImageView
            android:layout_width="22dp"
            android:layout_height="22dp"
            android:layout_centerVertical="true"
            android:layout_marginLeft="15dp"
            android:src="@mipmap/ic_recharge_wechat"
            tools:ignore="ContentDescription,RtlHardcoded" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_marginLeft="53dp"
            android:text="微信支付"
            android:textColor="@android:color/black"
            android:textSize="14sp"
            tools:ignore="HardcodedText,RtlHardcoded" />

        <RadioButton
            android:id="@+id/rb_recharge_wechat"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentRight="true"
            android:layout_alignParentTop="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>
</com.wkz.radiogroup.RadioGroup>
```
-------------------
```
Item选中变化监听，须实现RadioGroup.OnCheckedChangeListener

mRgStarNote.setOnCheckedChangeListener(this);
mRgRecharge.setOnCheckedChangeListener(this);
```
---------------------

```
@Override
public void onCheckedChanged(RadioGroup group, int checkedId) {
    if (group == mRgStarNote) {//充值数量
        
    } else if (group == mRgRecharge) {//支付方式

    }
}
```

