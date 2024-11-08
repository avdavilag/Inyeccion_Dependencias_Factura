package com.anderson.curso.springboot.di.factura.springboot_difactura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.anderson.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.anderson.curso.springboot.di.factura.springboot_difactura.models.Product;
import java.util.Arrays;

import java.util.*;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    //    @Primary

    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Laptop Lenovo", 1400);
        Product p3 = new Product("Celular Samsums", 1000);
        return Arrays.asList(new Item(p1, 5), new Item(p2, 4), new Item(p3, 6));
    }

    @Bean
    List<Item> itemsInvoiceOficce() {
        Product p1 = new Product("Table Destkop", 1200);
        Product p2 = new Product("Destkop Computer", 2500);
        Product p3 = new Product("Pencil and pen", 2);
        Product p4 = new Product("Hp - Painter", 499);
        return Arrays.asList(new Item(p1, 1), new Item(p2, 2), new Item(p3, 50), new Item(p4, 20));

    }

}
