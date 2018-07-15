package com.udelivery.zions.delivery.Activity.Activity.mvp.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import com.udelivery.zions.delivery.Activity.Activity.constant.SavedCache;
import com.udelivery.zions.delivery.Activity.Activity.mvp.home.MainActivity;
import com.udelivery.zions.delivery.Activity.Activity.base.BaseActivity;
import com.udelivery.zions.delivery.Activity.Activity.utils.DialogNotif;
import com.udelivery.zions.delivery.R;

public class LoginActivity extends BaseActivity implements  ILogin.View{
  Button btnEmail;
  AutoCompleteTextView edtUsername;
  EditText edtPassword;
  LoginPresenter mPresenter;
  DialogNotif dialogNotif;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    btnEmail= findViewById(R.id.email_sign_in_button);
    edtUsername = findViewById(R.id.email);
    edtPassword = findViewById(R.id.password);
    if(SavedCache.getInstance().isLogin()){
      startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
    dialogNotif=new DialogNotif(LoginActivity.this);
    btnEmail.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getPresenter().authenticationUser(edtUsername.getText().toString(),edtPassword.getText().toString());
      }
    });

  }

  @Override
  public void onShowLoadingProgress(boolean isShow) {
    onShowProgressBar(isShow);
  }

  @Override
  public void onLoginFail(String msg) {
    dialogNotif.showBasicDismissDialog("Login failure",msg);

  }

  @Override
  public void onLoginSuccess(String token) {
    SavedCache.getInstance().setShipperToken(token);
    SavedCache.getInstance().setIsLogin(true);
    startActivity(new Intent(LoginActivity.this,MainActivity.class));
    finish();
  }

  @Override
  public void setPresenter(ILogin.Presenter presenter) {
    mPresenter= (LoginPresenter) presenter;

  }

  private ILogin.Presenter getPresenter() {
    if (mPresenter == null) {
      mPresenter = new LoginPresenter(this);
    }
    return mPresenter;
  }
}
