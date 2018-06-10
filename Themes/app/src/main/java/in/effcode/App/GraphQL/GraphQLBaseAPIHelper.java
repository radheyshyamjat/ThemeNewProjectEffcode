package in.effcode.App.GraphQL;

/**
 * Created by Radhey on 28/5/18.
 * Author Radhey
 */

public class GraphQLBaseAPIHelper {

//    public interface OnRequestComplete<T> {
//        void onSuccess(T object);
//
//        void onFailure(String errorMessage, int errorCode);
//    }
//
//    private String TAG="BASE_HELPER";
//    private boolean debug=false;
//    protected App app;
//    protected APIService apiService;
//
//    protected APIService apiServiceWithNull;
//
//    // MIME type and Header Keys
//    private static final String KEY_ACCEPT = "Accept";
//    private static final String KEY_MULTIPART = "multipart";
//    private static final String KEY_APPLICATION_JSON = "application/json";
//    private static final String KEY_CONTENT_TYPE = "Content-Type";
//    private static final String KEY_AUTHORIZATION = "Authorization";
//    private static final String KEY_SEND = "x-data";
//    private static final String KEY_API_KEY = "api-key";
//
//    // Response Code
//    private static final int TEMP_CODE = -8;
//    private static final int RESULT_INVALID_USER = 401;
//    private static final int RESULT_SUCCESS = 200;
//    private static final int RESULT_SUCCESS_CREATED = 201;
//
//
//    public void setApplication(App application) {
//        this.app = application;
//    }
//
//    protected void createRestAdapter() {
//        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.readTimeout(1, TimeUnit.MINUTES);
//        httpClientBuilder.writeTimeout(1, TimeUnit.MINUTES);
//
//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            httpClientBuilder.addInterceptor(loggingInterceptor);
//        }
//
//        httpClientBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Request.Builder requestBuilder = request.newBuilder();
//                String contentType = request.header(KEY_CONTENT_TYPE);
//
//                //TODO: need to add jwt token
//                if (null != App.getPreferences().getWrapper()) {
//                    if (null != App.getPreferences().getTenant() && !StringUtils.isEmpty(App.getPreferences().getTenant().getToken())) {
//                        App.getPreferences().setToken(null);
//                        requestBuilder.header(KEY_AUTHORIZATION, App.getPreferences().getTenant().getToken());
//                        if (App.getPreferences().getTenant()!=null){
//                            String key = App.getPreferences().getTenant().getDomain_url();
//                            int end= key.indexOf(".");
//                            key = key.substring(0,end);
//                            requestBuilder.addHeader(KEY_SEND,key);
//                        }
//                    } else {
//                        App.getPreferences().clearPreferences();
//                    }
//                } else if (!StringUtils.isEmpty(App.getPreferences().getToken())) {
//                    requestBuilder.header(KEY_AUTHORIZATION, App.getPreferences().getToken());
//                }
//
//
//                if (null == contentType || !contentType.contains(KEY_MULTIPART)) {
//                    requestBuilder.header(KEY_CONTENT_TYPE, KEY_APPLICATION_JSON);
//                }
//
//
//                requestBuilder.method(request.method(), request.body());
//                request = requestBuilder.build();
//                if (Logger.isLogEnabled()) {
//                    Logger.debug("Headers >> ");
//                    for (String name : request.headers().names()) {
//                        Logger.debug("\n" + name + " --> " + request.headers().get(name));
//                    }
//                }
//                return chain.proceed(request);
//            }
//        });
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClientBuilder.build())
//                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
//                .baseUrl(getBaseURL())
//                .build();
//        apiService = retrofit.create(APIService.class);
//    }
//
//    protected synchronized ServerError getRawServerError(Response response) {
//        return new ServerError(response.code(), response.message());
//    }
//
//    protected synchronized ServerError getServerError(@StringRes int stringId) {
//        return new ServerError(-1, app.getString(stringId));
//    }
//
//    protected synchronized ServerError getServerError(String message) {
//        return new ServerError(-1, message);
//    }
//
//    protected synchronized ServerError getServerError() {
//        return new ServerError(-1, "We apologize for the inconvenience. Please try again later");
//    }
//
//    protected abstract class ResponseHandler<T> implements Callback<T> {
//
//        OnRequestComplete mOnRequestComplete;
//        String mLogTag = "ResponseHandler";
//
//        ResponseHandler(final OnRequestComplete onRequestComplete) {
//            mOnRequestComplete = onRequestComplete;
//        }
//
//        ResponseHandler(final OnRequestComplete onRequestComplete, String logTag) {
//            mOnRequestComplete = onRequestComplete;
//            mLogTag = logTag;
//        }
//
//        @Override
//        public void onResponse(Call<T> call, Response<T> response) {
//            if (null != response) {
//                try {
//                    switch (response.code()) {
//                        case RESULT_INVALID_USER:
//                            onFailure(response);
//                            break;
//                        case RESULT_SUCCESS:
//                            onSuccess(response);
//                            break;
//                        case RESULT_SUCCESS_CREATED:
//                            onSuccess(response);
//                            break;
//                        default:
//                            onFailure(response);
//                            break;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    onException(e);
//                }
//            } else {
//                onFailure();
//            }
//        }
//
//        @Override
//        public void onFailure(Call<T> call, Throwable t) {
//            onRetrofitFailure(t);
//        }
//
//        public abstract void onSuccess(Response<T> response) throws Exception;
//
//        protected void onException(Exception e) {
//            mOnRequestComplete.onFailure(getServerError().getMessage(), TEMP_CODE);
//            Logger.debug("BaseAPIHelper : " + mLogTag + " : onException(): " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        public void onFailure(Response response) {
//            String errorMessage;
//            try {
//                errorMessage = JsonHelper.getErrorMessage(response.errorBody());
//            } catch (Exception e) {
//                errorMessage = e.getMessage();
//            }
//            mOnRequestComplete.onFailure(errorMessage, response.code());
//            Logger.debug("BaseAPIHelper : " + mLogTag + " :  onFailure(): " + errorMessage);
//        }
//
//        public void onFailure() {
//            mOnRequestComplete.onFailure(getServerError().getMessage(), TEMP_CODE);
//            Logger.debug("BaseAPIHelper : " + mLogTag + " :  onFailure(): Getting null response from the server");
//        }
//
//        public void onFailure(String errorMsg) {
//            mOnRequestComplete.onFailure(errorMsg, TEMP_CODE);
//            Logger.debug("BaseAPIHelper : " + mLogTag + " :  onFailure(): Server custom error");
//        }
//
//        protected void onRetrofitFailure(Throwable t) {
//            if (null != t) {
//                Logger.debug("BaseAPIHelper : " + mLogTag + " : onRetrofitFailure(): " + t.getMessage());
//            } else {
//                Logger.debug("BaseAPIHelper : " + mLogTag + " :  onRetrofitFailure(): Throwable Object is null");
//            }
//            mOnRequestComplete.onFailure(getServerError().getMessage(), TEMP_CODE);
//        }
//    }
//
//    private String getBaseURL() {
//        String baseURL=null;
//        if (!debug) {
//            baseURL = App.getAppContext().getString(in.effcode.eduknox.R.string.base_url_second);
//            try {
//                if (!StringUtils.isEmpty(App.getPreferences().getBaseURL())) {
//                    baseURL = App.getPreferences().getBaseURL();
//                }
//            } catch (Exception e) {
//                Logger.debug("Exception in base url config: " + e.getMessage());
//            }
//            Logger.debug("Base URL is:" + baseURL);
//        }else {
//            baseURL = App.getAppContext().getString(in.effcode.eduknox.R.string.debug);
//        }
//        return baseURL;
//    }
}
