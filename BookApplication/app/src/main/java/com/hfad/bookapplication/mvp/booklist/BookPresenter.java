package com.hfad.bookapplication.mvp.booklist;

import com.hfad.bookapplication.model.Book;
import com.hfad.bookapplication.model.BookRepository;
import com.hfad.bookapplication.util.EspressoTestingIdlingResource;

import java.util.List;

public final class BookPresenter implements BooksListContract.Presenter  {

    private BooksListContract.View view;

    private BookRepository mclient;

    public BookPresenter(BooksListContract.View view,BookRepository client) {
        this.view = view;

        mclient = client;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void loadBookList() {
        view.showProgress();

        mclient.getBookList(callback);

        EspressoTestingIdlingResource.increment();
    }

    private final BooksListContract.OnResponseCallback callback = new BooksListContract.OnResponseCallback() {
        @Override
        public void onResponse(List<Book> books) {
            view.showBookList(books);
            view.hideProgress();
            EspressoTestingIdlingResource.decrement();
        }

        @Override
        public void onError(String errMsg) {
            view.hideProgress();
            view.showLoadingError(errMsg);
            EspressoTestingIdlingResource.decrement();
        }
    };
}