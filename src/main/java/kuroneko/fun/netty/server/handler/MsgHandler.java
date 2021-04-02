package kuroneko.fun.netty.server.handler;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class MsgHandler {

    public void response(Object obj){
      log.info("处理信息：{}",obj.toString());
    }
}
