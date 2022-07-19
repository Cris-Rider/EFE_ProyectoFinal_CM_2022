package com.example.efe_proyectofinal_cm_2022;

import com.example.efe_proyectofinal_cm_2022.clases.Headlines;

import java.util.List;

public interface OnFetchDataListener<ApiResponse> {
    void onFetchData(List<Headlines> list, String message);

    void onFetchData(List<Headlines> list, String message);

    void onError(String message);
}
