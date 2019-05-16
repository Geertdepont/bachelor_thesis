package com.hfad.bookapplication.mvp.booklist;

import com.hfad.bookapplication.model.Book;

import java.util.List;

public interface BooksListContract {

    interface View {
        void showProgress();

        void hideProgress();

        void showBookList(List<Book> books);

        void showLoadingError(String errMsg);
    }

    interface Presenter{
        void loadBookList();

        void dropView();
    }

    interface OnResponseCallback{
        void onResponse(List<Book> books);

        void onError(String errMsg);
    }
}