package ie.caragher.workoutmanager.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ExerciseSercurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> 
                configurer
                    .requestMatchers("/css/**").permitAll()
                    .requestMatchers("/").hasRole("EMPLOYEE")
                    .requestMatchers("/leaders/**").hasRole("MANAGER")
                    .requestMatchers("/systems/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(form ->
                form.loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
            )
            .logout(logout -> logout.permitAll()
            );

        return http.build(); 
    }

}
