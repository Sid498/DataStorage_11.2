package com.example.sid.datastorage_112;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class SearchProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        showProduct();
    }

    private void showProduct() {
        AutoCompleteTextView product = (AutoCompleteTextView) findViewById(R.id.SearchProduct);
        ArrayList<String> mProductLit = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.showProduct();

        while (cursor.moveToNext()) {
            mProductLit.add(cursor.getString(cursor.getColumnIndex("pname")));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mProductLit);
        product.setAdapter(arrayAdapter);
    }
}
