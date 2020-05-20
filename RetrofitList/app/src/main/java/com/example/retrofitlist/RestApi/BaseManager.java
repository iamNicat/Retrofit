package com.example.retrofitlist.RestApi;

public class BaseManager {
    protected  RestApi getRestApiClient () {

        RestApiClient restApiClient = new RestApiClient(BaseUrl.data_URL);
        return  restApiClient.getRestApi();
    }
}
