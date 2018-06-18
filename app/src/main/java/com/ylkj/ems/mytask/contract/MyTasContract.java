package com.ylkj.ems.mytask.contract;

import com.ylkj.ems.base.mvp.MvpPresenter;
import com.ylkj.ems.base.mvp.MvpView;

public class MyTasContract {
    public interface ITaskView extends MvpView{

    }
    public interface ITaskPresenter extends MvpPresenter<ITaskView>{

    }
}
