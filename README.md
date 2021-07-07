# NestedRadioGroup
可以任意嵌套RadioButton实现单选框的约束布局
================================================

[![](https://jitpack.io/v/FPhoenixCorneaE/NestedRadioGroup.svg)](https://jitpack.io/#FPhoenixCorneaE/NestedRadioGroup)

-------------------

![图片预览](https://github.com/FPhoenixCorneaE/RadioGroup/blob/master/preview/preview.webp)

----------------------

How to include it in your project:
--------------
**Step 1.** Add the JitPack repository to your build file
```kotlin
allprojects {
	repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
	}
}
```

**Step 2.** Add the dependency
```kotlin
dependencies {
	implementation("com.github.FPhoenixCorneaE:NestedRadioGroup:$latest")
}
```

xml中使用
--------------------------------

```xml
<com.fphoenixcorneae.radiogroup.NestedRadioGroup
    android:id="@+id/mRgRecharge"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="15dp">

    <RadioButton
        android:id="@+id/mRbCustom1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_margin="5dp"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="RtlHardcoded" />

    <RadioButton
        android:id="@+id/mRbCustom2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_margin="5dp"
        app:layout_constraintStart_toEndOf="@id/mRbCustom1"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="RtlHardcoded" />

    <RadioButton
        android:id="@+id/mRbCustom3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_margin="5dp"
        app:layout_constraintStart_toEndOf="@id/mRbCustom2"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="RtlHardcoded" />

    <RelativeLayout
        android:id="@+id/mRlRechargeAlipay"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@drawable/shape_background_white_cornersfive"
        app:layout_constraintBottom_toTopOf="@+id/mRlRechargeWechat"
        app:layout_constraintTop_toBottomOf="@id/mRbCustom1"
        app:layout_constraintVertical_chainStyle="packed">

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
            android:id="@+id/mRbRechargeAlipay"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            android:checked="true"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/mRlRechargeWechat"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="10dp"
        android:background="@drawable/shape_background_white_cornersfive"
        app:layout_constraintBottom_toTopOf="@+id/mRlRechargeUnion"
        app:layout_constraintTop_toBottomOf="@+id/mRlRechargeAlipay">

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
            android:id="@+id/mRbRechargeWechat"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/mRlRechargeUnion"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="10dp"
        android:background="@drawable/shape_background_white_cornersfive"
        android:visibility="gone"
        app:layout_constraintTop_toBottomOf="@+id/mRlRechargeWechat"
        tools:visibility="visible">

        <ImageView
            android:layout_width="22dp"
            android:layout_height="22dp"
            android:layout_centerVertical="true"
            android:layout_marginLeft="15dp"
            android:src="@mipmap/ic_recharge_union"
            tools:ignore="ContentDescription,RtlHardcoded" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_marginLeft="53dp"
            android:text="银联支付"
            android:textColor="@android:color/black"
            android:textSize="14sp"
            tools:ignore="HardcodedText,RtlHardcoded" />

        <RadioButton
            android:id="@+id/mRbRechargeUnion"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/mRlRechargeQq"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginTop="10dp"
        android:background="@drawable/shape_background_white_cornersfive"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/mRlRechargeUnion"
        tools:visibility="visible">

        <ImageView
            android:layout_width="22dp"
            android:layout_height="22dp"
            android:layout_centerVertical="true"
            android:layout_marginLeft="15dp"
            android:src="@mipmap/ic_recharge_qq"
            tools:ignore="ContentDescription,RtlHardcoded" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_marginLeft="53dp"
            android:text="QQ支付"
            android:textColor="@android:color/black"
            android:textSize="14sp"
            tools:ignore="HardcodedText,RtlHardcoded" />

        <RadioButton
            android:id="@+id/mRbRechargeQq"
            android:layout_width="12dp"
            android:layout_height="12dp"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_margin="5dp"
            android:background="@drawable/selector_background_radiobutton_star_note_recharge_way"
            android:button="@null"
            tools:ignore="RtlHardcoded" />
    </RelativeLayout>
</com.fphoenixcorneae.radiogroup.NestedRadioGroup>
```
-------------------

Item选中变化监听，须实现 NestedRadioGroup.OnCheckedChangeListener
----------------------------------------------------------
```kotlin
mRgStarNote.setOnCheckedChangeListener(this)
mRgRecharge.setOnCheckedChangeListener(this)
```
---------------------

```kotlin
override fun onCheckedChanged(group: NestedRadioGroup?, checkedId: Int) {
    when (group) {
            mRgStarNote -> {
                //充值数量

            }
            mRgRecharge -> {
                //支付方式

            }
        }
}
```

