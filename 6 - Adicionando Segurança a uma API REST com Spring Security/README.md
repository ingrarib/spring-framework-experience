# Spring Security
## Definição
Spring Security é apenas um grupo de filtros de servlet que ajudam você a adicionar autenticação e autorização ao seu aplicativo da web.  
## Terminologia
- **Autenticação:** refere ao processo de verificação da identidade de um usuário, com base nas credenciais fornecidas.
**Exemplo-** inserir nome de usuário e uma senha ao fazer login em um site.
- **Autorização:** se refere ao processo de determinar se um usuário tem permissão adequada para executar uma ação específica ou ler dados específicos, supondo que o usuário seja autenticado com êxito.
- **Princípio:** refere-se ao usuário autenticado no momento.
- **Autoridade concedida:** refere-se à permissão do usuário autenticado.
- **Função:** refere-se a um grupo de permissões do usuário autenticado.

## Habilitando Segurança
Em um projeto Spring Boot Web você precisa somente incluir a dependência no pom.xml  
  
```
<dependecy>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependecy>
```
  
#### Para uma aplicação do zero:

- No [Spring Initializr](https://start.spring.io/)
- Adicionar as dependências - Web e Spring Security
- Extrair e importar na IDE
- Rodar classe
- Abrir o localhost:8080 no browser
- Propriedade Default (Padrão) - O Spring Security possui um usuário padrão chamado user e toda vez que sua aplicação é iniciada ele gera uma senha aleatória no console.
- Realizar autenticação

## Autenticação Simples
#### No application.properties
O Spring Security verifica se existe alguma configuração de segurança no arquivo **application.properties**
```
spring.security.user.name=user
spring.security.user.password=user123
spring.security.user.roles=USERS
```
* Altera usuário e senha de login

## Geração de usuários em memória
- Permite criar mais de um usuário e perfis de acesso
- Necessário criar uma classe que estenda `WebSecurityConfigurerAdapter`
```
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user123")
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}master123")
                .roles("MANAGERS");
    }
}
```
#### Existem algumas implementações de criptografias utilizadas pelo Spring Security
- Use {bcrypt} for BCryptPasswordEncoder (mais comum);
- Use {noop} for NoOpPasswordEncoder;
- Use {pbkdf2} for Pbkdf2PasswordEncoder;
- Use {scrypt} for SCryptPasswordEncoder;
- Use {sha256} for StandardPasswordEncoder.

## Configure Adapter
Na classe `WebSecurityConfig.java` do nosso projeto adicione o método abaixo:
```
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/managers").hasAnyRole("MANAGERS")
            .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
            .anyRequest().authenticated().and().formLogin();
}
```
## Auth Database (interação com banco de dados)
O Spring Boot dispôe de uma facilidade para integrar nossa aplicação com banco de dados com o Spring Data JPA.  
  
- Adicionar dependência no pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
  
- Criar uma classe User.java
- Criar um repositório para interagir com a nossa entidade User.java e realizar as operações de **CRUD** necessárias.

### UserDetailService
Interface usada para recuperar dados relacionados ao usuário. Ele possui um método denominado *loadUserByUsename()* que pode ser substituído para personalizar o processo de localização do usuário.  
  
- Criar uma classe **SecurityDatabaseService.java** que implementará a `User DetailService` para retornar um usuário para contexto de segurança conforme nosso banco de dados.

### WebSecurityConfig
Em um contexto de banco de dados a classe WebSecurityConfig.java,não contém mais responsabilidade de criar e localizar os usuários, esta ação é delegada ao UserDetailService.  
  
### Sign up
Carga inicial de usuários.  
  
- Crie a classe StartApplication.java que implementa a interface `CommandLineRunner` para executar ao iniciar a aplicação.
- Adicionar a dependência do banco de dados escolhido no pom.xml
- Testar credenciais no Postman

## Links Úteis
https://glysns.gitbook.io/spring-framework/spring-security 
  

