package com.ylkj.ems.home.contract;

import com.ylkj.ems.base.mvp.MvpPresenter;
import com.ylkj.ems.base.mvp.MvpView;

public class HomeContract {
    public interface IHomeView extends MvpView {

    }
    public interface IHomePresenter extends MvpPresenter<IHomeView> {

    }
}
