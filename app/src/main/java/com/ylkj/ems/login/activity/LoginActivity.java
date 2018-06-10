package com.ylkj.ems.login.activity;

import com.ylkj.ems.base.BaseMvpActivity;
import com.ylkj.ems.login.contract.LoginContract;
import com.ylkj.ems.login.presenter.LoginPresenter;

public class LoginActivity extends BaseMvpActivity<LoginContract.ILoginPresenter> implements LoginContract.ILoginView {
    @Override
    protected LoginContract.ILoginPresenter createPresenter() {
        return new LoginPresenter();
    }
}
