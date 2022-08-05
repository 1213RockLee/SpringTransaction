package com.lee;

import com.lee.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author Lee(005013)
 * @date 2022/7/19 16:12
 */
@SpringBootApplication
public class SpringTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class);
    }

    @Autowired
    private TransactionService transactionService;

    //@PostConstruct
    private void start() {
        System.out.println("**********start success*********");
        transactionService.method01();
    }
}
