package id.ac.umn.week11_30198;

import android.graphics.ColorSpace;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {
    @GET("posts")
    Call<ArrayList<PostModel>> getPost();
}