package com.example.winwin.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// 스프링 컨테이너에 빈을 등록할 때 사용하는 어노테이션은 @Component이다.
// 빈을 등록할 때 사용하는 어노테이션이 하나만 있는게 아니다.
// 그 중 하나가 @Configuration이다.
// 특별한 기능이 있는 것이 아니라 빈의 사용 목적을 구분짓기 위해 이름을 나누어 놨다.
// @Configuration은 설정을 위한 빈을 등록할 때 사용한다.
@RequiredArgsConstructor
public class MyBatisConfig {
//    스프링 부트의 핵심 인터페이스이다.
//    우리가 스프링 컨테이너라고 부르는 논리적인 구조를 실체화(구현)한 것이 applicationContext이다.
//    이 객체를 우리가 불러와 설정에 이용할 수 있다.
    private final ApplicationContext applicationContext;

//    이 어노테이션은 외부파일의 설정 값들을 자바 객체로 가져올 때 사용한다.
//    스트링 부트에서는 application.properties라는 파일에 설정 값을 전부 작성하기 때문에 해당 파일에서 값을 가져온다.
//    prefix는 어노테이션의 설정이다. 접두사를 설정할 때 사용하며 spring.datasource.hikari로 시작하는 설정값을 전부 가져오라는 의미이다.
//    가져온 값을 new HikariConfig()에 필드로 바인딩한다.
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean
    public HikariConfig hikariConfig(){
//        Hikari란?
//        HikariCP(히카리 커넥션 풀) 라이브러리를 의미한다.
//        빠르고, 가볍고, 설정이 쉽고, 안정성이 높다는 장점이 있다.
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources( "classpath*:/mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));

        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
