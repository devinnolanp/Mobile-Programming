package id.ac.umn.week11_30198;

public class UtilsApi {
    public static final String BASE_URL_API = "https://jsonplaceholder.typicode.com/";

    //deklarasi apiinterface
    public static InterfaceApi getApiSerivce() {
        return ApiClient.getClient(BASE_URL_API).create(InterfaceApi.class);
    }
}
