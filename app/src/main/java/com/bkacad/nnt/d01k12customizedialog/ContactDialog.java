package com.bkacad.nnt.d01k12customizedialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public abstract class ContactDialog extends Dialog {

    private EditText edtInput;
    private Button btnYes, btnNo;

    public ContactDialog(@NonNull Context context) {
        super(context);
    }

    protected abstract void sendData(String data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_dialog);
        setCancelable(false);

        // Bind id
        edtInput = findViewById(R.id.edtDialogContact);
        btnYes = findViewById(R.id.btnDialogYes);
        btnNo = findViewById(R.id.btnDialogNo);
        // Đăng kí sự kiện onClick cho button
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy nội dung trong edittext
                String input = edtInput.getText().toString();
                if (input.isEmpty()) {
                    edtInput.setError("Hãy nhập dữ liệu");
                    return;
                }
                // Gửi dữ liệu về MainActivity ???
                sendData(input);
                edtInput.setText("");
                dismiss();
            }
        });

    }
}
