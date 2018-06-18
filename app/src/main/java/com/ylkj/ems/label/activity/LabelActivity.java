package com.ylkj.ems.label.activity;

import android.os.Bundle;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.label.contract.LabelContract;
import com.ylkj.ems.label.persenter.LabelPersenter;

public class LabelActivity extends BaseMvpActivity<LabelContract.ILabelPresenter>implements LabelContract.ILabelView{
    @Override
    protected LabelContract.ILabelPresenter createPresenter() {
        return new LabelPersenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_label;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isCustomPendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getCustomPendingTransitionType() {
        return TransitionMode.FADE;
    }

    @Override
    protected void initViewsAndEvents() {

    }
}
