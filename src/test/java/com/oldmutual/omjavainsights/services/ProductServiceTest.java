package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.Product;
import com.oldmutual.omjavainsights.model.mapper.IContractMapper;
import com.oldmutual.omjavainsights.model.mapper.IProductMapper;
import com.oldmutual.omjavainsights.repositories.IProductRepository;
import com.oldmutual.omjavainsights.services.interfaces.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {

    public static final Long ID = 1L;
    public static final String PRODUCT_CODE = "ProductCode";
    public static final String PRODUCT_TYPE = "ProductType";
    public static final String POLICY_NUMBER = "PolicyNumber";
    public static final String POLICY_FEE = "PolicyFee";
    public static final String PAYMENT_MODE = "PaymentMode";
    public static final String AML_BELOW_THRESHOLD = "AMLProductCategoryBelowThreshold";
    public static final Date START_DATE = new Date();
    public static final Date END_DATE = new Date();
    public static final String PREMIUM = "Premium";
    public static final String PREMIUM_FREQUENCY = "PremiumFrequency";
    public static final Contract CONTRACT = Contract.builder()
            .contractId(1L)
            .businessUnit("BU")
            .contractSource("Source")
            .premium(PREMIUM)
            .premiumFrequency(PREMIUM_FREQUENCY)
            .startDate(new Date())
            .endDate(new Date())
            .contractRoles(Arrays.asList(
                    ContractRole.builder().contractRoleId(1L).build(),
                    ContractRole.builder().contractRoleId(2L).build()
            ))
            .naturalPerson(NaturalPerson.builder().naturalPersonId(1L).build())
            .build();

    @MockBean
    ProductService productService;

    @MockBean
    IProductRepository productRepository;

    //mappers
    @SpyBean
    IProductMapper productMapper;

    @SpyBean
    IContractMapper contractMapper;

    @BeforeEach
    void setUp() {

        productService = new ProductService(productMapper, productRepository);
    }

    @Test
    void getProductById() {

        //given
        var product = Product.builder()
                .productId(ID)
                .productCode(PRODUCT_CODE)
                .productType(PRODUCT_TYPE)
                .policyNumber(POLICY_NUMBER)
                .policyFee(POLICY_FEE)
                .paymentMode(PAYMENT_MODE)
                .amlProductCategoryBelowThreshold(AML_BELOW_THRESHOLD)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .premium(PREMIUM)
                .premiumFrequency(PREMIUM_FREQUENCY)
                .contract(CONTRACT)
                .build();

        //when
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        var productDTO = productService.getProductById(ID);

        //then
        assertAll("Assert that repo retrieved a party and successfully mapped it",
                () -> assertEquals(ID, productDTO.getProductId()),
                () -> assertEquals(PRODUCT_CODE, productDTO.getProductCode()),
                () -> assertEquals(PRODUCT_TYPE, productDTO.getProductType()),
                () -> assertEquals(POLICY_NUMBER, productDTO.getPolicyNumber()),
                () -> assertEquals(POLICY_FEE, productDTO.getPolicyFee()),
                () -> assertEquals(PAYMENT_MODE, productDTO.getPaymentMode()),
                () -> assertEquals(AML_BELOW_THRESHOLD, productDTO.getAmlProductCategoryBelowThreshold()),
                () -> assertEquals(START_DATE, productDTO.getStartDate()),
                () -> assertEquals(END_DATE, productDTO.getEndDate()),
                () -> assertEquals(PREMIUM, productDTO.getPremium()),
                () -> assertEquals(PREMIUM_FREQUENCY, productDTO.getPremiumFrequency()),
                () -> assertEquals(contractMapper.contractToContractDTO(CONTRACT), productDTO.getContract())
        );
    }
}