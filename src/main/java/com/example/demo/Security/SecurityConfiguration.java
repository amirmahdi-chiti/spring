package com.example.demo.Security;

import com.example.demo.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.example.demo.Security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final ApplicationUserService applicationUserService;
    private  final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(ApplicationUserService applicationUserService, PasswordEncoder passwordEncoder) {
        this.applicationUserService = applicationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
             //   .and()
                .authorizeRequests()
                .antMatchers("/security/**").hasRole(DOCTOR.name())
      //          .antMatchers(HttpMethod.DELETE,"/managment/security/**").hasAuthority(COURSE_WRITE.getPermission())
      //          .antMatchers(HttpMethod.POST,"/managment/security/**").hasAuthority(COURSE_WRITE.getPermission())
      //          .antMatchers(HttpMethod.PUT,"/managment/security/**").hasAuthority(COURSE_WRITE.getPermission())
      //          .antMatchers(HttpMethod.GET,"/managment/security/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
           //     .httpBasic();
                 .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/",true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
                    .key("securitykey")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET")) // use when csrf is disabled and when csrf is enable this line shoud remove
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }



   /* @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails amirmahdiUser = User.builder()
                .username("amirmahdi")
                .password(passwordEncoder().encode("1234"))
                //.roles(DOCTOR.name())
                .authorities(DOCTOR.getGrantedAuthorities())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                //.roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails adminTrainee = User.builder()
                .username("adminTrainee")
                .password(passwordEncoder().encode("1234"))
                //.roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(amirmahdiUser,admin,adminTrainee);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
