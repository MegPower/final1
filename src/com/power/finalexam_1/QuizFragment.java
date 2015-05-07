package com.power.finalexam_1;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizFragment extends Fragment {
	
	int correctAns = 0;
	
	int q1sub, q2sub, q3sub;
	int rand1, rand1a, rand2, rand2a, rand3, rand3a;
	
	private TextView ques1TextView, ques2textView, ques3textView, resultsTextView;
	
	private ImageView imageView1, imageView2, imageView3;
	
	//configures QuizFragment when view is created
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_quiz, container, false);
		
		EditText q1editText = (EditText) view.findViewById(R.id.q1editText);
		q1editText.addTextChangedListener(q1editTextWatcher);	
		
		EditText q2editText = (EditText) view.findViewById(R.id.q2editText);
		q2editText.addTextChangedListener(q2editTextWatcher);	
		
		EditText q3editText = (EditText) view.findViewById(R.id.q3editText);
		q3editText.addTextChangedListener(q3editTextWatcher);	

		ques1TextView = (TextView) view.findViewById(R.id.ques1TextView);
		ques2textView = (TextView) view.findViewById(R.id.ques2textView);
		ques3textView = (TextView) view.findViewById(R.id.ques3textView);
		resultsTextView = (TextView) view.findViewById(R.id.resultsTextView);
		
		Button submitButton = (Button) view.findViewById(R.id.submitButton);
		submitButton.setOnClickListener(submitButtonListener);
		Button resetButton = (Button) view.findViewById(R.id.resetButton);
		resetButton.setOnClickListener(resetButtonListener);
		
		return view;
	}
	
	void loadNextQuestion()
	{
		//make stars invisible
//		imageView1.setVisibility(View.GONE);
	//	imageView2.setVisibility(View.GONE);
		//imageView3.setVisibility(View.GONE);

		//find rand #'s for q's
		int min = 0;
		int max = 20;

		Random r = new Random();
		int rand1 = r.nextInt(max - min + 1) + min;
		int rand1a = r.nextInt(max - min + 1) + min;
		int rand2 = r.nextInt(max - min + 1) + min;
		int rand2a = r.nextInt(max - min + 1) + min;
		int rand3 = r.nextInt(max - min + 1) + min;
		int rand3a = r.nextInt(max - min + 1) + min;
		
		//set text views for questions
		String q1 = rand1 + " + " + rand1a + " = ";
		ques1TextView.setText(q1);
		String q2 = rand2 + " - " + rand2a + " = ";
		ques2textView.setText(q2);
		String q3 = rand3 + " * " + rand3a + " = ";
		ques3textView.setText(q3);
		
	}
	
	private OnClickListener submitButtonListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			//get correct answers
			int q1a = rand1 + rand1a;
			int q2a = rand2 - rand2a;
			int q3a = rand3 * rand3a;
			
			//check to see if submitted ans match solutions
			if (q1a == q1sub)
				correctAns = correctAns + 1;
			if(q2a == q2sub)
				correctAns = correctAns + 2;
			if(q3a == q3sub)
				correctAns = correctAns + 3;
		
			//set results string
			resultsTextView.setText(getString(R.string.results, correctAns));
			
			//display stars
			if(correctAns == 1)
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);
				imageView3.setVisibility(View.GONE);
			if(correctAns == 2)
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.VISIBLE);
				imageView3.setVisibility(View.GONE);
			if(correctAns == 2)
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.VISIBLE);
				imageView3.setVisibility(View.VISIBLE);
		}
	};
	
	private OnClickListener resetButtonListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			loadNextQuestion();
		}
	};

	
	private TextWatcher q1editTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			//cast s as an int
			q1sub = Integer.parseInt(s.toString());
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};

	private TextWatcher q2editTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			//cast s as an int
			q2sub = Integer.parseInt(s.toString());
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private TextWatcher q3editTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			//cast s as an int
			q3sub = Integer.parseInt(s.toString());
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
