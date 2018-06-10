package in.effcode.App.GraphQL;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import com.apollographql.apollo.ApolloClient;

import java.text.SimpleDateFormat;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/**
 * Created by Radhey on 28/5/18.
 * Author Radhey
 */

public class GraphQlConfig extends AppCompatActivity{

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat ISO8601 =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    private OkHttpClient ok = new OkHttpClient.Builder().
    certificatePinner(new CertificatePinner.Builder().
    add("graphql-demo.commonsware.com","sha256/3Zeb2W9lSpG9DrsLH03DRCxcu0j7BFyLVXcR7cZW9tQ=").
    build()).
    build();

    private ApolloClient apolloClient = ApolloClient.builder().
    okHttpClient(ok).
    serverUrl("https://graphql-demo.commonsware.com/0.2/graphql").
    build();

//    private Observable<GetAllTrips.Data> observable;
//    private Disposable sub;
//
//    @Override
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
//                observable = Rx2Apollo.from(apolloClient.query(new GetAllTrips()).watcher())
//                      .subscribeOn(Schedulers.io())
//                      .map(response -> (getAllTripsFields(response)))
//                      .cache()
//                      .observeOn(AndroidSchedulers.mainThread());
//
//    }
}
