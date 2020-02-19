package com.tabibu.desktop.common;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;

public interface BaseRepository<T> {
    TabibuApiService apiService = TabibuApplication.getApiService();
}
