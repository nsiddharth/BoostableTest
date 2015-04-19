package com.boostable.schema;

/**
 * Created by siddharn on 4/19/15.
 */
public class StoreInformation {

    private int store_id;
    private String store_name;

    public StoreInformation(int store_id, String store_name) {
        this.store_id = store_id;
        this.store_name = store_name;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}
