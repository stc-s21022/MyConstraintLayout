package jp.suntech.s21022.myconstraintlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //ダイアログビルダーを生成。
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定。
        builder.setTitle(R.string.msg_title);
        //ダイアログのメッセージを設定。
        builder.setMessage(R.string.msg_message);
        //Positive Buttonを設定。
        builder.setPositiveButton(R.string.msg_ok,new DialogButtonClickListener());
        //Negative Buttonを設定。
        builder.setNegativeButton(R.string.msg_ng,new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン。
        AlertDialog dialog = builder.create();
        return dialog;
    }
    //ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス。
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            //トーストメッセージ用文字列変数を用意。
            String msg = "";
            //タップされたアクションボタンで分岐。
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = getString(R.string.msg_ok_toast);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.msg_ng_toast);
                    break;
            }
            //トーストの表示。
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
