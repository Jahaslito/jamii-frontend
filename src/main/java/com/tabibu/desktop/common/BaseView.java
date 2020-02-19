package com.tabibu.desktop.common;

public interface BaseView {
    void showLoadingUI();

    void hideLoadingUI();

    void showErrorMessage(String message);
}
