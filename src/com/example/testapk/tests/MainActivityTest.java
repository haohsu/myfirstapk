package com.example.testapk.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.testapk.MainActivity;
import com.example.testapk.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private MainActivity mMainActivity;
	private TextView mFirstTestText;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mMainActivity = getActivity();
		mFirstTestText = (TextView) mMainActivity.findViewById(R.id.my_first_test_text_view);
	}
	
	public void testPrecondition() {
		assertNotNull("mMainActivity is null", mMainActivity);
		assertNotNull("mFirstTestText is null", mFirstTestText);
	}
	
	public void testMyFirstTestText_labelText() {
		final String expected = mMainActivity.getString(R.string.my_first_test);
		final String actual = mFirstTestText.getText().toString();
		assertEquals("mFirstTestText contains wrong text", expected, actual);
	}
	
}
