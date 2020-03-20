package ru.bruimafia.rx.screen.images;

import java.util.List;

import ru.bruimafia.rx.pojo.Image;

public interface ImagesListContract {
    void showData(List<Image> images);
    void showLoadedData(List<Image> images);
    void showError(String msg);
}
