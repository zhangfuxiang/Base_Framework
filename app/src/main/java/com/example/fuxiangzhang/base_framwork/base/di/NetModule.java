package com.example.fuxiangzhang.base_framwork.base.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import com.example.fuxiangzhang.base_framwork.utils.RequestIntercept;
import com.example.fuxiangzhang.base_framwork.utils.ZipHelper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static com.example.fuxiangzhang.base_framwork.utils.CharactorHandler.jsonFormat;

/**
 * Created by 10109 on 2017/7/19.
 */
@Module
public class NetModule {

    public static final int TIME_OUT=10;
    public static final int CACHE_MAX_SIZE=10*1024*1024;//缓存文件最大值10mb
    private String mBaseUrl;

    public NetModule(String mBaseUrl){
        this.mBaseUrl=mBaseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharePreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideCache(File cacheFile){
        return new Cache(cacheFile,CACHE_MAX_SIZE);
    }

    @Provides
    @Singleton
    File provideCacheFile(Application application){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File file=null;
            file =application.getExternalCacheDir();//获取系统管理的sd卡缓存文件
            if (file==null){
                file=new File(getCachcheFilePath(application));
                if (!file.exists()){
                    file.mkdir();
                }
            }
            return file;
        }else {
            return application.getCacheDir();
        }
    }

    //自定义缓存文件地址
    private String getCachcheFilePath(Context context) {
        String packageName=context.getPackageName();
        return "/mnt/sdcard/"+packageName;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Interceptor provideIntercept(Context mContext){
        return new RequestIntercept();//打印请求信息的拦截器
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.cache(cache)
                .addNetworkInterceptor(new RequestIntercept())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT,TimeUnit.SECONDS)
                .build();

    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

}
