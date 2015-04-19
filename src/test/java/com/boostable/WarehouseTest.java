package com.boostable;

import junit.framework.TestCase;

public class WarehouseTest extends TestCase {

        private final String SUCCESS = "{\"message\":\"SUCCESS\"}";
        private final String ERROR = "{\"error\":\"store id already exists\"}";
    private final String NOT_FOUND_ERROR = "{\"error\":\"id not found\"}" ;

    public void testAddStore() throws Exception {
        Warehouse warehouse =  new Warehouse();
        assertEquals(SUCCESS,warehouse.addStore(35, "my_store"));
        assertEquals(ERROR, warehouse.addStore(35, "my_store"));

    }

    public void testGetStore() throws Exception {
        Warehouse  warehouse =  new Warehouse();
        warehouse.addStore(35, "my_store");
        assertEquals("{\"store_id\":35,\"store_name\":\"my_store\"}",warehouse.getStore(35));

    }

    public void testGetProducts() throws Exception {
        Warehouse  warehouse =  new Warehouse();
        assertEquals(SUCCESS,warehouse.addStore(35, "my_store"));
        assertEquals(SUCCESS , warehouse.addProduct(35, 200, "Child Kite", "Kite for a child", 19) );
        assertEquals(SUCCESS,warehouse.addProduct(35, 100, "Adult Kite", "Kite for an Adult", 35));
       // System.out.println(warehouse.getProducts(35));


    }

    public void testGetProduct() throws Exception {

        Warehouse warehouse =  new Warehouse();
        warehouse.addStore(35, "my_store");
        warehouse.addProduct(35, 200, "Child Kite", "Kite for a child", 19);
        warehouse.addProduct(35, 100, "Adult Kite", "Kite for an Adult", 35);
        assertEquals("{\"product_id\":100,\"name\":\"Adult Kite\",\"description\":\"Kite for an Adult\",\"price\":35.0}", warehouse.getProduct(35, 100));
        assertEquals("{\"product_id\":200,\"name\":\"Child Kite\",\"description\":\"Kite for a child\",\"price\":19.0}",warehouse.getProduct(35, 200));
        assertEquals("product information does not match",NOT_FOUND_ERROR, warehouse.getProduct(25, 100));
        assertEquals( "product information does not match",NOT_FOUND_ERROR,warehouse.getProduct(35,30));



    }
}