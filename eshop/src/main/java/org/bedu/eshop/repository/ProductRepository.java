package org.bedu.eshop.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bedu.eshop.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    //La capa de repositorio es una capa de una arquitectora
    //En la cual se maneja el uso de la persistencia

    private long currentId;
    private List<Product> products;

    public ProductRepository() {
        currentId = 0;
        products = new LinkedList<>();
    }

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> getById(long id) {
        // version junior
       
        for ( Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }

        return Optional.empty();

        // version senior
        //return products.stream().filter(x -> x.getId() == id).findFirst();
    }

    public Product save(Product data) {
        data.setId(++currentId);
        products.add(data);
        return data;
    }

    public void update(long id, Product data) {
        Optional<Product> entry = getById(id);

        if (!entry.isPresent()) {
            return;
        }

        Product product = entry.get();

        if (data.getName() != null) {
            product.setName(data.getName());
        }

        if (data.getPrice() > 0 ) {
            product.setPrice(data.getPrice());
        }

        if (data.getQuantity() > 0) {
            product.setQuantity(data.getQuantity());
        }
    }
    
}
