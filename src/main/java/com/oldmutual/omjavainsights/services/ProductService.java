package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ProductDTO;
import com.oldmutual.omjavainsights.model.mapper.IProductMapper;
import com.oldmutual.omjavainsights.repositories.IProductRepository;
import com.oldmutual.omjavainsights.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IProductMapper productMapper;
    private final IProductRepository productRepository;

    public ProductService(IProductMapper productMapper, IProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).stream()
                .map(product -> productMapper.productToProductDTO(product))
                .collect(Collectors.toList()).get(0);
    }
}
