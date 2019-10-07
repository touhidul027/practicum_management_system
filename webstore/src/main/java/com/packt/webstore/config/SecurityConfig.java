package com.packt.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("student").password("student").roles("STUDENT");
        auth.inMemoryAuthentication().withUser("supervisor").password("supervisor").roles("SUPERVISOR");
        auth.inMemoryAuthentication().withUser("15103199@iubat.edu").password("15103199").roles("STUDENT");
        auth.inMemoryAuthentication().withUser("15103198@iubat.edu").password("15103198").roles("STUDENT");
    }
     
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
  
       httpSecurity.formLogin().loginPage("/login")
                   .usernameParameter("userId")
                   .passwordParameter("password");
       
       httpSecurity.formLogin().defaultSuccessUrl("/")
                    .failureUrl("/login?error");
       
       httpSecurity.logout().logoutSuccessUrl("/login?logout");
       
       httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
       
       httpSecurity.authorizeRequests()
          .antMatchers("/").hasAnyRole("ADMIN","USER","STUDENT","SUPERVISOR")
          .antMatchers("/administrator").access("hasRole('ADMIN')")       
          .antMatchers("/**/market/**").access("hasRole('USER')");       
       
       httpSecurity.csrf().disable();
    }
}
