# Persistência de dados JPA com Hibernate
## O QUE É JDBC?
Java Database Connectivity é um conjunto de classes e interfaces (API) escritas em Java que fazem o envio de instruções SQL para qualquer banco de dados relacional.  

## O que é um ORM?
Object Relational Mapper é uma técnica de mapeamento objeto relacional que permite fazer uma relação dos objetos com os dados que os mesmos representam.  

## O que é o JPA?
Java Persistence API é uma API padrão da linguagem Java que descreve uma interface comum para frameworks de persistência de dados. A JPA define um meio de mapeamento objeto-relacional para objetos Java simples e comuns.  

## JPA e Hibernate é a mesma coisa?
Hibernate é uma tecnologia, ela foi a primeira tecnlogia de ORM para Java. Com a popularização dela, a Oracle (empresa que mantia o Java na época) acabou por convidar os criadores do Hibernate para construírem o JPA que é uma espeficicação, indicando como deve ser implementado qualquer framework ORM para padronizar a forma com o desenvolvedor final trabalha com eles.  
  
Além do Hibernate um outro framework de JPA é o EclipseLink.  
### Por que utilizar o Hibernate?
- Faz mapeamento das tabelas do banco de dados com classes.
- Possui um pacote de classes uteis que facilitam o processo de interação com o Banco de dados, muitas das vezes não é necessário utilizar queries.
- No caso, de uma possível migração de banco de dados, não será necessário alterar nada no código. (Caso siga de forma integra as especificações do framework)

## Links Úteis
[Repositório JPA do professor](https://github.com/jpbaterabsb/jpa-dio)  
[Repositório JDBC do professor](https://github.com/jpbaterabsb/jdbc-dio)

## Agradecimentos
[Professor João Paulo Oliveira Santos](https://www.linkedin.com/in/desenvolvedorjoaopaulo/)