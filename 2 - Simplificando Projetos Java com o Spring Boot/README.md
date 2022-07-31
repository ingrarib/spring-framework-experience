# Spring Framework 
**O que é o Spring?**  
  
Spring nada mais é que uma plataforma com diversos recursos para construção de aplicativos Java, facilitando assim o desenvolvimento em Java EE com módulos que facilitam a construção de *softwares* reduzindo o tempo de desenvolvimento.  
   
Arquitetura do Spring Framework: 															  
- Data Access / Integration (JDBC, ORM, OXM, JMS, Transactions)
- Web (WebSocket, Servlet, Web, Portlet)
- AOP 
- Aspects
- Instrumentation
- Messaging
- Core Container (Beans, Core, Context, SpEL)
- Test
   
## Beans

Um bean se trata de um objeto que é instanciado, montado e gerenciado por um containerdo Spring através de Inversão de Controle (IoC) e Injeção de Dependências (DI).  
  
**CICLO DE VIDA DE UM BEAN**  
1. Container é iniciado
2. Bean é instanciado
3. Dependências são injetadas
4. Chamada do método de inicialização
5. Bean é utilizado
6. Bean é descartado
7. Repete

### Configurando Beans

É possível configurar um Bean de duas formas por arquivos XML ou através de anotações.  
  
Em XML seria preciso definir a tag <bean> dentro de uma tag principal <beans> passando o path da classe assim o Spring saberá quais classes gerenciar a criação de instâncias e a injeção de dependências.  

### BeanFactory ou ApplicationContext?
- BeanFactory fornece um mecanismo de configuração avançada capaz de gerenciar objetos de qualquer natureza.
- ApplicationContext se baseia na BeanFactory (é uma subinterface) e adiciona outras funcionalidades, como integração mais fácil com recursos AOP do Spring, manipulação de recursos de mensagem (para uso na internacionalização), propagação de eventos e contextos específicos da camada de aplicativo, como WebApplicationContext para uso em aplicativos web.

## Inversão de Controle (IoC)

É um processo onde se inverte o fluxo de comando de um programa. É uma ideia desacoplar ou remover dependências do objeto e fornecer controle para outra camada. Este objeto delega a tarefa de construir dependências para um contêiner IoC.   
  
## Injeção de Dependência (DI)
  
Define quais classes serão instanciadas e onde serão injetadas quando for necessário. Existem três formas de aplicar o DI, por injeção de construtor, setter e interface. O Spring Framework aplica a IoC quando necessário também utilizando o DI.  
  
# Spring Boot
**O que é o Spring Boot?**  
  
O Spring Boot é uma extensão do Spring, que utiliza do Spring Framework para iniciar uma aplicação de forma simples e rápida, sem se preocupar com configurações complexas como, por exemplo, o Tomacat.  
  
Componentes base do Spring Boot:   															  
- Spring Boot Starter;
- Spring Boot Auto-Configuration;
- Spring Boot Actuator;  
  
**Como o Spring Boot Funciona?**  
  
Em resumo o Spring Boot é como um template pré-configurado para desenvolvimento e execução de aplicações baseadas no Spring.  
Onde, temos uma arquitetura baseada no Spring Core, que traz os componentes-base do Spring, como o mecanismo de DI/IoC, a *Spring Expression Language* (SpEL) e alguns módulos-base do Spring AOP (módulo para implementação de programação orientada a aspectos no Spring).  
  
- O spring Boot permite adicionar a estrutura-base o que é chamado de módulo.
- Um módulo é na verdade uma biblioteca ou ferramenta do ecossistema Spring que pode ser adicionada a uma aplicação Spring convencional. 

### Motivação do Spring Boot
- Facilitar a vida do desenvolvedor Java
- Melhorar a produtividade do desenvolvimento de softwares
- Maior foco na parte realmente importante que envolve as regras de negócio e código.

## [Spring Initializr](https://start.spring.io/)

Fornece uma API extensível para gerar projetos baseados em JVM (*Java Virtual Machine*), é onde podemos criar um projeto Spring Boot de forma rápida e fácil.  
  
**PASSO-A-PASSO**  
1. Escolher tipo do projeto (Maven)
2. Escolher a linguagem (Java)
3. Selecionar última versão estável
4. Nomear Group, Artifact
5. Descrição
6. Selecionar Packaging
7. Selecionar sua versão do Java
8. Adicionar dependências (geralmente web)
9. Gerar arquivo e extrair 
10. Se já houver projeto, copiar apenas o pom.xml
11. Importar na IDE

## Auto-configuration
**@SpringBootApplication**  
  
O Auto-configuration ou configuração automática do Spring Boot configura automaticamente a aplicação Spring com base nas dependências jar que adicionamos ao projeto.  
  
Para habilitar o recurso existe a anotação **@EnableAutoConfiguration**, mas essa não é usada porque está contida no **@SpringBootApplication**.  
A anotação **@SpringBootApplication** é a combinação de três anotações:  
- **@ComponentScan**
- **@EnableAutoConfiguration**
- **@Configuration**

# Dependências e bibliotecas
## Swagger
Projeto open source com diversas ferramentas utilizadas para desenvolver APIs com especificação OpenAPI Specification (OAS), uma especificação para descrever, produzir, consumir e visualizar serviços de uma API REST. Com o OAS você poderá descrever recursos, URIs, modelo de dados, métodos HTTP aceitos e códigos de resposta.  
Tudo isso facilita a vida dos desenvolvedores de diversas linguagens de programação na criação, testes, consumo e documentação de **APIs REST**.  
   
[Exercício](https://github.com/Re04nan/dio-experts-spring-boot-java/blob/master/personapi/src/main/java/com/digitalinnovatione/personapi/config/SwaggerConfig.java)  
1. Adicionar dependência no pom.xml
2. Na pasta src/main/java criar Package .config
3. Criar classe SwaggerConfig
4. Adicionar @Configuration e @EnableSwagger2
5. Criar método java (private ApiInfo)
6. Importar dependência ApiInfo
7. Importar dependência ApiInfoBuilder
8. Adicionar informações desejadas à API
9. Criar método java (public Docket)
10. Importar dependência Docket
11. Adicionar @Bean
12. Adicionar informações desejadas 
  
## Feign
É um cliente de serviço web declarativo (cliente HTTP) desenvolvido pela Netflix e um dos mais populares do Spring Cloud Component. Com ele é possível criar clientes API HTTP no java de forma mais simples para chamar/consumir os serviços REST, utilizando anotações.  
Para usar o Feign, precisamos adicionar a dependência **spring-cloud-starter-openfeign** no arquivo pom.xml.  
  
[Exercício](https://github.com/Re04nan/dio-experts-spring-boot-java/tree/master/utilizandoFeign)    
1. Adicionar dependência lombok e openfeign no pom.xml
2. Na pasta src/main/java criar Package 
3. Criar classe 
4. Adicionar @Data e @Builder
5. Criar método java (private)
6. Criar classe Controller
7. Adicionar @RestController e @RequestMapping("*primeira classe*")
8. Criar método java (public)
9. Adicionar informações desejadas
10. Adicionar @GetMapping
11. Trocar a porta -> pasta application.properties -> server.port=3000
12. Notação para habilitar o Feign @EnableFeignClients
13. Adionar Interface para consumir API
14. Adicionar @FeignClient(name=" ", url="http://localhost:... ")
15. Adicionar @RequestMapping(method = RequestMethod.GET, value="/")
16. Criar classe Controller (mesmos passos)
17. Criar método (public)
18. Injeção da dependência e @Autowired

# Spring Boot Test

O Spring Boot facilita o desenvolvimento de testes de unidade e integração com o Spring Boot Test, um recurso bastante utilizado no desenvolvimento de aplicações java para testar comportamentos do código e regras do negócio.  
  
Para utilizarmos precisamos usar **spring-boot-starter-test**, que importa os módulos de teste Spring Boot, bem como **JUnit Jupiter**, **AssertJ**, **Hamcrest** e várias outras bibliotecas úteis.  
  
**Importância do Teste**  
Em desenvolvimento de software, os erros podem aparecer em qualquer etapa do ciclo de vida do projeto. Com isso, o teste de software se torna essencial e não pode ser visto como uma atividade opcional, pois oferece os métodos e ferramentas necessárias para garantir a qualidade de qualquer desenvolvimento.  
  
## Testes Unitários
Os testes unitários é a base da [pirâmide de testes](https://lh5.googleusercontent.com/X-68m7pb9ZTvyya78WrLIwz9331GbhAHFziKDHaW-fXdqAxCMZFjmlWx1GM0TepbuvZn9ARWvotBn05WmWsNznDjxFmkslFab7IKxh8ghhPdM4t-f380m--Hbx4gqejRkYVh1jwZ) onde são realizados o maior número de testes ou deveria para garantir a fidelidade do código e regras do negócio.  
  
[Exercício](https://github.com/Re04nan/dio-experts-spring-boot-java/tree/master/springboottest)  
1. Criar classe TestController
2. Adicionar @RestController
3. Criar método (public)
4. Adicionar @GetMapping("/test")
5. Em src/test/java criar classe para teste (TestUnitController)
6. Criar método (public void)
7. Adicionar @Test
8. Instanciar a classe Controller
9. Criar String resultado que recebe o controller
10. Comparação do resultado esperado com o obtido (*assertEquals*)
11. Rodar teste

## Links Úteis

https://spring.io/projects

## Agradecimentos

[Professor Renan Marques](https://www.linkedin.com/in/renan-marques-dev/)
