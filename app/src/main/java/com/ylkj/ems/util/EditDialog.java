package com.ylkj.ems.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ylkj.ems.R;

import butterknife.BindView;


/**
 * Created by fan on 2018/4/15.
 */

public class EditDialog extends Dialog {
    Context mContext;
    @BindView(R.id.edit_ip)
    EditText edit_ip;
    @BindView(R.id.edit_prot)
    EditText edit_prot;
    @BindView(R.id.txt_btn_cancel)
    TextView txt_btn_cancel;
    @BindView(R.id.txt_btn_yes)
    TextView txt_btn_yes;

    CallBack dialogCallBack;

    public EditDialog(@NonNull Context context,CallBack callBack) {
        super(context, R.style.MyDialog);
        mContext = context;
        dialogCallBack = callBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_dialog);
        edit_ip.setText((String)SPUtils.get(mContext,"serviceIP",UrlUtil.ip));
        edit_prot.setText((String)SPUtils.get(mContext,"serviceProt",UrlUtil.prot));
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.txt_btn_cancel:
                        dismiss();
                        break;

                    case R.id.txt_btn_yes:
                        if (!TextUtils.isEmpty(edit_ip.getText().toString().trim())) {
                            SPUtils.put(mContext, "serviceIP", edit_ip.getText().toString().trim());
                            SPUtils.put(mContext, "serviceProt", edit_prot.getText().toString().trim());
                            dialogCallBack.dialogCarllBack("");
                            dismiss();
                        }else {
                            BaseUtil.showToast(mContext,"请输入服务器ip");
                        }

                        break;
                        default:
                            dismiss();
                            break;
                }
            }
        };
        txt_btn_cancel.setOnClickListener(clickListener);
        txt_btn_yes.setOnClickListener(clickListener);

    }
   public interface CallBack{
       void  dialogCarllBack(String s);
    }

}
