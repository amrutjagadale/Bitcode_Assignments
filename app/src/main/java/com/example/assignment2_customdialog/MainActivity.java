package com.example.assignment2_customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements TextEditorDialog.OnTextEditedListener {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example usage
        findViewById(R.id.openDialogBtton).setOnClickListener(view -> {
        TextEditorDialog dialog = new TextEditorDialog(this, "Initial Text", this);
        dialog.show();
        });
        }

@Override
public void onTextEdited(String editedText) {
        // Handle the edited text
        Toast.makeText(this, "Edited Text: " + editedText, Toast.LENGTH_SHORT).show();
        }
        }