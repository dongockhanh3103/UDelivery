package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home;

import android.Manifest;
import android.Manifest.permission;
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

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.constant.SavedCache;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.IHome.Presenter;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.model.ShipperInfo;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.login.LoginActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.module.GPSTracker;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.OrderListActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.ui.MapFragment;
import com.example.ibm_t440p.ureminder.Activity.Activity.utils.DialogNotif;
import com.example.ibm_t440p.ureminder.Activity.Activity.utils.SampleErrorListener;
import com.example.ibm_t440p.ureminder.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.util.List;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener,IHome.View {

  DialogNotif dialogNotif;
  HomePresenter mPresenter;
  TextView tvShipperName;
  TextView tvShipperPhone;
  NavigationView navigationView;
  ImageView btnNotification;
  private MultiplePermissionsListener allPermissionsListener;
  private MultiplePermissionsListener all1PermissionsListener;
  private PermissionRequestErrorListener errorListener;
  private boolean isAllGrantedPermission = false;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    btnNotification = findViewById(R.id.btn_notification);
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
    GPSTracker gpsTracker=new GPSTracker(getApplicationContext());

/*    Toast.makeText(getApplicationContext(), ("address" + gpsTracker.getLocation().getLatitude()+ gpsTracker.getLocation().getLongitude()),
        Toast.LENGTH_SHORT).show();*/


    btnNotification.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, OrderListActivity.class));
        finish();

      }
    });

    navigationView=findViewById(R.id.nav_view);


    all1PermissionsListener = new MultiplePermissionsListener() {

      @Override
      public void onPermissionsChecked(MultiplePermissionsReport report) {
        if (report.getDeniedPermissionResponses() != null) {
          if (report.getDeniedPermissionResponses().size() > 0) {
            isAllGrantedPermission = false;
          }
        }
        if (report.getGrantedPermissionResponses() != null) {
          if (report.getGrantedPermissionResponses().size() == 3) {
            isAllGrantedPermission = true;
          }
        }
      }

      @Override
      public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions,
          PermissionToken token) {
        permissions.size();
      }
    };
    errorListener =     new SampleErrorListener();

    allPermissionsListener = new CompositeMultiplePermissionsListener(
        all1PermissionsListener);

    Dexter.withActivity(this)
        .withPermissions(permission.ACCESS_FINE_LOCATION)
        .withListener(allPermissionsListener)
        .withErrorListener(errorListener)
        .check();

    replaceFragment(MapFragment.newInstance());
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
   // getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
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
      SavedCache.getInstance().setIsLogin(false);
      SavedCache.getInstance().setShipperToken("");
      startActivity(new Intent(this, LoginActivity.class));
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
