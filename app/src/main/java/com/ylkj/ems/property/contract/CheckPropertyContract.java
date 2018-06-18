package com.ylkj.ems.property.contract;

import com.ylkj.ems.base.mvp.MvpPresenter;
import com.ylkj.ems.base.mvp.MvpView;

public class CheckPropertyContract {
    public interface ICheckPropertyView extends MvpView{

    }

    public interface ICheckPropertyPresenter extends MvpPresenter<ICheckPropertyView>{

    }
}
