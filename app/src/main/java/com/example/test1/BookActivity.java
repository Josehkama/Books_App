package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {


    ImageView mImage;
    TextView mTitle, mCategory, mDescription;
    Button mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Bundle extras = getIntent().getExtras();

        mImage = findViewById(R.id.cover_img);
        mTitle = findViewById(R.id.book_title);
        mCategory = findViewById(R.id.bookcategory);
        mDescription = findViewById(R.id.bookdescription);
        mHome = findViewById(R.id.btn_back);
    if(extras!= null){
        int coverImg = extras.getInt("Image");
        String title = extras.getString("Title");
        String category= extras.getString("Category");
        String description = extras.getString("Description");


        mTitle.setText(title);
        mCategory.setText(category);
        mDescription.setText(description);
        mImage.setImageResource(coverImg);

    }

    mHome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(BookActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    });




    }
}
