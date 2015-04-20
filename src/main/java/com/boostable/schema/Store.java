package com.boostable.schema;

import com.boostable.response.ErrorResponse;
import com.boostable.response.SuccessResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siddharn on 4/19/15.
 */
public class Store {

    StoreInformation storeInformation;
    private Map<Integer, Product> productMap;


    public Store(int store_id, String store_name) throws ErrorResponse{

       if(store_name==null || store_name.isEmpty())
           throw (new ErrorResponse("null or empty value not permissible"));

        productMap = new HashMap<Integer, Product>();

        storeInformation =  new StoreInformation(store_id,store_name);

    }

    public int getStore_id() {
        return storeInformation.getStore_id();
    }

    public void setStore_id(int store_id) {
        storeInformation.setStore_id(store_id);
    }

    public String getStore_name() {

        return storeInformation.getStore_name();
    }

    public void setStore_name(String store_name) throws ErrorResponse {
        if(store_name==null || store_name.isEmpty())
            throw (new ErrorResponse("null or empty value not permissible"));

        storeInformation.setStore_name(store_name);
    }

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<Product>();

        for(Map.Entry<Integer, Product> entry : productMap.entrySet()){

            productList.add(entry.getValue());

        }

        return productList;
    }

    public String addProduct(Product product) throws ErrorResponse {

        if(product==null)
                throw (new ErrorResponse("null value not permissible"));

        if(productMap.containsKey(product.getProduct_id()))
        {
            (new ErrorResponse("store id already exists")).toJson();
        }
        else
            productMap.put(product.getProduct_id(),product);

        return (new SuccessResponse("SUCCESS")).toJson();
    }

    public Product getProduct(int product_id) throws ErrorResponse {

        if(!productMap.containsKey(product_id))
        {
            throw new ErrorResponse("id not found");
        }

        return productMap.get(product_id);
    }

    public StoreInformation getStoreInformation(){

        return this.storeInformation;
    }
}
