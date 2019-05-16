package com.hfad.bookapplication.mvp.booklist;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.bookapplication.R;
import com.hfad.bookapplication.model.Book;
import com.hfad.bookapplication.model.SimulateBookClient;

import java.util.List;

public class BookListActivity extends AppCompatActivity implements BooksListContract.View {

    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private SwipeRefreshLayout swipeLayout;
    private BooksListContract.Presenter presenter;
    private TextView tv_empty_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        presenter = new BookPresenter(BookListActivity.this, new SimulateBookClient());
        recyclerView = (RecyclerView) findViewById(R.id.books_recycler_list);
        tv_empty_msg = (TextView) findViewById(R.id.swipe_msg_tv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        booksAdapter = new BooksAdapter(this);
        recyclerView.setAdapter(booksAdapter);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(listener);
        swipeLayout.setColorSchemeColors(
                ContextCompat.getColor(BookListActivity.this, R.color.colorPrimary),
                ContextCompat.getColor(BookListActivity.this, R.color.colorAccent),
                ContextCompat.getColor(BookListActivity.this, android.R.color.holo_green_light)
        );
    }

    private final SwipeRefreshLayout.OnRefreshListener listener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.loadBookList();
        }
    };

    @Override
    public void showProgress() {
        swipeLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeLayout.setRefreshing(false);
    }

    private void showORHideListView(boolean flag) {
        if (flag) {
            tv_empty_msg.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            tv_empty_msg.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showBookList(List<Book> books) {
        if (!books.isEmpty()) {
            booksAdapter.setList(books);
            showORHideListView(true);
        }
    }

    @Override
    public void showLoadingError(String errMsg) {
        hideProgressAndShowErr(errMsg);
        showORHideListView(false);
    }

    private void hideProgressAndShowErr(String msg) {
        tv_empty_msg.setVisibility(View.VISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        showORHideListView(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}