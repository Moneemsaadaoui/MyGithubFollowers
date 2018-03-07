package rrdl.netapp.Utils;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import io.reactivex.*;
import retrofit2.CallAdapter;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rrdl.netapp.Models.GithubUser;
import rrdl.netapp.Models.GithubUserInfo;

/*
 * Created by moneem on 05/03/18.
 */public interface GithubService {

    @GET("users/{username}/followers")
    Observable<List<GithubUser>> getFollowing(@Path("username") String username);

    @GET("/users/{username}")
    Observable<GithubUserInfo> getUserInfos(@Path("username") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}