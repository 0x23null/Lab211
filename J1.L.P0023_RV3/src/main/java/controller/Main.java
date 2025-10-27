package controller;

import service.FruitShopService;

public class Main {

    public static void main(String[] args) {
        FruitShopService fss = new FruitShopService();

        fss.run();
    }
}
