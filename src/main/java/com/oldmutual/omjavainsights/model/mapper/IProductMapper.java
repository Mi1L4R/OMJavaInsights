package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Product;
import com.oldmutual.omjavainsights.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    // todo add mapping needed for Product and Product dto differences
    ProductDTO productToProductDTO(Product product);

    // todo add mapping needed for Product and Product dto differences
    Product productDTOToProduct(ProductDTO productDTO);

    //List Conversions
    List<ProductDTO> productListToProductDTOList(List<Product> products);
    List<Product> productDTOListToProductList(List<ProductDTO> productsDTO);

}
