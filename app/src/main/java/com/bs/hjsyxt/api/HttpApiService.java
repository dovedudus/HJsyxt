package com.bs.hjsyxt.api;


import com.bs.hjsyxt.bean.Recommend;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wf on 2017/5/5.
 */

public interface HttpApiService {

    @GET("/book/recommend")
    Observable<Recommend> getRecomend(@Query("gender") String gender);
}
