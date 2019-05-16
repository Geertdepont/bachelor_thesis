package com.hfad.bookapplication.model;

import android.os.Handler;

import com.hfad.bookapplication.model.Book;
import com.hfad.bookapplication.model.BookRepository;
import com.hfad.bookapplication.mvp.booklist.BooksListContract;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;


public final class SimulateBookClient implements BookRepository {

    static final Random RANDOM = new Random();

    public void getBookList(final BooksListContract.OnResponseCallback callback)  {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                ArrayList<Book> books = new ArrayList<>();
                books.add(new Book("Harry Potter","J.K. Rowling", "Bloomsburry", "Fiction", 8.0));
                books.add(new Book("Dolfje weerwolfje","Paul van loon", "Leopold", "Fiction", 7.3));
                callback.onResponse(books);
            }
        }, 1500);



    }
}
