package ru.bruimafia.rx.screen.images;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.bruimafia.rx.api.ApiFactory;
import ru.bruimafia.rx.api.ApiService;

public class ImagesListPresenter {

    private Disposable disposable;
    private ImagesListContract view;

    public ImagesListPresenter(ImagesListContract view) {
        this.view = view;
    }

    public void loadData(String q, String order, int page) {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        disposable = apiService.getImages(q, order, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        imagesResponse -> {
                            if (page <= 1)
                                view.showData(imagesResponse.getImages());
                            else
                                view.showLoadedData(imagesResponse.getImages());
                        },
                        throwable -> view.showError(throwable.getMessage())
                );
    }

    public void onDestroy() {
        if (disposable != null)
            disposable.dispose();
    }

}
