package com.hfad.bookapplication.mvp.booklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.bookapplication.R;
import com.hfad.bookapplication.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {

    private final Context context;
    private final List<Book> bookStrings = new ArrayList<>();
    private static final String TAG = "BooksAdapter";

    public BooksAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_model,parent,false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, final int position) {
        Log.e(TAG, "onBindViewHolder: "+position);

        holder.bookTitle.setText(bookStrings.get(position).getTitle());
        holder.genre.setText(bookStrings.get(position).getGenre());
        holder.rating.setText(Double.toString(bookStrings.get(position).getRating()));
        holder.booksLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, bookStrings.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setList(List<Book> list){
        bookStrings.clear();
        bookStrings.addAll(list);
        notifyDataSetChanged();
        Log.e(TAG, "onNext: "+bookStrings.size() );
    }


    @Override
    public int getItemCount() {
        return bookStrings.size();
    }

    public static class BookHolder extends RecyclerView.ViewHolder {
        TextView bookTitle;
        TextView genre;
        TextView view;
        TextView rating;
        LinearLayout booksLayout;

        public BookHolder(View v) {
            super(v);
            booksLayout = (LinearLayout) v.findViewById(R.id.books_layout);
            bookTitle = (TextView) v.findViewById(R.id.title);
            genre = (TextView) v.findViewById(R.id.genre);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

}