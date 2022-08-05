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

# JWT JSON Web Token
## Definição
O JSON Web Token - JWT é um padrão da Internet para a criação de dados com assinatura opcional e/ou criptografia, cujo conteúdo contém o JSON que afirma algum número de declarações. Os tokens são assinados usando um segredo privado ou uma chave pública/privada.  
   
## Estrutura do JWT
- **Header** ou cabeçalho normalmente consiste em duas partes: o tipo de token, que é JWT e o algoritmo de assinatura que está sendo utilizado, como HMAC SHA256 ou RSA.
```
{
  "alg": "HS256",
  "typ": "JWT"
}
```
- **Payload** é de fato, a estrutura do corpo contendo as informações de autenticação e autorização de um usuário.
```
{
  "sub": "glysns",
  "name": "GLEYSON SAMPAIO",
  "roles": ["USERS","MANAGERS"]
}
```
- **Signature:** para criar a parte da assinatura, você deve pegar o cabeçalho codificado, o payload codificado, a chave secreta, o algoritmo especificado no cabeçalho e assiná-lo.
 
## Spring Security + JWT
O Spring Boot utiliza a autenticação JWT para proteger uma API REST.
  
**Criar um projeto**
1. No [Spring Initializr](https://start.spring.io/)
2. Com as dependências: **Spring Web, Spring Security, Spring DATA JPA** e **H2 Database**
3. Download, extrair e importar na IDE
4. Confirmar no pom.xml as dependências e adicionar a dependência do JWT
```
<!-- JWT -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.7.0</version>
		</dependency>
```
5. Criar a classe de modelo model.User.java
6. Criar getters and setters para a classe
7. Criar a classe de repositório repository.UserRepository.java
8. Criar a classe contendo a regra de negócio service.UserService.java
9. Criar a classe que disponibiliza um recurso HTTP para cadastrar um usuário, controller.UserController.java
10. Configurar o JWT no projeto
	1. **security.JWTObject**: Classe que representará um objeto para gerar o token
	2. **security.SecurityConfig**: Classe componente que receberá as propriedades e credenciais do token via `application.properties`
	3. **security.JWTCreator**: Classe responsável por gerar o Token com base no Objeto e vice-versa
	4. **security.JWTFilter**: Classe que possui toda a lógica de validação quanto a integridade do token
	5. **security.WebSecurityConfig**: Classe responsável por centralizar toda configuração de segurança da API
11. Adicionar algumas configurações de banco de dados para visualizar o H2 Database na WEB
```
##H2 Database Connection Properties
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.show-sql: true
spring.h2.console.enabled=true
```
12. Habilitar usuários - Para incluir um usuário vamos executar um POST: http://localhost:8080/users passando o json no body.
	- No POSTMAN, Body, raw, text -> JSON
```
{"name":"INGRA", "username":"ingrarib", "password":"jwt123","roles":["USERS","MANAGERS"]}
```
13. Gerando o TOKEN
	1. **dto.Login**: Classe que receberá os dados para a realização do Login na aplicação.
	2. **dto.Sessao**: Classe que representa uma sessão do sistema contento o token gerado.
	3. **controller.LoginController**: Esta classe terá o recurso de realizar o login e geração do token
	4. No POSTMAN, Body, raw, text -> JSON (username + password)
14. Visualizar o token em https://jwt.io/
15. Testando o Token
	1. **controller.WelcomeController**: Classes com algumas operações de nossa API

### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades:  
|  Pacote | Descrição   |
| ------------ | ------------ |
| model  | Camada que contém as entidades da aplicação   |
| dto | Camada que contém os dtos da aplicação  |
| repository  | Camada que contém os repositórios com base no Spring Data JPA  |
| service | Camada que detém da regra de negócio e comunicação com a base de dados via repositorys   |
| controller  | Camada que contém os recursos https expostos na API  |
| security  | Camada responsável para toda configuração de segurança.  |
  
Classes Utilitárias:  
| Classe  | Descrição  |
| ------------ | ------------ |
| SwaggerConfig  | Classe responsável pela documentação da API  |
| JWTObject  | Classe que representa um Objeto correspondente a estrutura JWT  |
| JWTCreator  | Classe responsável por gerar o Token com base no Objeto e ou instanciar o Objeto JWT com base no Token  |  



## Links Úteis
https://glysns.gitbook.io/spring-framework/spring-security 

## Agradecimentos
[Professor Gleyson Sampaio](https://www.linkedin.com/in/glysns/)
  

