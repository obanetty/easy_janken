package sample.janken;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import sample.janken.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void jankenStart(View view){
		//STARTボタンの無効化
		Button startBtn = (Button)findViewById(R.id.button1);
		startBtn.setClickable(false);
		
		//コンピュータの手を隠す
		ImageView comImage = (ImageView)findViewById(R.id.imageView1);
		comImage.setVisibility(View.INVISIBLE);
		
		//グー・チョキ・パーボタンの有効化
		ImageButton gu = (ImageButton)findViewById(R.id.imageButton1);
		ImageButton choki = (ImageButton)findViewById(R.id.imageButton2);
		ImageButton pa = (ImageButton)findViewById(R.id.imageButton3);
		gu.setClickable(true);
		choki.setClickable(true);
		pa.setClickable(true);
		
		//文字表示変更
		TextView txt = (TextView)findViewById(R.id.textView1);
		txt.setText("ジャンケン");
	}
	
	public void jankenEnd(View view){
		//STARTボタンの有効化
		Button startBtn = (Button)findViewById(R.id.button1);
		startBtn.setClickable(true);
		
		//コンピュータの手を出す
		ImageView comImage = (ImageView)findViewById(R.id.imageView1);
		comImage.setVisibility(View.VISIBLE);
		
		//グー・チョキ・パーボタンの無効化
		ImageButton gu = (ImageButton)findViewById(R.id.imageButton1);
		ImageButton choki = (ImageButton)findViewById(R.id.imageButton2);
		ImageButton pa = (ImageButton)findViewById(R.id.imageButton3);
		gu.setClickable(false);
		choki.setClickable(false);
		pa.setClickable(false);
		
		//コンピュータの手を決定
		int com = (int)(Math.random() * 3);
		if(com == 0){
			//グー
			comImage.setImageResource(R.drawable.gu);
		}else if(com == 1){
			//チョキ
			comImage.setImageResource(R.drawable.choki);
		}else if(com == 2){
			//パー
			comImage.setImageResource(R.drawable.pa);
		}
		
		String result = "";
		if(view == gu){
			if(com == 0){
				result = "あいこ";
			}else if(com == 1){
				result = "勝ち";
			}else if(com == 2){
				result = "負け";
			}
		}else if(view == choki){
			if(com == 0){
				result = "負け";
			}else if(com == 1){
				result = "あいこ";
			}else if(com == 2){
				result = "勝ち";
			}
		}else if(view == pa){
			if(com == 0){
				result = "勝ち";
			}else if(com == 1){
				result = "負け";
			}else if(com == 2){
				result = "あいこ";
			}
		}
		
		//文字表示変更
		TextView txt = (TextView)findViewById(R.id.textView1);
		txt.setText(result);
	}
}
