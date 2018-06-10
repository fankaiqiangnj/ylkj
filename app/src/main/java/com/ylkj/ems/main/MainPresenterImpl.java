package com.ylkj.ems.main;

import android.os.Bundle;

import com.ylkj.ems.base.BaseMvpPresenter;

public class MainPresenterImpl extends BaseMvpPresenter<MainContract.IMainView> implements MainContract.IMainPresenter {
    @Override
    public void requestTestContent() {
        getView().setTestContent("hellow kail");
    }

}
