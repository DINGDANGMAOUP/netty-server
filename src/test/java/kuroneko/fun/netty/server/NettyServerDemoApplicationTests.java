package kuroneko.fun.netty.server;

import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import kuroneko.fun.netty.server.config.ServerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NettyServerDemoApplicationTests {

    @Resource
    ServerConfig serverConfig;
    @Test
    void contextLoads() {
        byte[] bytes = "this is the server\n".getBytes();
    System.out.println(bytes.length);
    }

}
