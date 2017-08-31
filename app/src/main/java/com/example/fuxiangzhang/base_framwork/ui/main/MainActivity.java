package com.example.fuxiangzhang.base_framwork.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuxiangzhang.base_framwork.R;
import com.example.fuxiangzhang.base_framwork.base.di.AppComponent;
import com.example.fuxiangzhang.base_framwork.base.mvp.BaseActivity;
import com.example.fuxiangzhang.base_framwork.entity.DouBan;
import com.example.fuxiangzhang.base_framwork.ui.main.di.DaggerMainComponent;
import com.example.fuxiangzhang.base_framwork.ui.main.di.MainModule;
import com.example.fuxiangzhang.base_framwork.ui.main.mvp.MainContract;
import com.example.fuxiangzhang.base_framwork.ui.main.mvp.MainPersenter;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPersenter> implements MainContract.View {


    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvContent.setText("显示内容");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    public void loginSucess(DouBan mDouBan) {
        mTvContent.setText(mDouBan.getTitle());

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        getPresenter().submitData();
        Log.e(TAG, "onViewClicked: " );
    }
}
