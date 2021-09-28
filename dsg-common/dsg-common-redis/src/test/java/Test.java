import com.dsg.common.redis.service.RedisService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cdw
 * @date 2021/9/3 2:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisService.class})
public class Test {


    @Autowired
    private RedisService redisService;

    @org.junit.Test
    public void test() {
        System.out.println(redisService.get("a"));
    }


}
