package com.boostable.response;

import com.google.gson.Gson;

/**
 * Created by siddharn on 4/19/15.
 */
public class SuccessResponse {

    String message;
    transient Gson gson;

    public SuccessResponse(String message) {
        this.message = message;
        this.gson = new Gson();
    }


    public String toJson() {
        return gson.toJson(this);
    }
}
