CREATE TABLE cliente (
    id CHAR(36) NOT NULL PRIMARY KEY,         -- UUID como string
    cpf BIGINT UNIQUE NOT NULL,               -- CPF único
    email VARCHAR(255) UNIQUE NOT NULL,       -- Email único
    nome VARCHAR(255) NOT NULL,               -- Nome do cliente
    cidade VARCHAR(100),                      -- Cidade
    senha VARCHAR(255) NOT NULL,              -- Senha (deve ser armazenada com hash!)
    idade INT                                 -- Idade
);

CREATE TABLE carro (
    id CHAR(36) NOT NULL PRIMARY KEY,       -- UUID como string
    modelo VARCHAR(100) NOT NULL,           -- Modelo do carro
    cor VARCHAR(50),                        -- Cor do carro
    ano INT NOT NULL,                       -- Ano de fabricação
    cidade VARCHAR(100),                    -- Cidade
    proprietario VARCHAR(255),             -- Nome do proprietário (pode virar chave estrangeira depois)
    placa VARCHAR(36) UNIQUE NOT NULL,      -- Placa única
    status_carro VARCHAR(20) NOT NULL
);

CREATE TABLE aluguel (
    id CHAR(36) NOT NULL PRIMARY KEY,                    -- UUID
    cliente BIGINT NOT NULL,                           -- Referência ao ID do cliente
    carro VARCHAR(36) NOT NULL,                             -- Referência ao ID do carro
    cidade VARCHAR(100),                                 -- Cidade do aluguel
    tempo_aluguel INT NOT NULL,                          -- Tempo em dias, horas ou como preferir
    data_hora_inicio DATETIME NOT NULL,                  -- Início do aluguel
    data_hora_fim DATETIME NOT NULL,                     -- Fim do aluguel
    status_aluguel VARCHAR(20) NOT NULL,

    FOREIGN KEY (cliente) REFERENCES cliente(cpf),  -- Repare que mudou para cpf
    FOREIGN KEY (carro) REFERENCES carro(placa)
);