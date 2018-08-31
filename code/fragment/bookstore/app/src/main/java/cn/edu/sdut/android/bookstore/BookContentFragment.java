package cn.edu.sdut.android.bookstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_book_content,container,false);
        return view;
    }


    public void refresh(Book book){
        view.setVisibility(View.VISIBLE);
        TextView bookTitle = view.findViewById(R.id.book_title);
        TextView bookDesc = view.findViewById(R.id.book_desc);
        bookTitle.setText(book.getTitle());
        bookDesc.setText(book.getDesc());
    }

}
