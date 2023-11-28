package org.bedu.eshop.mapper;

import org.bedu.eshop.dto.CreateProductDTO;
import org.bedu.eshop.dto.ProductDTO;
import org.bedu.eshop.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    //no hay anotaciones porque la conversión es uno a uno 
    // Product.id -> ProductDTO.id ectc
    ProductDTO toDTO(Product model);

    // source -> al objeto de entrada -> CreateProductDTO
    // target -> al objeto de salida -> Product

    // En el target se va ignorar el campos id
    @Mapping(target = "id", ignore = true)

    // "stock" en el source pasa a ser "quantity" en el target
    @Mapping(source = "stock", target = "quantity")
    Product toModel(CreateProductDTO dto);
}
