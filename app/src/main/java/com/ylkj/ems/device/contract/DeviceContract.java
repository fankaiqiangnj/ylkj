package com.ylkj.ems.device.contract;

import com.ylkj.ems.base.mvp.MvpPresenter;
import com.ylkj.ems.base.mvp.MvpView;

public class DeviceContract {
    public interface IDeviceView extends MvpView{

    }
    public interface IDevicePresenter extends MvpPresenter<IDeviceView>{

    }
}
