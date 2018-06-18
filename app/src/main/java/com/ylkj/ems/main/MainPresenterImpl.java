package com.ylkj.ems.main;

import com.ylkj.ems.base.mvp.BaseMvpPresenter;

public class MainPresenterImpl extends BaseMvpPresenter<MainContract.IMainView> implements MainContract.IMainPresenter {
    @Override
    public void requestTestContent() {
        if (isViewAttached()){
            getView().setTestContent("hellow kail");
        }
    }

}
