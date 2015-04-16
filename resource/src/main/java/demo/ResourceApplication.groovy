package demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
//@EnableRedisHttpSession
@EnableOAuth2Resource
class ResourceApplication extends WebSecurityConfigurerAdapter {

    @RequestMapping("/")
    def home() {
        [id: UUID.randomUUID(), content: 'Hello World']
    }

    static void main(String[] args) {
        SpringApplication.run ResourceApplication, args
    }

//    @Bean
//    HeaderHttpSessionStrategy sessionStrategy() {
//        return new HeaderHttpSessionStrategy();
//    }

/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
        http.authorizeRequests().anyRequest().authenticated()
    }
*/
}
