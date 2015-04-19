package com.boostable.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Created by siddharn on 4/19/15.
 */
public class ErrorResponse extends Exception {

    @Expose
    String error;
    transient Gson gson;

    public ErrorResponse(String error) {
        this.error = error;
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


    }


    public String toJson() {

       return gson.toJson(this);
    }
}
