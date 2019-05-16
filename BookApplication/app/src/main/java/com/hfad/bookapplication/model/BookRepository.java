package com.hfad.bookapplication.model;

import com.hfad.bookapplication.mvp.booklist.BooksListContract;

public interface BookRepository {

    void getBookList(BooksListContract.OnResponseCallback callback);
}
