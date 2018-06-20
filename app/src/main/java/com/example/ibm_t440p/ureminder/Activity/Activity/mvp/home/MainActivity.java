package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;
import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.IHome.Presenter;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.model.ShipperInfo;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.OrderListActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.ui.MapFragment;
import com.example.ibm_t440p.ureminder.Activity.Activity.utils.DialogNotif;
import com.example.ibm_t440p.ureminder.R;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener,IHome.View {

  DialogNotif dialogNotif;
  HomePresenter mPresenter;
  TextView tvShipperName;
  TextView tvShipperPhone;
  NavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    dialogNotif=new DialogNotif(MainActivity.this);
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();
    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    replaceFragment(MapFragment.newInstance());

    navigationView=findViewById(R.id.nav_view);
    tvShipperName=navigationView.getHeaderView(0).findViewById(R.id.tvShipperName);
    tvShipperPhone=navigationView.getHeaderView(0).findViewById(R.id.tvShipperPhone);
    getPresenter().getShipperInfo();

  }



  public void replaceFragment(Fragment fragment) {

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.fragment, fragment, fragment.getClass().getSimpleName());
    ft.commit();
  }


  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_dangnhap) {
      return true;
    } else if (id == R.id.action_dangki) {
      return true;
    } else if (id == R.id.action_gioithieu) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.home) {
      // Handle the camera action
    } else if (id == R.id.contract) {
      startActivity(new Intent(this, OrderListActivity.class));


    } else if (id == R.id.notif) {

    } else if (id == R.id.history) {

    } else if (id == R.id.logout) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }


  @Override
  public void setPresenter(Presenter presenter) {
    mPresenter= (HomePresenter) presenter;

  }

  @Override
  public void onShowLoadingProgress(boolean isShow) {
    onShowProgressBar(isShow);
  }

  @Override
  public void onGetShipperInfoSuccess(ShipperInfo shipper) {
    tvShipperPhone.setText(tvShipperPhone.getText()+shipper.getPhoneNum());
    tvShipperName.setText(tvShipperName.getText()+shipper.getFullname());

  }

  @Override
  public void onGetShipperInfoFailure(String msg) {
    dialogNotif.showBasicDismissDialog("Errors",msg);

  }

  private IHome.Presenter getPresenter() {
    if (mPresenter == null) {
      mPresenter = new HomePresenter(this);
    }
    return mPresenter;
  }
}
