# 🍽️ Sistema de Menu para Restaurante

Aplicação web desenvolvida como trabalho acadêmico utilizando Java Spring Boot no back-end, React com TypeScript no front-end e MySQL como banco de dados.

---

## Funcionalidades

### Área de Gerenciamento

- Cadastrar produtos
- Editar produtos
- Excluir produtos
- Listar todos os produtos
- Ativar ou desativar produtos

### Área do Cliente

- Visualizar apenas produtos disponíveis
- Adicionar produtos ao carrinho
- Finalizar pedidos
- Persistir pedidos no banco de dados

---

## Tecnologias Utilizadas

### Back-end

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- MySQL

### Front-end

- React
- TypeScript
- Vite
- Axios
- React Query

### Banco de Dados

- MySQL

---

## Estrutura do Projeto

### Back-end

```text
src/main/java

├── controller
├── dto
├── entity
├── repository
└── service
```

### Front-end

```text
src

├── pages
├── hooks
├── services
├── contexts
├── types
└── routes
```

---

## Script de Criação do Banco

```sql
CREATE DATABASE restaurante;

USE restaurante;
```

As tabelas são criadas automaticamente pelo Hibernate.

---

## Configuração do Banco

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurante
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Como Executar

## Back-end

```bash
./mvnw spring-boot:run
```

ou execute a classe principal pelo IntelliJ.

API:

```
http://localhost:8080
```

---

## Front-end

```bash
npm install
npm run dev
```

Aplicação:

```
http://localhost:5173
```

---

# Documentação da API

## Produtos

### Listar todos

**GET**

```
/produtos
```

### Resposta

```json
[
  {
    "id": 1,
    "nome": "X-Burger",
    "descricao": "Hambúrguer artesanal",
    "preco": 29.90,
    "ativo": true
  }
]
```

---

### Listar somente ativos

**GET**

```
/produtos/ativos
```

### Resposta

```json
[
  {
    "id": 1,
    "nome": "X-Burger",
    "descricao": "Hambúrguer artesanal",
    "preco": 29.90,
    "ativo": true
  }
]
```

---

### Criar produto

**POST**

```
/produtos
```

### Body

```json
{
  "nome": "Pizza Calabresa",
  "descricao": "Pizza grande de calabresa",
  "preco": 59.90,
  "ativo": true
}
```

### Resposta

```json
{
  "id": 3,
  "nome": "Pizza Calabresa",
  "descricao": "Pizza grande de calabresa",
  "preco": 59.90,
  "ativo": true
}
```

---

### Atualizar produto

**PUT**

```
/produtos/{id}
```

### Body

```json
{
  "nome": "Pizza Portuguesa",
  "descricao": "Pizza com presunto, ovos e cebola",
  "preco": 64.90,
  "ativo": true
}
```

---

### Excluir produto

**DELETE**

```
/produtos/{id}
```

Resposta:

```
204 No Content
```

---

# Pedidos

## Finalizar Pedido

**POST**

```
/pedidos/finalizar
```

### Body

```json
{
  "cliente": "Luis Henrique",
  "itens": [
    {
      "produtoId": 1,
      "quantidade": 2
    },
    {
      "produtoId": 4,
      "quantidade": 1
    }
  ]
}
```

### Resposta

```json
{
  "id": 15,
  "cliente": "Luis Henrique",
  "valorTotal": 119.70,
  "data": "2026-06-30T19:45:21",
  "status": "FINALIZADO"
}
```

---

# Testando no Postman

Importe as requisições abaixo.

## Criar Produto

```
POST http://localhost:8080/produtos
```

Headers

```
Content-Type: application/json
```

Body

```json
{
  "nome": "Pizza Quatro Queijos",
  "descricao": "Molho, mussarela, parmesão, provolone e gorgonzola",
  "preco": 72.90,
  "ativo": true
}
```

---

## Atualizar Produto

```
PUT http://localhost:8080/produtos/1
```

Body

```json
{
  "nome": "Pizza Quatro Queijos Grande",
  "descricao": "Borda recheada",
  "preco": 79.90,
  "ativo": true
}
```

---

## Buscar Produtos

```
GET http://localhost:8080/produtos
```

---

## Buscar Produtos Ativos

```
GET http://localhost:8080/produtos/ativos
```

---

## Excluir Produto

```
DELETE http://localhost:8080/produtos/1
```

---

## Finalizar Pedido

```
POST http://localhost:8080/pedidos/finalizar
```

Body

```json
{
  "cliente": "Luis Henrique",
  "itens": [
    {
      "produtoId": 2,
      "quantidade": 1
    },
    {
      "produtoId": 3,
      "quantidade": 2
    }
  ]
}
```

---

# Autor

**Luis Henrique Machado**

Projeto desenvolvido para a disciplina de Desenvolvimento Web utilizando Java Spring Boot, React e MySQL.
