package com.example.sid.datastorage_112;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mProduct;
    Button btnSave,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProduct = (EditText) findViewById(R.id.etProductEntry);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mProduct.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this," Enter Product Name ",Toast.LENGTH_SHORT).show();

                else{
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    long id = dbHelper.saveProduct(mProduct.getText().toString());
                    if(id==-1)
                    {
                        Toast.makeText(MainActivity.this,"Error..!!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Product Added..!!",Toast.LENGTH_SHORT).show();
                        mProduct.getText().clear();
                    }
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launching new acitivty for product search
                Intent intent = new Intent(MainActivity.this,SearchProduct.class);
                startActivity(intent);
            }
        });
    }
}
