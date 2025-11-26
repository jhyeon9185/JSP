package com.controller;

import com.controller.action.*;

public class ProductFactory {

    private static ProductFactory instance = new ProductFactory();

    private ProductFactory() {
    }

    public static ProductFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {
        if (command == null) {
            return null;
        }

        switch (command) {
            case "product_list":
                return new ProductListAction();
            case "product_detail":
                return new ProductDetailAction();
            case "product_write":
                return new ProductWriteAction();
            case "product_update":
                return new ProductUpdateAction();
            case "product_delete":
                return new ProductDeleteAction();
            default:
                return null;
        }
    }
}