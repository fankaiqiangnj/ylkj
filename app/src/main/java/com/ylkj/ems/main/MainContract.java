package com.ylkj.ems.main;

import com.ylkj.ems.base.MvpPresenter;
import com.ylkj.ems.base.MvpView;

public class MainContract {
    public interface IMainView extends MvpView {
        /**
         * 测试
         */
        void setTestContent(String str);
    }

    public interface IMainPresenter extends MvpPresenter<IMainView> {
        /**
         * 测试
         */
        void requestTestContent();
    }
}
