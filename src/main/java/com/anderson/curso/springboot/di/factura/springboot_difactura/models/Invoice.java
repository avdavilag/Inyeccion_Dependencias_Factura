package com.anderson.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.List;

@Component
@RequestScope
@JsonIgnoreProperties({ "targetSource", "advisors" })
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.descripcion}")
    private String descripcion;

    // @Qualifier("${invoice.descripcion.office}")
    @Autowired
    @Qualifier("itemsInvoiceOficce")
    private List<Item> items;

    public Invoice() {
        System.out.println("Componente creando una Factura");
        System.out.println(client);
        System.out.println(descripcion);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la Factura desde el PostContructor");
        client.setName(client.getName().concat("Marlene"));
        descripcion = descripcion.concat("del cliente").concat(client.getName()).concat(" ")
                .concat(client.getLastname());

    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo en componente beans");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Float getTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.getImporte();
        }
        return (float) total;

    }

}
