# NestedRadioGroup
可以任意嵌套RadioButton实现单选框的约束布局
================================================

-------------------

![图片预览](https://github.com/FPhoenixCorneaE/RadioGroup/blob/master/preview/preview.webp)

----------------------

How to include it in your project:
--------------
**Step 1.** Add the JitPack repository to your build file
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add the dependency
```groovy
dependencies {
	implementation 'com.github.FPhoenixCorneaE:NestedRadioGroup:1.0.0'
}
```

xml中使用
--------------------------------

```xml
<com.fphoenixcorneae.radiogroup.NestedRadioGroup
                android:id="@+id/mRgStarNote"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <RelativeLayout
                    android:id="@+id/mRlStarNote100"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintBottom_toTopOf="@+id/mRlStarNote5000"
                    app:layout_constraintEnd_toStartOf="@+id/mRlStarNote500"
                    app:layout_constraintHorizontal_chainStyle="packed"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintVertical_chainStyle="packed">

                    <RadioButton
                        android:id="@+id/mRbStarNote100"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        android:checked="true"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="25dp"
                        android:text="100星币"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="45dp"
                        android:text="￥100"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="12sp"
                        tools:ignore="HardcodedText" />
                </RelativeLayout>

                <RelativeLayout
                    android:id="@+id/mRlStarNote500"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintEnd_toStartOf="@+id/mRlStarNote1000"
                    app:layout_constraintStart_toEndOf="@+id/mRlStarNote100"
                    app:layout_constraintTop_toTopOf="parent">

                    <RadioButton
                        android:id="@+id/mRbStarNote500"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="25dp"
                        android:text="500星币"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="45dp"
                        android:text="￥500"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="12sp"
                        tools:ignore="HardcodedText" />
                </RelativeLayout>

                <RelativeLayout
                    android:id="@+id/mRlStarNote1000"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:layout_marginEnd="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toEndOf="@+id/mRlStarNote500"
                    app:layout_constraintTop_toTopOf="parent">

                    <RadioButton
                        android:id="@+id/mRbStarNote1000"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="25dp"
                        android:text="1000星币"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="45dp"
                        android:text="￥1000"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="12sp"
                        tools:ignore="HardcodedText" />
                </RelativeLayout>

                <RelativeLayout
                    android:id="@+id/mRlStarNote5000"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:layout_marginTop="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintEnd_toStartOf="@+id/mRlStarNote10000"
                    app:layout_constraintHorizontal_chainStyle="packed"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/mRlStarNote100">

                    <RadioButton
                        android:id="@+id/mRbStarNote5000"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="25dp"
                        android:text="5000星币"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="45dp"
                        android:text="￥5000"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="12sp"
                        tools:ignore="HardcodedText" />
                </RelativeLayout>

                <RelativeLayout
                    android:id="@+id/mRlStarNote10000"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintEnd_toStartOf="@+id/mRlStarNoteAtWill"
                    app:layout_constraintStart_toEndOf="@+id/mRlStarNote5000"
                    app:layout_constraintTop_toTopOf="@+id/mRlStarNote5000">

                    <RadioButton
                        android:id="@+id/mRbStarNote10000"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="25dp"
                        android:text="10000星币"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:layout_marginTop="45dp"
                        android:text="￥10000"
                        android:textColor="@color/selector_normalblack_selectedwhite"
                        android:textSize="12sp"
                        tools:ignore="HardcodedText" />
                </RelativeLayout>

                <RelativeLayout
                    android:id="@+id/mRlStarNoteAtWill"
                    android:layout_width="0dp"
                    android:layout_height="80dp"
                    android:layout_marginStart="15dp"
                    android:layout_marginEnd="15dp"
                    android:background="@drawable/selector_background_star_note_recharge"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toEndOf="@+id/mRlStarNote10000"
                    app:layout_constraintTop_toTopOf="@+id/mRlStarNote5000">

                    <RadioButton
                        android:id="@+id/mRbStarNoteAtWill"
                        android:layout_width="12dp"
                        android:layout_height="12dp"
                        android:layout_alignParentTop="true"
                        android:layout_alignParentRight="true"
                        android:layout_margin="5dp"
                        android:background="@drawable/selector_background_radiobutton_star_note_count"
                        android:button="@null"
                        tools:ignore="RtlHardcoded" />

                    <TextView
                        android:id="@+id/mTvStarNoteAtWill"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerInParent="true"
                        android:text="其他金额"
                        android:textColor="#ff505050"
                        android:textSize="13sp"
                        tools:ignore="HardcodedText" />

                    <LinearLayout
                        android:id="@+id/mLlStarNoteAtWill"
                        android:layout_width="match_parent"
                        android:layout_height="40dp"
                        android:layout_centerInParent="true"
                        android:layout_margin="5dp"
                        android:gravity="center_vertical|end"
                        android:orientation="horizontal"
                        android:visibility="gone">

                        <EditText
                            android:id="@+id/mEtStarNoteAtWill"
                            android:layout_width="0dp"
                            android:layout_height="match_parent"
                            android:layout_weight="1"
                            android:background="@null"
                            android:gravity="end|center_vertical"
                            android:inputType="numberDecimal"
                            android:maxLength="32"
                            android:textColor="@android:color/white"
                            android:textCursorDrawable="@drawable/shape_cursor_white"
                            android:textSize="12sp"
                            tools:ignore="Autofill,HardcodedText,LabelFor" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="星币"
                            android:textColor="@android:color/white"
                            android:textSize="13sp"
                            tools:ignore="HardcodedText" />
                    </LinearLayout>
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

