package com.example.testapk.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapk.MainActivity;
import com.example.testapk.R;

public class ClickFunActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private MainActivity mClickFunActivity;
	private Button mClickMeButton;
	private TextView mInfoTextView;
	
	private ClickFunActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(true);
		
		mClickFunActivity = getActivity();
		
		mClickMeButton = (Button) mClickFunActivity.findViewById(R.id.send_button);
		mInfoTextView = (TextView)mClickFunActivity.findViewById(R.id.my_first_test_text_view);
	}
	
	@MediumTest
	public void testClickMeButton_layout() {
		final View decorView = mClickFunActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mClickMeButton);
		
		final ViewGroup.LayoutParams layoutParams = mClickMeButton.getLayoutParams();
		assertNotNull(layoutParams);
		assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
		assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}

}
