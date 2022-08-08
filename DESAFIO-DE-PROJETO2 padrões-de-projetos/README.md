# Desafio de projeto 2 - Padrões de projetos
## Objetivos
Explorar e compreender o que são padrões de projetos e como utilizá-los na prática.

## Definição
Padrões de projetos são soluções consolidadas para problemas recorrentes no desenvolvimento e manutenção de software orientado a objetos.

#### Classificações:
- **Padrões Criacionais:** *Abstract Factory, Builder, Factory Method, Prototype, **Singleton***.
- **Padrões Comportamentais:** *Chain of Responsability, Iterator, Observer, **Strategy**, Template Method*.
- **Padrões Estruturais:** *Adapter, Bridge, Composite, Decorator, **Facade**, Flyweight, Proxy*.
  
#### Principal referência: 
Livro ***Design Patterns: Elements of Reusable Object-Oriented Software*** (1995) - Gamma, Helm, Johnson and Vlissides (*Gang of Four*)

## Ferramentas e Tecnologias utilizadas
- Java
- Spring Framework
- Spring Initializr

## Spring Framework
- ***Singleton***: @Bean e @Autowired
- ***Strategy***: @Service e @Repository
- ***Facade***: construção de uma API REST com o objetivo desse padrão, abstrair a complexidade das seguintes integrações:
	- Spring Data JPA: em memória (usando o "h2")
	- ViaCEP (Feign)

- localhost - http://127.0.0.1:8080/swagger-ui/index.html

## Links Úteis
- https://viacep.com.br/

## Agradecimentos
[Professor Venilton FalvoJr](https://www.linkedin.com/in/falvojr/)