package com.example.cookingapp.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "item", schema = "cookapp", catalog = "")
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_item")
    private int idItem;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "calories")
    private double calories;
    @Basic
    @Column(name = "quantityunit")
    private String quantityunit;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getQuantityunit() {
        return quantityunit;
    }

    public void setQuantityunit(String quantityunit) {
        this.quantityunit = quantityunit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return idItem == that.idItem && Double.compare(price, that.price) == 0 && Double.compare(calories, that.calories) == 0 && Objects.equals(name, that.name) && Objects.equals(category, that.category) && Objects.equals(quantityunit, that.quantityunit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, name, price, category, calories, quantityunit);
    }
}
