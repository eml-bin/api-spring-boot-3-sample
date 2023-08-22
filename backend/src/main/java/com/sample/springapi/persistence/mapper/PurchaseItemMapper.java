package com.sample.springapi.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sample.springapi.domain.dto.PurchaseItem;
import com.sample.springapi.persistence.entity.ComprasProducto;

@Mapper(componentModel = "spring", uses = { ProductMapper.class } )
public interface PurchaseItemMapper {

    @Mappings({
        @Mapping(source = "id.idProducto", target = "productId"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);
    
    @InheritInverseConfiguration // Utiliza el mapping que se definió en la parte superior
    @Mappings({
        @Mapping(target = "compra", ignore = true),
        @Mapping(target = "producto", ignore = true),
        @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchase);
}
