package cn.edu.sdut.android.bookstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.book_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        BookAdapter bookAdapter = new BookAdapter(getBooks());
        recyclerView.setAdapter(bookAdapter);
        return view;
    }

    private List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            Book book = new Book(i,"book title" + i, getRandomBookDesc("book desc" + i));
            list.add(book);
        }
        return list;
    }

    private String getRandomBookDesc(String s) {
        Random random = new Random(20);
        int length = random.nextInt();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(s);
        }

        return builder.toString();
    }

    class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
        private List<Book> bookList;

        public BookAdapter(List<Book> list) {
            bookList = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.book_item,viewGroup,false);
            final ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
            public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
                Book book = bookList.get(i);
                viewHolder.bookId.setText(String.valueOf(book.getId()));
                viewHolder.bookTitle.setText(book.getTitle());
            }

        @Override
        public int getItemCount() {
            return bookList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView bookId;
            private TextView bookTitle;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                bookId = (TextView)itemView.findViewById(R.id.book_id);
                bookTitle = (TextView)itemView.findViewById(R.id.book_titile);
            }
        }
    }

}
