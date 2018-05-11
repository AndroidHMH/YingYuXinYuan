package com.jiyun.yingyuxinyuan.ui.activity.my.gift.presenter;

import com.jiyun.yingyuxinyuan.contract.GiftContract;
import com.jiyun.yingyuxinyuan.model.biz.GiftService;

/**
 * Created by asus on 2018/5/11.
 */

public class GiftPresenter implements GiftContract.Presenter {
    private GiftContract.View view;
    GiftService giftService;

    @Override
    public void actualView(GiftContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadLiWu() {

    }

    @Override
    public void loadShouRu() {

    }
}
