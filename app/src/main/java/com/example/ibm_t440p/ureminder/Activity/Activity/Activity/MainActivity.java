package com.example.ibm_t440p.ureminder.Activity.Activity.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.CustomerOrder;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.ui.MapFragment;
import com.example.ibm_t440p.ureminder.Activity.Activity.retrofit.OrderService;
import com.example.ibm_t440p.ureminder.Activity.Activity.retrofit.RetrofitService;
import com.example.ibm_t440p.ureminder.R;
import java.lang.annotation.Annotation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    replaceFragment(MapFragment.newInstance());

    OrderService orderService= RetrofitService.getInstance().getRetrofitDongTienServer().create(OrderService.class);
    Call<CustomerOrder> customerOrderCall =orderService.getAllCustomersOrder();
    customerOrderCall.enqueue(new Callback<CustomerOrder>() {
      @Override
      public void onResponse(Call<CustomerOrder> call, Response<CustomerOrder> response) {

      }

      @Override
      public void onFailure(Call<CustomerOrder> call, Throwable t) {

      }
    });

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


    } else if (id == R.id.notif) {

    } else if (id == R.id.history) {

    } else if (id == R.id.logout) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }


}
