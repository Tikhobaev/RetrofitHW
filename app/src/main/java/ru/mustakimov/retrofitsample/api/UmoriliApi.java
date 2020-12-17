package ru.mustakimov.retrofitsample.api;


import retrofit2.Call;
import retrofit2.http.GET;
import ru.mustakimov.retrofitsample.DateModel;
import ru.mustakimov.retrofitsample.IpModel;

/**
 * Created by misha on 31.10.2016.
 */
public interface UmoriliApi {

    @GET("http://date.jsontest.com/?service=ip")
    Call<IpModel> getIp();

    @GET("http://date.jsontest.com/?service=date")
    Call<DateModel> getDate();
}
