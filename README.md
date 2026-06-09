# 🍽️ Sistema de Menu para Restaurante

Aplicação web desenvolvida como trabalho acadêmico utilizando Java Spring Boot no back-end, React com TypeScript no front-end e MySQL como banco de dados.

## Funcionalidades

### Área de Gerenciamento

* Cadastrar produtos
* Editar produtos
* Excluir produtos
* Listar todos os produtos
* Ativar ou desativar produtos

### Área do Cliente

* Visualizar apenas produtos disponíveis
* Adicionar produtos ao carrinho
* Finalizar pedidos
* Persistir pedidos no banco de dados

## Tecnologias Utilizadas

### Back-end

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Lombok
* MySQL

### Front-end

* React
* TypeScript
* Vite
* Axios
* React Query

### Banco de Dados

* MySQL

## Estrutura do Projeto

### Back-end

```
src/main/java

├── controller
├── dto
├── entity
├── repository
└── service
```

### Front-end

```
src

├── pages
├── hooks
├── services
├── contexts
├── types
└── routes
```

## Script de Criação do Banco

```sql
CREATE DATABASE restaurante;

USE restaurante;
```

> As tabelas são criadas automaticamente pelo Hibernate ao iniciar a aplicação.

## Configuração do Banco de Dados

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurante
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Como Executar o Back-end

1. Abrir o projeto no IntelliJ IDEA.
2. Configurar o banco MySQL.
3. Ajustar usuário e senha do banco no arquivo `application.properties`.
4. Executar a classe principal do Spring Boot.

A API estará disponível em:

```
http://localhost:8080
```

## Como Executar o Front-end

Instalar as dependências:

```bash
npm install
```

Executar o projeto:

```bash
npm run dev
```

A aplicação estará disponível em:

```
http://localhost:5173
```

## Principais Endpoints

### Produtos

```http
GET /produtos
```

Lista todos os produtos.

```http
GET /produtos/ativos
```

Lista apenas os produtos disponíveis.

```http
POST /produtos
```

Cria um novo produto.

```http
PUT /produtos/{id}
```

Atualiza um produto.

```http
DELETE /produtos/{id}
```

Remove um produto.

### Pedidos

```http
POST /pedidos/finalizar
```

Finaliza uma compra e salva o pedido no banco de dados.

## Autor

Luis Henrique Machado

Trabalho desenvolvido para a disciplina de Desenvolvimento Web.
