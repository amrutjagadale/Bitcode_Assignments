package com.example.assignment2_customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextEditorDialog extends Dialog {

    public interface OnTextEditedListener {
        void onTextEdited(String editedText);
    }

    private String initialText;
    private OnTextEditedListener listener;

    public TextEditorDialog(Context context, String initialText, OnTextEditedListener listener) {
        super(context);
        this.initialText = initialText;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_text_editor);

        EditText editText = findViewById(R.id.editText);
        editText.setText(initialText);

        Button btnUpperCase = findViewById(R.id.btnUpperCase);
        Button btnLowerCase = findViewById(R.id.btnLowerCase);
        Button btnInitCap = findViewById(R.id.btnInitCap);
        Button btnReverse = findViewById(R.id.btnReverse);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnUpperCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString().toUpperCase());
            }
        });

        btnLowerCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString().toLowerCase());
            }
        });

        btnInitCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(toInitCap(editText.getText().toString()));
            }
        });

        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(new StringBuilder(editText.getText().toString()).reverse().toString());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTextEdited(editText.getText().toString());
                }
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private String toInitCap(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}

