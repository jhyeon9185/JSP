package com.controller.controller;

import com.controller.controller.action.Action;
import com.controller.controller.action.ProductDeleteAction;
import com.controller.controller.action.ProductDetailAction;
import com.controller.controller.action.ProductListAction;
import com.controller.controller.action.ProductNoneDetail;
import com.controller.controller.action.ProductNoneListAction;
import com.controller.controller.action.ProductUpdateAction;
import com.controller.controller.action.ProductWriteAction;

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
            case "product_none_list" :
            	return new ProductNoneListAction();
            case "product_none_detail" :
            	return new ProductNoneDetail();
            default:
                return null;
        }
    }
}