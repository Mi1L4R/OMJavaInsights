package com.oldmutual.omjavainsights;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.mapper.IBusinessTransactionMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OmJavaInsightsApplication implements CommandLineRunner {

    private final IBusinessTransactionMapper businessTransactionMapper;

    public OmJavaInsightsApplication(IBusinessTransactionMapper businessTransactionMapper) {
        this.businessTransactionMapper = businessTransactionMapper;
    }

    public static void main(String[] args) {


        SpringApplication.run(OmJavaInsightsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        var bus = BusinessTransaction.builder()
                .businessTransactionId(1L)
                .contracts(Arrays.asList(
                        Contract.builder().build(),
                        Contract.builder().build()
                ))
                .parties(Arrays.asList(
                        Party.builder().build(),
                        Party.builder().build()
                ))
                .build();

        var dto = businessTransactionMapper.busTransToBusTransDTO(bus);

        System.out.println(dto);
    }
}
