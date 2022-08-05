import com.lee.SpringTransactionApplication;
import com.lee.exception.MyException;
import com.lee.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 为了测试事务传播机制
 *
 * @author Lee(005013)
 * @date 2022/7/19 20:04
 */
@SpringBootTest(classes = SpringTransactionApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test01 {
    @Autowired
    private TransactionService transactionService;

    @Test
    public void test01() {
        transactionService.method01();
        System.out.println(777);
    }

    @Test
    public void test02() {
        transactionService.method03();
        System.out.println(777);
    }

    @Test
    public void test03() {
        //想通过这个来测试是否private修饰符会导致事务失效：没检查出来，似乎还是有效的
        transactionService.method04();
        System.out.println(777);
    }

    @Test
    public void test04() {
        TransactionService transactionService = new TransactionService();

        System.out.println(777);
    }

    @Test
    public void test05() {
        try {
            transactionService.method05();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
