package com.richluick.foode.api.di;

import com.richluick.foode.api.ElementApi;
import com.richluick.foode.di.scope.ApplicationScope;
import com.richluick.foode.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rluic on 2/28/2017.
 */
@Module
public class ApiModule {

    //todo: make configurable with interceptors if needed. Can use addInterceptors method. Could pass a list a loop through as well
    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        //todo: url needs updating
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    ElementApi provideElementApi(Retrofit retrofit) {
        return retrofit.create(ElementApi.class);
    }
}
