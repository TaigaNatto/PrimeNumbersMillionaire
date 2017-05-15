package com.example.taiga.primenumbersmillionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.text);

    }

    public void result(View v) {
        ArrayList<String> list = new ArrayList<>();
        String textData = editText.getText().toString();
        for (int i = 0; i < textData.length(); i++) {
            list.add(textData.substring(i, i + 1));
        }
        textView.setText(getSosuuResult(list));
    }

    public String getSosuuResult(ArrayList<String> list) {
        for (int size = list.size(); size > 0; size--) {//全体の桁数をだんだん減らしていく

            ArrayList<String> tempList = list;//tempListを更新して逐次判定していく

            for (int i = size; i > 0; i--) {//変える軸のループ

                for (int j = 0; j < tempList.size(); j++) {

                    //数値化+判定
                    String num = "";
                    for (int judge = 0; judge < tempList.size(); judge++) {
                        num = num + tempList.get(i);
                    }
                    if (sosuuJudge(Integer.parseInt(num))) {
                        return num + "は素数です";
                    }

                }

                //removeでけせぇ！
            }
        }
        return "ありません";
    }

    //素数であるか否かのメソッド
    public boolean sosuuJudge(int num) {
        if (num > 1) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public ArrayList<String> listReplace(ArrayList<String> list, int pos1, int pos2) {
        String temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
        return list;
    }
}
