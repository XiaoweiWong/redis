import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.Set;

/**
 * redis客户端API开发
 * @author david
 * @create 2020-09-04 下午 3:52
 */
public class RedisTest {

    private Jedis jedis = null;

    @Before
    public void start(){
        //获取连接
        System.out.println("初始化连接");
        jedis = new Jedis("192.168.65.101",6379);
    }
    @After
    public void stop(){
        if (jedis != null){
            jedis.close();
        }
        System.out.println("关闭redis");
    }
    @Test
    public void keys(){
        Set<String> keys = jedis.keys("*");
       for(String STR:keys) {
           System.out.println(STR);
       }
    }
    @Test
    public void string(){
            jedis.set("david","zhangsan");
           System.out.println(jedis.get("david"));
    }
    @Test
    public void list(){
        jedis.lpush("k1","v1","v2","v3");
        System.out.println(jedis.lrange("k1", 0, -1));


    }
    @Test
    public void testset(){
        jedis.sadd("k4","2");
        jedis.sadd("k4","2");
        jedis.sadd("k4","1");
        jedis.sadd("k4","2");
        jedis.sadd("k4","5");
        System.out.println(jedis.smembers("k4"));


    }
    @Test
    public void zset(){
        jedis.zadd("k10",2.2,"zhansan");
        jedis.zadd("k10",3.4,"lisi");
        jedis.zadd("k10",5.3,"wangwu");
        System.out.println(jedis.zrange("k10",1,5));

    }
    @Test
    public void hash(){
        jedis.hset("k11","age","20");
        jedis.hset("k11","class","1");
        jedis.hset("k11","addr","beijing");

        System.out.println(jedis.hget("k11", "addr"));
    }

}
