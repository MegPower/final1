package com.power.finalexam_1;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//checks if preference changed
	private boolean preferencesChanged = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		
		//set default values in SharedPreferences
//		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
		//register listener for SharedPreferences changes
//		PreferenceManager.getDefaultSharedPreferences(this).
	//		registerOnSharedPreferenceChangeListener(preferenceChangeListener);
		
		if (preferencesChanged)
		{
			//initialize QuizFragment and start quiz
			QuizFragment quizFragment = (QuizFragment)
					getFragmentManager().findFragmentById(R.id.quizFragment);
			quizFragment.loadNextQuestion();
			preferencesChanged = false;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
