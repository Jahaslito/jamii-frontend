package com.tabibu.desktop.data;

import com.tabibu.desktop.TabibuApplication;

public interface BaseRepository<T> {
    TabibuApiService apiService = TabibuApplication.getApiService();
}
