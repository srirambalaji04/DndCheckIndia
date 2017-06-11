package com.india.dnd.dndcheck.api.request;


import android.util.Log;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.india.dnd.dndcheck.api.DndApi;
import com.india.dnd.dndcheck.api.response.DndRsp;
import com.india.dnd.dndcheck.bean.Dnd;
import com.octo.android.robospice.request.SpiceRequest;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sriram on 30/10/16.
 */

public class GetDndRequest extends SpiceRequest<Dnd> {

    private static final String TAG = "DndCheck.GetDndRequest";

    private String number;

    public GetDndRequest(String number) {
        super(Dnd.class);
        this.number = number;
    }


    @Override
    public Dnd loadDataFromNetwork() throws Exception {

        String url = String.format(DndApi.URL_GET_DND,  number);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS);

        /*builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);*/

        OkHttpClient client = builder.build();

        Request request = new Request.Builder()
                .url(url).get()
                .header("X-Mashape-Key", DndApi.API_KEY)
                .header("Accept", "application/json").build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()){
            Log.d(TAG, "loadDataFromNetwork: "+ response + "message");
            throw new Exception(response.code() + "");
        }

        String jsonRsp = response.body().string();
        Log.d(TAG, "loadDataFromNetwork: "+ response.message() + "response" + jsonRsp + "jsonrsp");

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Type dndType = new TypeToken<List<Dnd>>(){}.getType();

        List<Dnd> dndresponse = gson.fromJson(jsonRsp, dndType);

        Log.d(TAG, "loadDataFromNetwork: dndresponse"+ dndresponse);
        Dnd dnd = dndresponse.get(0);

        return dnd;
    }
}
