package pl.honestit.spring.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

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
}
