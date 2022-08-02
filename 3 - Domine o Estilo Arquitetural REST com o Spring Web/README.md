# Domine o Estilo Arquitetural REST com o Spring Web
## Estilo Arquitetural REST
- Um estilo arquiteural é um conceito organizacional, central de um sistema. É o padrão de arquitetura que vai escrever como nosso sistema funciona e o padrão da Engenharia de Software que define o conceito de proeto que vamos construir o sistema.
- Trasferência de Estado Representacional (**Re**presentational **S**tate **T**ransfer.)
	- Abstração da arquitetura web, com princípios e definições para aplicações em projetos.
- Comunicação entre aplicações
- Flexibilidade  
  
**REST e RESTful**  
1. REST: representa um apanhado de princípios de arquitetura
2. RESTful: representa a condição de um sistema específico em aplicar os conceitos de REST  
  
### Expondo Endpoint REST
- Ponto de Extremidade: ponto de acesso ao nosso sistema, uma URL que deixamos disponível para determinados recursos.
- Endpoint vs API: API é um conjunto de endpoints e protocolos, é uma aplicação de endpoints.

### Exceptions Handlers
- @ControllerAdvice: é uma anotação, para lidar com as exceções globalmente
- @ExceptionHandler: é uma anotação usada para tratar as exceções específicas e enviar as respostas personalizadas ao cliente

## Spring Security
Spring Security é uma biblioteca que fornece proteção, autenticação, autorização e armazenamento de senhas.  
  
#### Proteção
1. Cross Site Request Forgery (CSRF)
2. Security HTTP Response Headers
3. HTTP
4. HTTP Firewall

#### Autenticação  
1. Usuário e Senha
2. OAuth2
3. SAML2
4. Outros
  
#### Autorização
Para autorização, o Spring Security se baseia nas Authorities do usuário que se autentica na aplicação

#### Vantagens 
1. Suporta autenticação e autorização
2. Proteção contra ataques
3. Integração de API Servlet
4. Integração opcional com Spring Web MVC

### Configurar Estratégias de autenticação
- **Basic Authentication**: é um esquema de autenticação simples integrado ao protocolo HTTP
	- O cliente (postman) envia a requisição HTTP e coloca um Header de autorização contendo a palavra *Basic* seguido de um espaço e usuário e senha (String codificada em base64) , que vamos cadastrar.
- **JWT**: JSON Web Token, é um método para realizar autenticação entre duas partes por meio de um token
	- Esse token é um código em Base64 que armazena objetos JSON com os dados que permitem a autenticação da requisição
	- O Cliente envia uma requisição no endpoint de autenticação e pega de retorno um token JWT
	- Com o token autenticado, o cliente agora tem que enviar o token com a palavra Bearer em todas as requisições que precisarem da autenticação
	- Mais seguro que a autenticação básica, requer um pouco mais de complexidade para gerar o token
- **OAuth 2.0**: é um protocolo que vai permitir aos usuários ter acesso limitado a recursos de um website sem precisar expor suas credenciais
	- Bem mais seguro e mais usado
	- Uma aplicação pede permissão de acesso para um usuário, sem que para isso ela tenha acesso a alguma senha dele
	- Exemplo: “Logar com sua conta do Google” ou “Logar com sua conta do Facebook”, para evitar de ter que fazer na mão algum cadastro. Neste caso, você está dando a autorização de uma aplicação terceira a usar os recursos da sua aplicação.

## Actuator, Métricas e Health Check
### O que é o Actuator?
O Actuator traz recursos prontos para produção para nossa aplicação.  
  
É usado principalmente para expor informações operacionais sobre o aplicativo em execução - integridade, métricas, informações, despejo, etc. Ele usa endpoints HTTP ou beans JMX para nos permitir interagir com ele.  
  
### Métricas com Actuator
- **Spring Boot Admin**- é um projeto da codecentric para Gerenciar e monitorar aplicações SpringBoot.
- https://github.com/codecentric/spring-boot-admin

### Health Check
Permite verificar a qualidade do serviço que implantamos: o Actuator é responsável por realizar os testes que verificam se não há alguma condição que esteja degradando ou mesmo impossibilitando a execução dos seus serviços.  
  
1. Verificar Disco
2. Checar serviços acessíveis
3. Banco de Dados

#### HealthIndicator

1. Métricas personalizadas
2. Maneiras diferentes de inspecionar status

## Spring Boot Test 

#### Testes Automatizados
O teste automatizado é um processo onde ferramentas executam testes pré-programados em um aplicativo de software.  
  
O objetivo do teste automatizado é simplificar o máximo possível do esforço de teste com um conjunto mínimo de códigos.   
  
Se o teste unitário consome uma grande porcentagem dos recursos de uma equipe de garantia de qualidade (QA), por exemplo, esse processo pode ser um bom candidato para automação.  
  
#### Testes Unitários
Os testes unitários procuram verificar a exatidão do código, em sua menor fração.  
  
### JUnit
JUnit é um framework que facilita o desenvolvimento e execução de testes unitários em código Java.  
  
Com o Junit podemos criar testes para verificar funcionalidades de classes e seus métodos.  
  
O Junit trabalha basicamente com anotações (Annotations). Essas anotações indicam se um método é de teste ou não, se um método deve ser executado antes da classe e/ou depois da classe, as anotações indicam também se o teste deve ou não ser ignorado e se a classe em questão é uma suite de teste, ou seja, se a partir desta classe é disparada a execução das demais classes de teste, entre outras anotações menos utilizadas.  
  
### @SpringBootTest
A anotação @SpringBootTest deve ser utilizada nas classes de testes para que o Spring inicialize o servidor e disponibilize os Beans da aplicação.  

### Testando Endpoints REST
#### MockMvc
Essa é a classe que faz um Mock, que simula uma requisição MVC, ele vai performar uma requisição:  
  
1. MockMvcRequestBuilders
2. MockMvcResultMatchers
  
Um pra construir a nossa requisição e o outro pra confirmar o retorno da requisição.  

## Repositório da aula
[REST-Spring](https://github.com/karantes/REST-Spring)
## Agradecimentos
[Professor Kaique Arantes](https://www.linkedin.com/in/kaique-arantes/)