# 🚗 Web Locadora de Carros

Sistema web RESTful para gerenciamento de **clientes**, **carros** e **alugueis de veículos**, desenvolvido com **Java + Spring Boot** e persistência em banco de dados **MySQL**.

---

## 📚 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Flyway (migração de banco)
- Maven

---

## 🗄️ Banco de Dados

### Banco Utilizado

- **MySQL**
- Nome do banco: `location_cars`

### Estrutura das Tabelas

#### Tabela `cliente`

```sql
CREATE TABLE cliente (
    id CHAR(36) NOT NULL PRIMARY KEY,
    cpf BIGINT UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cidade VARCHAR(100),
    senha VARCHAR(255) NOT NULL,
    idade INT
);
```

#### Tabela `carro`

```sql
CREATE TABLE carro (
    id CHAR(36) NOT NULL PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    cor VARCHAR(50),
    ano INT NOT NULL,
    cidade VARCHAR(100),
    proprietario VARCHAR(255),
    placa VARCHAR(36) UNIQUE NOT NULL,
    status_carro VARCHAR(20) NOT NULL
);
```

#### Tabela `aluguel`

```sql
CREATE TABLE aluguel (
    id CHAR(36) NOT NULL PRIMARY KEY,
    cliente BIGINT NOT NULL,
    carro VARCHAR(36) NOT NULL,
    cidade VARCHAR(100),
    tempo_aluguel INT NOT NULL,
    data_hora_inicio DATETIME NOT NULL,
    data_hora_fim DATETIME NOT NULL,
    status_aluguel VARCHAR(20) NOT NULL,
    FOREIGN KEY (cliente) REFERENCES cliente(cpf),
    FOREIGN KEY (carro) REFERENCES carro(placa)
);
```

---

## 🚀 Funcionalidades da API

### 👤 Cliente

| Método | Endpoint              | Descrição                                 |
|--------|-----------------------|-------------------------------------------|
| POST   | `/`                   | Cadastra um novo cliente                  |
| DELETE | `/`                   | Remove um cliente pelo CPF                |
| GET    | `/buscarCliente`      | Busca um cliente pelo CPF                 |
| GET    | `/buscarAllClientes`  | Lista todos os clientes                   |

---

### 🚘 Carros

| Método   | Endpoint                   | Descrição                                        |
|----------|----------------------------|--------------------------------------------------|
| POST     | `/cadastrar`               | Cadastra um novo carro                          |
| GET      | `/listar`                  | Lista todos os carros                           |
| GET      | `/listarCarrosForStatus`   | Lista carros por status (`DISPONIVEL`, `ALUGADO`)|
| GET      | `/buscarCarrosNaCidade`    | Lista carros por cidade                         |
| GET      | `/buscarCarro`             | Busca um carro pela placa                       |
| DELETE   | `/remover`                 | Remove um carro pela placa                      |
| PATCH    | `/alterarVeiculo`          | Altera os dados de um carro                     |

---

### 📅 Aluguel

| Método | Endpoint                 | Descrição                                                                 |
|--------|--------------------------|---------------------------------------------------------------------------|
| POST   | `/cadastrarAluguel`      | Realiza o aluguel de um carro                                            |
| GET    | `/buscarCarrosAlugados`  | Lista todos os aluguéis **e** atualiza automaticamente os expirados para `FINALIZADO` |

---

## 📄 Enums e DTOs

### Enums

- **StatusCarro**:
    - `DISPONIVEL`
    - `ALUGADO`

- **StatusAluguel**:
    - `ATIVO`
    - `FINALIZADO`

### DTOs Usados

- `ClienteRequestDto`
- `ClienteResponseDTO`
- `CpfDto`
- `CarroCadastroRequestDTO`
- `CarroResponseDTO`
- `PlacaDto`
- `StatusCarroRequest`
- `CarroByCidade`
- `CadastroAluguel`

---

## ⚠️ Validações e Regras

- Um carro só pode ser alugado se estiver disponível.
- O mesmo cliente não pode alugar o mesmo carro duas vezes com aluguel ativo.
- O sistema verifica automaticamente a expiração do aluguel (comparando a `dataHoraFim` com o horário atual) e atualiza o status para `FINALIZADO`.

---

## 🔧 Configuração do `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/location_cars
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
```

---

## ✅ Melhorias Futuras

- Implementar autenticação e login (JWT)
- Dashboard administrativo (ex: React, Vue)
- Histórico de aluguel por cliente
- Notificações por e-mail de vencimento de aluguel

---

## 📬 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar sugestões, melhorias ou abrir issues.

---

## 📝 Licença

Este projeto é open-source e pode ser usado livremente para fins de aprendizado e desenvolvimento.
