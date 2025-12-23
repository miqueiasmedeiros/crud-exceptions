# 📘 CRUD com Exceptions

Um projeto Java Spring Boot que implementa um **CRUD simples para gerenciamento de usuários**, com foco em **tratamento de exceções em uma API REST**.

Este projeto foi criado com o objetivo de praticar conceitos importantes de backend, como:
- Tratamento correto de erros
- Uso adequado de códigos HTTP
- Exceções customizadas
- Arquitetura em camadas

---

## 🚀 Funcionalidades

A API disponibiliza as seguintes operações:

- ✅ Criar usuário
- 🔍 Buscar usuário por email
- 🔍 Buscar usuário por ID
- ✏️ Atualizar usuário
- 🗑️ Deletar usuário por email
- 🗑️ Deletar usuário por ID

Além disso:
- Retorna **404 Not Found** quando o usuário não existe
- Evita retornos genéricos de erro **500**
- Retorna mensagens claras para o cliente

---

## 🛠 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Lombok**
- **Maven**
- **Banco de Dados** (configurado via `application.properties`)

---

## 📦 Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── dev/
    │           └── cadastro_usuario/
    │               ├── controller/
    │               ├── business/
    │               ├── infrastructure/
    │               │   ├── entitys/
    │               │   ├── repository/
    │               │   ├── exceptions/
    │               │   └── handle/
    │               └── CadastroUsuarioApplication.java
    └── resources/
        └── application.properties
```

- **Controller** → recebe as requisições HTTP
- **Service (business)** → contém a regra de negócio
- **Repository** → acesso ao banco de dados

---

## ▶️ Como Executar o Projeto

#### 1️⃣ Clone o repositório

```bash
git clone https://github.com/miqueiasmedeiros/crud-exceptions.git
```
#### 2️⃣ Acesse o diretório

```bash
cd crud-exceptions
```
#### 3️⃣ Execute a Aplicação

```bash
mvn spring-boot:run
```

#### 📌 Exemplos de Endpoints


| Método | Endpoint               | Descrição                  |
| ------ |------------------------|----------------------------|
| GET    | `/usuario/{id}`        | Busca usuário por ID       |
| GET    | `/usuario?email=email` | Busca por email            |
| POST   | `/usuario`             | Cria novo usuário          |
| PUT    | `/usuario?email=email` | Atualiza usuário por email |
| DELETE | `/usuario/{id}`        | Remove registro por ID     |

A API estará disponível em http://localhost:8080

### ⚠️ Exemplo de Resposta de Erro

Quando um recurso não é encontrado, a API retorna um status 404 Not Found com o seguinte corpo:
```bash
{
    "timestamp": "2025-12-23T06:53:15.910954748",
    "status": 404,
    "error": "Not Found",
    "message": "Email não encontrado."
}
```

### Melhorias para o projeto

- **Documentação com Swagger/OpenAPI:** Configurar o Swagger UI para documentar visualmente os endpoints e facilitar os testes da API.

- **Exclusão Segura (ID + E-mail):** Refatorar o método de remoção para validar tanto o ID quanto o e-mail, garantindo maior precisão na deleção.

- **Validação de E-mail:** Implementar Bean Validation (@Email) para o formato e uma regra de negócio na Service para impedir e-mails duplicados.