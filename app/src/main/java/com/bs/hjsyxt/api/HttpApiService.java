package com.bs.hjsyxt.api;


import com.bs.hjsyxt.bean.Product;
import com.bs.hjsyxt.bean.ProductInfo;
import com.bs.hjsyxt.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wf on 2017/5/5.
 */

public interface HttpApiService {

    /**
     * 消费者登陆
     * @param username
     * @param password
     * @return
     */
    @GET("/boolshop/index.php/Home/User/login_c")
    Observable<User> loginCUser(@Query("name") String username, @Query("psw") String password);

    /**
     * 经销商登陆
     * @param username
     * @param password
     * @return
     */
    @GET("/boolshop/index.php/Home/User/login_j")
    Observable<User> loginIUser(@Query("name") String username, @Query("psw") String password);


    @GET("/boolshop/index.php/Home/Product/getProducturl")
    Observable<ProductInfo> getProductDetail(@Query("id") String id);

    @GET("boolshop/index.php/Home/Product/insertChain")
    Observable<ProductInfo> putSupplyChain(@Query("pro_id") String id,@Query("chain") String chain);


}
