package com.example.fuxiangzhang.base_framwork.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.fuxiangzhang.base_framwork.utils.LoginDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPersenter> implements MainContract.View,LoginDialogFragment.LoginInputLister {


    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;
    @BindView(R.id.btn_dialog)
    Button mBtnDialog;


    private EditText usename;
    private EditText password;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_confirm, R.id.btn_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                getPresenter().submitData();
                Log.e(TAG, "onViewClicked: ");
                break;
            case R.id.btn_dialog:
                showLoginDialog();

                break;
        }
    }
    
    public void showLoginDialog(){
        LoginDialogFragment mLoginDialogFragment =new LoginDialogFragment();
        mLoginDialogFragment.show(getFragmentManager(),"login");
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password, Toast.LENGTH_SHORT).show();
    }
}
