package ru.bruimafia.rx.screen.images;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.bruimafia.rx.R;
import ru.bruimafia.rx.adapter.ImageAdapter;
import ru.bruimafia.rx.pojo.Image;

public class ImagesListActivity extends AppCompatActivity implements ImagesListContract {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.progressBarHor)
    ProgressBar progressBarHor;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ImagesListPresenter presenter = new ImagesListPresenter(this);
    private ImageAdapter adapter = new ImageAdapter(this);

    private String order = "popular";
    private String query = "";
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        adapter.setImages(new ArrayList<>());
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);
        adapter.setOnReachEndListener(() -> {
            progressBarHor.setVisibility(View.VISIBLE);
            presenter.loadData(query, order, page);
        });

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        swipeRefreshLayout.setOnRefreshListener(() -> {
            page = 1;
            presenter.loadData(query, order, page);
        });

        presenter.loadData(query, order, page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String q) {
                query = q;
                page = 1;
                progressBar.setVisibility(View.VISIBLE);
                presenter.loadData(query, order, page);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                query = newText;
                page = 1;
                progressBar.setVisibility(View.VISIBLE);
                presenter.loadData(query, order, page);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            switch (order) {
                case "popular": order = "latest"; page = 1; break;
                case "latest": order = "popular"; page = 1; break;
            }
            presenter.loadData(query, order, page);
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showData(List<Image> images) {
        adapter.setImages(images);
        recycler.smoothScrollToPosition(0);
        page++;
        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, "order: " + order, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadedData(List<Image> images) {
        adapter.addImages(images);
        page++;
        progressBarHor.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
