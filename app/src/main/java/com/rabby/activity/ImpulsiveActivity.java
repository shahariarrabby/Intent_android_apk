package com.rabby.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ImpulsiveActivity extends AppCompatActivity {
    TextView textView2;
    EditText editText2;
    private final String TEXT_CONTENTS = "TEXT_CONTENTS";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.impulsive_main);
        textView2 = (TextView) findViewById(R.id.textView);
        editText2 = (EditText) findViewById(R.id.editText2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Extra_message);
        editText2.setText(message);
        textView2.setText(message);
    }

    public void goSite(View view) {
        String url = editText2.getText().toString();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT_CONTENTS, editText2.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String saveString = savedInstanceState.getString(TEXT_CONTENTS);
        editText2.setText(saveString);
        textView2.setText(saveString);
    }
}
