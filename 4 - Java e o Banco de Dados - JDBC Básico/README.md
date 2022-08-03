# Java JDBC Básico
**Banco de Dados**  
Um Banco de Dados (BD) armazena dados de forma estruturada, tornando o acesso e atualização dos dados mais rápido, pois aumenta a eficiência computacional (menor "gasto" de memória, processamento e tempo).  

## JDBC e drivers de conexão
**JDBC(Java Database Connectivity)** é uma **API** com diversas classes e interfaces escritas na linguagem Java que estão presentes nos pacotes java.sql e javax.sql. Elas permitem que programas em Java realizem conexões em bancos de dados para realizar consultas. Uma dessas classes principais é o **driver JDBC** que intermedia essa interação.  
  
Sem a API JDBC, seria necessário conhecer o protocolo proprietário de cada banco de dados para se conectar e realizar consultas. Já com a API JDBC, é utilizada somente **UMA** interface Java para qualquer banco de dados, deixando o driver implementar as especificações de cada banco de dados, enquanto o desenvolvedor se preocupa apenas em selecionar um driver e cirar as queries (neste caso, consultas SQL).  
   
### Classes e interfaces:
- Classe **DriverManager**- Responsável pela comunicação com os drivers disponíveis. É utilizada para cirar uma Connection com o banco de dados através de uma URL (que especifica driver, localização do BD e nome do BD).
- Interface **Connection**- Representa a conexão com o banco de dados. Permite criar "*Statements*" que constroem consultas SQL.

### Consultas com JDBC
Existem 3 interfaces para montar comandos SQL:
- Statement - Executar SQL comuns
- PreparedStatement - Executar SQL parametrizáveis
- CallableStatement - Exevutar stored procedures


#### IMPORTANTE!!
1. Preferir **PreparedStatement** ao **Statement** quando for parametrizar a consulta pois:  
- Previne SQL Injection
- Melhora legibilidade
- Melhora desempenho

2. Existem 3 métodos para executar comandos SQL:
- **execute** - Pode executar qualquer tipo de SQL
- **executeQuery** - Usado para executar "SELECT"
- **executeUpdate** - Usado para comandos de alteração de banco de dados (INSERT, UPDATE, DELETE, CREATE, ALTER)
  
**ResultSet** - objeto que contem os dados de uma determinada consulta no banco de dados (normalmente com SELECT).  
  
São utilizados os métodos getters para buscar dados do ResultSet. Tais como: **getInt, getFloat** e **getString**.  
  
O método **next**() é utilizado para percorrer os registros do ResultSet. (**Normalmente utilizado junto com while**).

# Java JPA Básico
**Problemas identificados:**
- Problema de produtividade: maior parte do tempo era gasto com **queries SQL** através do JDBC.
- Problema Mudança de Paradigma: a programação orientada a objetos (Java) é diferente do esquema entidade relacional (SGBDs tradicionais), sendo necessário esquematizar dois modelos para um mesmo sistema.
## Entendendo o JPA
Como solução para esses 2 problemas, foi proposto um modelo de mapeamento chamado **Mapeamento Objeto Relacional** (ORM) para representar tabelas de um banco de dados relacional através de classes Java.  
  
**Exemplos de mapeamentos:**
- Tabela -> Classe
- Coluna -> Atributo
- Registro -> Objeto
  
Para padronizar as interfaces das implementações ORM foi cirada uma ESPECIFICAÇÃO oficial chamada JPA (Java Persistence API). Ela descreve como deve ser o comportamento dos frameworks Java ORM que desejarem implementar a sua especificação.  
Logo, somente com a especificação JPA não será possível executar operações entre a aplicação e o banco de dados.  
  
O JPA possui algumas classes, interfaces e anotações que ajudam o desenvolvedor a abstrair o código.  
- Estão presentes no pacote **javax.persistence** - ajudam a manter o código independente da implementação utilizada.

### Principais artefatos do JPA
- Anotação @Entity - indica a aplicação que os objetos da classe especificada serão persistidos no banco de dados.
	- Também podem ser utilizadas outras anotações para auxiliar no mapeamento da classe, tais como: @id, @column, @table, @OneToMany e @ManyToOne,
- Interface EntityManager - utilizada para gerenciar o ciclo de vida das entidades.
	- Principais métodos utilizados são: find, persist e remove.
### Principais anotações utilizadas junto com a annotation **@Entity**
- @Table - anotação opcional, será necessária caso o nome da entidade seja diferente do nome da tabela no banco de dados.
- @Column - anotação opcional, será necessária caso os atributos da entidade sejam diferentes das colunas do banco de dados.
- @Id - é obrigatório especificar ao menos uma ID!!
### Anotações de relacionamento
A propriedade "**fetch**" exige atenção especial do desenvolvedor. Seus possíveis valores são **eager** (ansioso) ou **lazy** (preguiçoso). Suas características são:
- Eager - a entidade mapeada com esse atributo SEMPRE será carregada na aplicação quando a entidade que está mapeando for consultada, mesmo que nunca seja utilizada durante a execução da aplicação.
- Lazy - a entidade mapeada com esse atributo SOMENTE será carregada na aplicação quando esta for explicitamente consultada pela entidade que está mapeando.
  
#### Para persistir dados com as entidades mapeadas é obrigatório inicar uma transação. Para manipular transações, é necessário utilizar o seguinte método do **entityManager**:
- getTransaction - Retorna uma EntityTransaction, sendo obrigatório o seu uso quando utilizar algum método que realize alterações no banco de dados. Pode utilizar os seguintes métodos:
	- begin - Inicia uma transação;
	- commit - Finaliza uma transação, **persistindo** todos os dados que foram modificados desde o início da transação.
	- rollback - Finaliza uma transação, **revertendo** todos os dados que foram modificados desde o início da transação.

### Principais métodos do entityManager para interagir com as entidades
- find - Retorna a entidade que está persistida no banco de dados através da sua chave primária;
- persist - Persiste a entidade no banco de dados;
- remove - Apaga a entidade do banco de dados.

### Passos para utilizar o JPA na sua aplicação
1. Realizar download do JPA e do driver JDBC para o BD MySQL (Manualmente ou pelo Gradle ou Maven)
2. Criar arquivo persistence.xml
3. Configurar parâmetros (URL da string de conexão, driver, endereço do BD, nome do BD, usuário do BD, senha do BD, driver e classes que serão mapeadas)
4. Utilizar as anotações nas classes que serão mapeadas para uso do Hibernate
5. Configurar o entityManager 
## Links Úteis
[ARTIGO DIO SOBRE MySQL](https://web.dio.me/articles/introducao-ao-mysql?page=1&order=oldest)
  
[Aula extra realizada para entender o MySQL](https://web.dio.me/course/mysql-trabalhando-com-as-suas-primeiras-tabelas/learning/85acd077-edce-468e-977c-5b6f328e7c55?back=/home)

[Baixar MySQL](https://dev.mysql.com/downloads/) 

[Tutorial Instalação no Windows](https://www.devmedia.com.br/instalando-e-configurando-a-nova-versao-do-mysql/25813)

[Tutorial Instalação Linux](https://github.com/danielkv7/jdbc-basico/blob/master/src/main/java/part1/DatabaseInstructions)

## Agradecimentos
[Professor Daniel Karam](https://www.linkedin.com/in/daniel-kv/)  
[Repositório da Aula sobre JDBC do Professor](https://github.com/danielkv7/jdbc-basico)  
[Repositório da Aula sobre JPA do Professor](https://github.com/danielkv7/jpa-basico)  