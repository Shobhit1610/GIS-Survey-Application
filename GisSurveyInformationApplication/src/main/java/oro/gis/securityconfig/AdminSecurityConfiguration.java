package oro.gis.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/user/**").permitAll()
								.antMatchers("/admin").hasRole("ADMIN")
								.anyRequest().authenticated()
								.and().formLogin().loginPage("/admin/login").permitAll()
								.and().logout().permitAll()
								.and().logout().logoutSuccessUrl("/");

		
		http.csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception
	{
		authenticationManagerBuilder.inMemoryAuthentication()
												.withUser("admin").password("admin").authorities("ROLE_ADMIN");
	}
}
