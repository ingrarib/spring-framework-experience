# Conhecendo o Projeto Spring Data JPA na Prática
## Objetivos
Conhecer os principais conceitos de mapeamento objeto relacional (ORM) usando o Spring DATA JPA.
Desenvolver uma API RESTful com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.

## Ferramentas e Tecnologias utilizadas
- Spring Boot
- PostgreSQL
- IDE IntelliJ
- Java 11
- Maven
- Hibernate Validator
- Lombok
- Postman
- CRUD

## Como o fluxo Back-end funcionará
Client (Postman) fará solicitação para o controller que por sua vez terá o Service injetado, o Service vai implementar o Repository e a camada Repository terá o contato com o BD para retornar dados e fazer updates.  


## ANOTAÇÔES DE MAPEAMENTO

**@Entity**- Usada para especificar que a classe anotada atualmente representa um tipo de entidade.

**@Table**- Usada para especificar a tabela principal da entidade atualmente anotada.

**@Id**- Especifica o identificador da entidade. Uma entidade deve sempre ter um atributo identificado.

**@GeneratedValue**- Especifica que o valor do identificador de entidade é gerado automaticamente.

**@Column**- Usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados.

**@JoinColumn**- Usada para especificar a coluna FOREIGN KEY. Indica que a entidade é a responsável pelo relacionamento.

**@OneToMany**- Usada para especificar um relacionamento de banco de dados um-para-muitos.

**@OneToOne**- Usada para especificar um relacionamento de banco de dados um-para-um.

**@ManyToOne**- Usada para especificar um relacionamento de banco de dados muitos-para-um.

**cascade**- Realizar operações em cascata só faz sentido em relacionamentos Pai - Filho.

**mappedBy**- Indica qual é o lado inverso 

## Agradecimentos
[Professora Camila Cavalcante](https://www.linkedin.com/in/cami-la/)