package ishiicai.shohoku.ac.jp.necesary_tech_textbox;

import android.os.Bundle;
import android.app.AlertDialog;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //変数 = (キャスト)findviewByid(使いたいウェジェットのid)
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString(); //EditText(テキストボックスから文字列を取得(LONG or SHORT)).show();
                if (!text.equals("")){
                    textView.setText(text); //textviewに文字列セット
                    editText.setText("");

                    //Toast.makeText(コンテキスト、表示させたい文字列、どのぐらい(時間)表示させたいか
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")  //タイトル
                            .setMessage(text)   //本文
                            .setPositiveButton("close", null)   //押したら閉じるボタンのようなテキスト
                            .show();
                }
                else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}