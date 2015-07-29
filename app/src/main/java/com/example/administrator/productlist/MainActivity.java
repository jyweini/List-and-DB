package com.example.administrator.productlist;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView mTvName;
    private TextView mTvPrice;
    private ImageView mTvAdd;
    private ProductDao mProductDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProductDao = new ProductDao(this);
        mTvName= (TextView) findViewById(R.id.nameET);
        mTvPrice= (TextView) findViewById(R.id.balanceET);
        mTvAdd= (ImageView) findViewById(R.id.addIV);
        mTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName=mTvName.getText().toString().trim();
                Integer productPrice=Integer.parseInt(mTvPrice.getText().toString().trim());
             Product product=new Product(productName,productPrice);
                mProductDao.insertProduct(product);
            }
        });
    }


}
