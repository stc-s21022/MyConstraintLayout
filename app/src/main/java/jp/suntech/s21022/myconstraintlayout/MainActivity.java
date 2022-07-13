package jp.suntech.s21022.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.btSend);
        BtListener listener = new BtListener();
        btSend.setOnClickListener(listener);

        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    private class BtListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String msg ="";
            EditText inName = findViewById(R.id.etName);
            EditText inMail = findViewById(R.id.etMail);
            EditText inMailTitle = findViewById(R.id.etMailTitle);
            EditText inComment = findViewById(R.id.etComment);

            int id = view.getId();

            switch (id){
                case R.id.btConfirm:
                    //注文確認ダイアログフラグメントオブジェクトを生成。
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    //ダイアログ表示。
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    //break;

                case R.id.btSend:
                    msg = ("名前:" + inName.getText().toString() + "\nタイトル:" + inMailTitle.getText().toString() + "\nメールアドレス:" + inMail.getText().toString() + "\n質問内容:" + inComment.getText().toString());
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                    break;

                case R.id.btClear:
                    inName.setText("");
                    inMail.setText("");
                    inMailTitle.setText("");
                    inComment.setText("");

            }
        }
    }

}