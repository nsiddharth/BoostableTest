package com.boostable;

import com.boostable.response.ErrorResponse;
import com.boostable.response.SuccessResponse;
import com.boostable.schema.Product;
import com.boostable.schema.Store;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by siddharn on 4/19/15.
 */
public class Warehouse {

   private Map<Integer, Store> storeMap ;
    private transient Gson gson;

    public Warehouse() {
        storeMap = new HashMap<Integer, Store>();
        gson =  new Gson();
    }


    public String addStore(int store_id, String store_name){

        if(storeMap.containsKey(store_id))
        {
           return  (new ErrorResponse("store id already exists")).toJson();
        }
        else{
            Store store = null;
            try {
                store = new Store(store_id, store_name);
            } catch (ErrorResponse errorResponse) {
               return errorResponse.toJson();
            }
            storeMap.put(store_id, store);
        }

        return (new SuccessResponse("SUCCESS")).toJson();
    }

    public String getStore(int store_id){

        if(!storeMap.containsKey(store_id))
          return (new ErrorResponse("id not found")).toJson();


        return gson.toJson(storeMap.get(store_id).getStoreInformation());
    }

    public String getProducts(int store_id){

        if(storeMap.containsKey(store_id)) {
            Store store = storeMap.get(store_id);
            //gson This
          return gson.toJson( store.getProductList());
        }

        return (new ErrorResponse("id not found")).toJson();

    }

    public String getProduct(int store_id, int product_id){

        if(storeMap.containsKey(store_id)){
            Store store =storeMap.get(store_id);
            try {
                return gson.toJson(store.getProduct(product_id));
            } catch (ErrorResponse errorResponse) {
                return (new ErrorResponse("id not found")).toJson();
            }

        }

        return (new ErrorResponse("id not found")).toJson();

        //error
    }

    public String addProduct(int store_id, int product_id, String product_name, String description, double price ) {

        if (storeMap.containsKey(store_id)) {
            Store store = storeMap.get(store_id);

            try {
                return store.addProduct(new Product(product_id, product_name, description, price));
            } catch (ErrorResponse errorResponse) {
               return errorResponse.toJson();
            }
        }


        return (new ErrorResponse("id not found")).toJson();

    }
}
