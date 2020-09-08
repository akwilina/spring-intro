package pl.honestit.spring.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/register").permitAll() //na ścieżce register wszyscy (premit all) mogą wejść (zalogowani i nie)
				.anyRequest().authenticated() //domyślna ścieżka, oczekiwanie zalogowania przy wejściu na wszystkie inne strony,
				.and()
			.formLogin()
				.defaultSuccessUrl("/index.html") //strona domyślna. Jeśli wszedł na inną stronę niż logowania, to wyświetli się tamta, ale jeżeli nie, to wyswietli się ta.
				//aktywowaniu logowania (pod adresem /login) poprzez automatyczny formularz logowania Spring Security z opcją domyślnej strony sukcesu /index.html,)
				.and()
			.logout()
				.logoutSuccessUrl("/index.html");//aktywowanie wylogowania (pod adresem /logout) automatycznie przeprowadzanego przez Spring Security.
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.inMemoryAuthentication()
        		.withUser("user").password("{noop}pass").roles("USER");
        auth	
        	.jdbcAuthentication()
        	.dataSource(dataSource) //do jakiej bazy ma się odwołać
        	.passwordEncoder(passwordEncoder())//żeby spring wiedział jakimechanizm szyfrowania haseł ma wybrać
        	.usersByUsernameQuery("SELECT username, password, active FROM users WHERE username = ?")//to zapytanie, które spring ma wykonać na bazie, żeby uzyskać informacje o użytkowniku
        	.authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM users WHERE username = ?");//użytokwnicy mogą mieć różne uprawnienia. ROLE_USER oznacza, że na sztywno wpisaliśmy rolę uytkownika jako user.
	}
}
