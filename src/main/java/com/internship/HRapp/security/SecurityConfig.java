package com.internship.HRapp.security;

import com.internship.HRapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
//        com.internship.HRapp.entity.User user = userRepo.getByUsername("nazmi");
//        UserDetails lloz = User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .roles()
//                .build();
        UserDetails nazi = User.builder()
                .username("nazi")
                .password(passwordEncoder.encode("thimi"))
                .roles("USER")
                .build();

        UserDetails thimi = User.builder()
                .username("thimi")
                .password(passwordEncoder.encode("nazi"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(nazi, thimi);
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST)
                .permitAll()
//                .antMatchers("/hr_menagement/**").hasAnyRole()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

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

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

}
