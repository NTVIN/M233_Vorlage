package ch.zli.m223.ksh19a.as.CRM.security;

import ch.zli.m223.ksh19a.as.CRM.roles.ApppRoles;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     UserDetailsService userDetailsService;
     BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(
            UserDetailsService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void  configure(HttpSecurity http) throws Exception{
        configureWeb(http);
        //configureRest(http);
    }

    private void configureRest(HttpSecurity http) {


    }

    private void configureWeb(HttpSecurity http) throws Exception {
        http
                    .authorizeHttpRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/admin/**").hasAuthority(ApppRoles.ADMIN)
                    .antMatchers("/user/**").hasAuthority(ApppRoles.USER)
                    .antMatchers("/logedin").authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

    }


}
