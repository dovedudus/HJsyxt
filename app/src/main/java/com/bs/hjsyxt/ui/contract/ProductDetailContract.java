package com.bs.hjsyxt.ui.contract;

import com.bs.hjsyxt.base.BaseContract;
import com.bs.hjsyxt.bean.ProductInfo;

/**
 * Created by wf on 2017/5/25.
 */

public interface ProductDetailContract {

    interface View extends BaseContract.BaseView {
        void showProductDetail(ProductInfo data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{

        void getProductDetail(String id);
    }
}
