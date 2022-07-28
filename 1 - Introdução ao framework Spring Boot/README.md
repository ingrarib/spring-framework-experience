# Introdução ao Framework Spring Boot
### Problemas do Spring
- Configurações de beans em arquivos xml.
- Dispatcher Servlet e view resolver em web.xml.
- Setup manual de Banco de Dados.
- Muito tempo gasto em configuração.
- Perda de foco em valor.

## O que é o Spring Boot?
- Criado pela Spring Source em 2012.
- Facilita setup de projetos Spring.
- Sem necessidade de criar arquivos de configuração.
- Foco em produtividade.
- Maior tempo no desenvolvimento de valor.

### Quais problemas resolve?
- Produtividade: setup simplificado de projeto
	- SpringInitializr (via Web ou IDE)
- Starters: dependências auto configuráveis pelo Spring Boot
- Execução simplificada: sem deploy em servidor externo
- Configurações: arquivo externo para configuração
	- application.properties
- Valor: maior tempo em desenvolvimento

### Exercício:
1. Criação de um projeto no site [spring initializr](http://start.spring.io)
2. Importar o projeto na IDE
3. Adiconar spring-boot-starter-mvc no pom.xml
4. Adicionar classe HelloController e o método hello().
5. Executar o projeto através do terminal.

### Auto Configuration
#### Configuração manual 
- Múltiplos Arquivos XML.
- Configurações manual do Spring MVC: Dispatcher Servlet, web.xml, spring-mvc.xml.
- Configuração manual dos beans Spring.
- Aplicado também ao Spring Data, Spring Security, etc.
#### Configuração automática
- Starters: dependências simplificadas e auto configuráveis.
- Identificação e configuração automática da dependência.

### FatJar/UberJar
- Artefato do projeto pronto para execução.
- Container web embutido na geração e execução (Tomcat).
- Deploy embarcado com outros containers são opcionais.
- Dependências principais do projeto embarcadas.
- Execução direta através de um único java -jar!

## Trabalhando com Profiles e Configuração
### Múltiplos ambientes
- Ambientes para desenvolvimento, teste e produção.
- Bancos de dados para cada ambiente.
- Suíte de testes completas em ambiente de teste.
- Simulação do ambiente real em staging.
- Deploy simplificado em produção.
### Spring Boot Profiles
- Configurações próprias pra cada ambiente.
- Ambientes com sua configuração: dev, production.

### Spring Boot Properties
**Exercício**  
- Projeto com spring.initialzr e importar na IDE.
- Arquivos application.properties pra dev e prod.
- Classe de configuração de BD e anotar com @Configuration.
- Mapear propriedades com @ConfigurationProperties.
- Criar métodos para instanciar Beans de cada env.
- Criar classe anotada com @RestController.
- Injetar propriedade appMessage com @Value.
- Criar método que retorna a mensagem acima.
- Executar projeto no browser.

### Configurações com YAML
- Troca no formato de configurações: formato .YML.

### Configurações com variáveis de ambiente
- Variável de ambiente pode ser injetada através da anotação @Vlue no projeto.
- Linux e Mac: export comum de variável.
- Windows: padrão de variável de ambiente.
- Injeção com anotação @Value ({NOME_VARIAVEL})
- Definição de valor default quando não há variável.



## Links pra estudo
[Entenda as configurações do Spring Boot!](https://devkico.itexto.com.br/?p=3157)

## Agradecimentos
[Professor Rodrigo Peleias](https://www.linkedin.com/in/rodrigopeleias/)