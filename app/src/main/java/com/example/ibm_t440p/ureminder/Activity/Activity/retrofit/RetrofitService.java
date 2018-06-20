package com.example.ibm_t440p.ureminder.Activity.Activity.retrofit;

import com.example.ibm_t440p.ureminder.Activity.Activity.config.Constants;
import com.example.ibm_t440p.ureminder.Activity.Activity.constant.SavedCache;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ngoc Khanh on 6/3/2018.
 */

public class RetrofitService {
  private static RetrofitService instance;
  private RetrofitService() {
    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
        .client(getOkHttpClient())
        .baseUrl(Constants.UGAO_END_POINT)
        .build();
  }
  public static synchronized RetrofitService getInstance() {
    if (instance == null) {
      instance = new RetrofitService();
    }
    return instance;
  }

  public Retrofit getRetrofitUGaoServer() {
    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
        .client(getOkHttpClient())
        .baseUrl(Constants.UGAO_END_POINT)
        .build();
    return retrofit;
  }


  private OkHttpClient getOkHttpClient() {
    Interceptor customInterceptor = new Interceptor() {
      @Override
      public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().build();
        Response response = chain.proceed(request);
        // Error from server
        if (response.code() != 200) {
          Response.Builder builder = response.newBuilder();
          builder.code(200);  //handle by BaseResponse
          response = builder.build();
        }
        return response;
      }
    };
    HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
    logger.setLevel(HttpLoggingInterceptor.Level.BODY);

    final TrustManager[] trustAllCerts = new TrustManager[]{
        new X509TrustManager() {
          @Override
          public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
              String authType) throws CertificateException {
          }

          @Override
          public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
              String authType) throws CertificateException {
          }

          @Override
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
          }
        }
    };

    // Install the all-trusting trust manager
    final SSLContext sslContext;
    SSLSocketFactory sslSocketFactory = null;
    try {
      sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
      sslSocketFactory = sslContext.getSocketFactory();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    }

    // Create an ssl socket factory with our all-trusting manager

    return new OkHttpClient().newBuilder()
        .sslSocketFactory(sslSocketFactory)
        .hostnameVerifier(new HostnameVerifier() {
          @Override
          public boolean verify(String hostname, SSLSession session) {
            return true;
          }
        })
        .addInterceptor(customInterceptor)
        .addInterceptor(new AddingHeaderInterceptor())
        .addInterceptor(logger).build();
  }

  private Gson getGsonBuilder() {
    return new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .disableHtmlEscaping()
        .create();
  }


  private class AddingHeaderInterceptor implements Interceptor {



    @Override
    public Response intercept(Chain chain) throws IOException {
      Request originalRequest = chain.request();

      Request requestWithUserAgent = originalRequest.newBuilder()
          .header("token",SavedCache.getInstance().getAccessToken())
          .build();

      return chain.proceed(requestWithUserAgent);
    }
  }
}