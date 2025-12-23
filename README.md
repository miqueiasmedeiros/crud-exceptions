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

