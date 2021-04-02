package kuroneko.fun.netty.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "netty.server.config")
@Configuration
@Data
public class ServerConfig {
  private String ip;
  private Integer port;
}
