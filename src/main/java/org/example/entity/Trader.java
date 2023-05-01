package org.example.entity;

import org.example.enumClasses.Sex;

import java.util.List;
import java.util.Objects;

public class Trader extends NPC{
    private List<Product> productList;
    private float money;

    public Trader(String name, Sex sex, String locationName, Coordinate coordinates, List<Product> productList, float money) {
        super(name, sex, locationName, coordinates);
        this.productList = productList;
        this.money = money;
    }

    //Getter setter
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    // default functions override
    @Override
    public String toString() {
        return "Trader{" +
                "name='" + getName() +
                ", sex='" + getSex() +
                ", locationName='" + getLocationName() +
                ", coordinates=" + getCoordinates() +
                ", productList=" + getProductList() +
                ", money=" + getMoney() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trader trader = (Trader) o;
        return Float.compare(trader.getMoney(), getMoney()) == 0 && Objects.equals(getProductList(), trader.getProductList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProductList(), getMoney());
    }

    // Trader functions
    public void showProducts(){
        for(Product product : productList){
            System.out.println(product);
        }
    }
    public void buy(Product product, Player player){
        if (!productList.contains(product)){
            System.out.println("Product is not exists");
            return;
        }

        String message;
        boolean result = player.decreaseMoney(product.getPrise());
        if (result){
            money += product.getPrise();
            message = "Your purchase is successful: '" + product + "'";
        } else {
            message = "Purchase Error";
        }
        System.out.println(message);
    }
    public void sell(Product product, Player player){
        if (getMoney() - product.getPrise() < 0){
            System.out.println("The trader doesn't have enough money");
            return;
        }

        String message;
        boolean result = player.increaseMoney(product.getPrise());
        if (result){
            money -= product.getPrise();
            message = "Your sale is successful: '" + product + "'";
        } else {
            message = "Sale Error";
        }
        System.out.println(message);
    }
}
