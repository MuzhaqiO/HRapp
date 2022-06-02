package com.internship.HRapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
//        http.csrf().disable()
//                .formLogin().loginPage("/hr_menagement/login")
//                .failureUrl("/hr_menagement/login?error=true")
//                .defaultSuccessUrl("/getAll")
//                .usernameParameter("username")
//                .passwordParameter("password");
        ///CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        ///customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.authorizeRequests().anyRequest().permitAll();
        /// http.authorizeRequests().antMatchers(GET, "/api/users/userId/{userId}/**").hasAnyAuthority("ROLE_USER");
        ///  http.authorizeRequests().antMatchers(POST, "/api/user/addNewUser/**").hasAnyAuthority("ROLE_HRSPECIALIST");
        /// http.addFilter(customAuthenticationFilter);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
