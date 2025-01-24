package bitc.fullstack503.jpatest.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception {
    DataSource ds = new HikariDataSource(hikariConfig());
    System.out.println(ds.toString());
    return ds;
  }

//  application.properties 파일에서 'spring.jpa' 로 시작하는 설정을 읽어와서 사용함
  @Bean
  @ConfigurationProperties(prefix = "spring.jpa")
  public Properties hibernateConfig() {
    return new Properties();
  }
}












