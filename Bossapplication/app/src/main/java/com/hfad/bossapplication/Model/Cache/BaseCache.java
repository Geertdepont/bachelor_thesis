package com.hfad.bossapplication.Model.Cache;


import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hfad.bossapplication.Model.Entity.CachedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCache {

    private static final String TAG = "BaseCache";

    protected Gson gson;

    private File cacheFile;

    public BaseCache(Context context, String cacheFileName) {
        cacheFile = new File(context.getCacheDir(), cacheFileName);
        gson = new Gson();
    }

    protected List<CachedData> getCachedDataList() {
        List<CachedData> cachedDataList = new ArrayList<>();

        String json = readCacheFile();
        if (!TextUtils.isEmpty(json)) {
            Type listType = new TypeToken<ArrayList<CachedData>>() {
            }.getType();
            cachedDataList = new Gson().fromJson(json, listType);
        }
        return cachedDataList;
    }

    protected CachedData find(String id) {
        CachedData foundCachedData = null;
        CachedData searchCachedData = new CachedData(id);

        List<CachedData> cachedDataList = getCachedDataList();
        for (CachedData cd : cachedDataList) {
            if (searchCachedData.id.equals(cd.id)) {
                foundCachedData = cd;
                break;
            }
        }
        return foundCachedData;
    }

    protected void save(CachedData cachedData) {
        boolean found = false;
        List<CachedData> cachedDataList = getCachedDataList();
        for (CachedData cd : cachedDataList) {
            if (cachedData.id.equals(cd.id)) {
                cd.saveResponse(cachedData.responseJson);
                found = true;
                break;
            }
        }
        if (!found) {
            cachedDataList.add(cachedData);
        }
        saveCacheFile(new Gson().toJson(cachedDataList));
    }

    private String readCacheFile() {
        String fileContent = null;
        int length = (int) cacheFile.length();
        if (length > 0) {
            try {
                byte[] bytes = new byte[length];
                FileInputStream in = new FileInputStream(cacheFile);
                in.read(bytes);
                in.close();
                fileContent = new String(bytes);
            } catch (IOException e) {
                System.out.println("Error reading cache file");
            }
        }
        return fileContent;
    }

    private void saveCacheFile(String fileContent) {
        try {
            FileOutputStream stream = new FileOutputStream(cacheFile);
            stream.write(fileContent.getBytes());
            stream.close();
        } catch (IOException e) {
            System.out.println("Error saving cache file");
        }
    }
}
