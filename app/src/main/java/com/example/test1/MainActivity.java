package com.example.test1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.adapters.BooksAdapter;
import com.example.test1.models.Books;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Books> mBooks = new ArrayList<>();
    private BooksAdapter mAdapter;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mRecyclerView = findViewById(R.id.recycler_view);
mBooks.add(new Books("Hallo Point","Thriller","Soft",R.drawable.mariasemples));
        mBooks.add(new Books("Resident ","Horror","Hollow",R.drawable.themartian));
        mBooks.add(new Books("Lucifer ","Thriller","HotStuff",R.drawable.thevigitarian));
        mBooks.add(new Books("Terminator ","Sci-fi","Goods",R.drawable.hediedwith));
        mBooks.add(new Books("Pointy","Drama","Soft",R.drawable.mariasemples));
        mBooks.add(new Books("Complicated","Drama","luxurious",R.drawable.thewildrobot));
        mBooks.add(new Books("Punch","Animation","action stuff",R.drawable.thevigitarian));
        mBooks.add(new Books("Come","Horror","Scary",R.drawable.thewildrobot));
        mBooks.add(new Books("Breaking","Documentary","Sleep mode",R.drawable.themartian));
        mBooks.add(new Books("Future","Documentary","Discovery World",R.drawable.thevigitarian));
        mBooks.add(new Books("Cool","Animation","Babies type",R.drawable.hediedwith));

mAdapter = new BooksAdapter(mBooks, this);
mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
mRecyclerView.setAdapter(mAdapter);

    }
}
