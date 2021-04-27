package com.myapp.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    private MaterialButton emailBtn;
    private TextInputEditText messageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        initViews();



    } // <-- end of main method -->

    private void initViews() {
        emailBtn = findViewById(R.id.email_button);
        messageET = findViewById(R.id.message_edit_text);
        emailBtn.setOnClickListener(this::onClick);
    }

    // View is clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_button:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                String[] emailAddresses = {"jason_lim@rp.edu.sg"};
                String subject = "Test Email from C347";
                String text = messageET.getText() + "";
                String type = "message/rfc822";

                emailIntent
                        .putExtra(Intent.EXTRA_EMAIL, emailAddresses)
                        .putExtra(Intent.EXTRA_SUBJECT, subject)
                        .putExtra(Intent.EXTRA_TEXT, text)
                        .setType(type);

                startActivity(Intent.createChooser(emailIntent, "Create Email using"));

                break;
        }
    }
}