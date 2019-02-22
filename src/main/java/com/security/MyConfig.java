package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//import javax.sql.DataSource;
//import java.util.Arrays;
//
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
        }

    }
}
//
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    AuthSuccessHandler authSuccessHandler;
//
//    private final SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                //.cors()
//////               // .and()
//////                .csrf().disable()
//////                .exceptionHandling()
//////               // .authenticationEntryPoint(authEntryPoint)
//////                .and()
//////                .authorizeRequests()
//////                .antMatchers("/","/register").permitAll()
//////                .anyRequest().authenticated()
//////                .and()
//////                .formLogin()
//////                .loginProcessingUrl("/login")
//////                .successHandler(authSuccessHandler)
//////                .failureHandler(failureHandler)
//////                .permitAll()
//////                .and()
//////                .logout()
//////                .permitAll();
//
//                .authorizeRequests()
//                .antMatchers( "/register").permitAll()
//                //В частности, пути "/" и "/ home" настроены так,
//                // что они не требуют никакой аутентификации.
//                // Все остальные пути должны быть аутентифицированы
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
////                .loginProcessingUrl("/login")
////                .successHandler(authSuccessHandler)
////                .failureHandler(failureHandler)
//                .loginPage("/")
//                //Когда пользователь успешно войдет в систему,
//                // он будет перенаправлен на ранее запрошенную страницу, требующую аутентификации.
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    //@Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("username")
//                        .password("password")
//                     .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    //TODO todo todod dotododototototo
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery("select login, password, true from customers where login=?")
//                .dataSource(dataSource);
////                .passwordEncoder(bCryptPasswordEncoder);
//    }
//
//
//    //@Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
//        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//
//}
