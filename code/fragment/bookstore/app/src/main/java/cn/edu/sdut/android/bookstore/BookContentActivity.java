package cn.edu.sdut.android.bookstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BookContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_content);

        int bookId = Integer.parseInt(getIntent().getStringExtra("bookId"));
        String bookTitle = getIntent().getStringExtra("bookTitle");
        String bookDesc = getIntent().getStringExtra("bookDesc");
        BookContentFragment bookContentFragment = (BookContentFragment) getSupportFragmentManager().findFragmentById(R.id.book_content_fragment);
        bookContentFragment.refresh(new Book(bookId,bookTitle,bookDesc));
    }

    public static void actionStart(Context context, String bookId, String bookTitle, String bookDesc){
        Intent intent = new Intent(context,BookContentActivity.class);
        intent.putExtra("bookId",bookId);
        intent.putExtra("bookTitle",bookTitle);
        intent.putExtra("bookDesc",bookDesc);
        context.startActivity(intent);
    }
}
