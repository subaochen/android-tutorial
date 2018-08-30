package cn.edu.sdut.android.bookstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_list,container,false);
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
                viewHolder.bookId.setText(book.getId());
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
