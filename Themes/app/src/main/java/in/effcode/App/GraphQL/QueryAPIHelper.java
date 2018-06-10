package in.effcode.App.GraphQL;

/**
 * Created by Radhey on 28/5/18.
 * Author Radhey
 */

public class QueryAPIHelper {

//
//    private static APIHelper instance;
//    private final static int RESULT_OK = 200;
//    private final static int RESULT_OK_CREATED = 201;
//    private final static int HTTP_UNAUTHORIZED = 401;
//
//    public static void refreshBase() {
//        instance = null;
//    }
//
//    public static synchronized APIHelper init(App app) {
//        if (null == instance) {
//            instance = new APIHelper();
//            instance.setApplication(app);
//            instance.createRestAdapter();
//        }
//        return instance;
//    }
//
//    private String getString(int stringId) {
//        return App.getAppContext().getString(stringId);
//    }
//
//    public APIService getApiService() {
//        return apiService;
//    }
//
//    private String showGeneralizedError() {
//        return getString(in.effcode.eduknox.R.string.response_msg_common);
//    }
//
//    public void requestSignIn(String phoneNumber, String password, final OnRequestComplete<WrapperDTO> onRequestComplete) {
//        apiService.requestSignIn(phoneNumber, password).enqueue(new ResponseHandler<WrapperDTO>(onRequestComplete, "SignIn()") {
//            @Override
//            public void onSuccess(Response<WrapperDTO> response) throws Exception {
//                if (RESULT_OK == response.code()) {
//                    onRequestComplete.onSuccess(response.body());
//                } else {
//                    onRequestComplete.onFailure(showGeneralizedError(), response.code());
//                }
//            }
//        });
//    }

}
