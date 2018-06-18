package com.ylkj.ems.login.contract;

import com.ylkj.ems.base.mvp.MvpPresenter;
import com.ylkj.ems.base.mvp.MvpView;

public class LoginContract {
    public interface ILoginView extends MvpView {

    }
   public interface ILoginPresenter extends MvpPresenter<ILoginView>{

    }
}
