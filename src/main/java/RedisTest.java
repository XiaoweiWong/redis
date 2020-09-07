import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.Set;

/**
 * @author david
 * @create 2020-09-04 下午 3:52
 */
public class RedisTest {

    private Jedis jedis = null;



    @Before
    public void start(){
        jedis = new Jedis("192.168.65.101",6379);
    }
    @After
    public void stop(){
        jedis.close();
    }
    @Test
    public void keys(){
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {

        }

        System.out.println("connection is ok.... "+jedis.ping());
    }
    @Test
    public void string(){

    }
    @Test
    public void list(){

    }
    @Test
    public void testset(){

    }
    @Test
    public void zset(){

    }
    @Test
    public void hash(){

    }

}
