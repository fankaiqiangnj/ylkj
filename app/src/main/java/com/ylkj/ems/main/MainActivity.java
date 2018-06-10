package com.ylkj.ems.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ylkj.ems.R;
import com.ylkj.ems.base.BaseMvpActivity;
import com.ylkj.ems.util.EditDialog;
import com.ylkj.ems.util.UrlUtil;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainContract.IMainPresenter> implements MainContract.IMainView {
    @BindView(R.id.main_text)
    TextView tVmain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected MainContract.IMainPresenter createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        presenter.requestTestContent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            EditDialog dialog = new EditDialog(this, new EditDialog.CallBack() {
                @Override
                public void dialogCarllBack(String s) {
                }
            });
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTestContent(String str) {
        tVmain.setText(str);

    }
}
