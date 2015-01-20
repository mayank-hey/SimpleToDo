package com.mchacko.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {
    int pos;
    EditText mlEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        mlEditTxt = (EditText) findViewById(R.id.mlEditTxt);
        String text = getIntent().getStringExtra("text");
        pos = getIntent().getIntExtra("pos", 0);
        mlEditTxt.setText(text);
        mlEditTxt.setSelection(mlEditTxt.getText().length());
        mlEditTxt.requestFocus();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View v) {
        Intent data = new Intent(EditItemActivity.this, MainActivity.class);
        data.putExtra("text", mlEditTxt.getText().toString());
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        this.finish();
    }
}
