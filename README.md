# Conta Bancária

Sistema bancário de console em Java. Permite criar contas correntes e poupanças, consultar, atualizar, excluir e movimentar valores entre elas por meio de um menu interativo no terminal.

## Objetivo

Aplicar os pilares da Programação Orientada a Objetos — abstração, herança, polimorfismo e encapsulamento — junto com interfaces, coleções e tratamento de exceções, em um domínio fácil de visualizar.

## Funcionalidades

Menu com as opções:

1. Criar conta (corrente ou poupança)
2. Listar todas as contas
3. Buscar conta por número
4. Atualizar dados da conta
5. Apagar conta
6. Sacar
7. Depositar
8. Transferir valores entre contas
9. Sair

**Regras implementadas**

- **Conta corrente** possui limite: o saque é permitido enquanto `saldo + limite` cobrir o valor.
- **Conta poupança** registra o dia de aniversário da conta.
- Número da conta gerado automaticamente.
- Leitura de opções protegida contra entradas inválidas (`try/catch`).
- Saída colorida no terminal (códigos ANSI).
- Quatro contas de exemplo são criadas ao iniciar, para facilitar os testes.

## Tecnologias

- Java 17
- Java Collections (`ArrayList`)
- Eclipse IDE (projeto com `.project` e `.classpath`)

## Arquitetura

| Pacote | Conteúdo |
|---|---|
| `conta.model` | `Conta` (classe abstrata com `sacar`, `depositar` e `visualizar`), `ContaCorrente` e `ContaPoupanca` (herança e sobrescrita) |
| `conta.repository` | `ContaRepository` — interface com as operações de CRUD e movimentação |
| `conta.controller` | `ContaController` — implementa o repositório usando uma coleção em memória |
| `conta.util` | `Cores` — constantes ANSI para o terminal |
| `conta` | `menu` — ponto de entrada e laço do menu |

## Estrutura de diretórios

```
Conta-Bancaria/
└── src/
    ├── module-info.java
    └── conta/
        ├── menu.java
        ├── controller/ContaController.java
        ├── model/Conta.java, ContaCorrente.java, ContaPoupanca.java
        ├── repository/ContaRepository.java
        └── util/Cores.java
```

## Como executar

Pré-requisito: JDK 17+.

**Pelo Eclipse ou IntelliJ:** importe a pasta como projeto Java e execute a classe `conta.menu`.

**Pelo terminal:**

```bash
git clone https://github.com/GuilhermeKaynam/Conta-Bancaria.git
cd Conta-Bancaria
javac -d out $(find src -name "*.java")
java -p out -m conta/conta.menu
```

Os dados ficam em memória e são perdidos ao encerrar o programa.

## Melhorias futuras

- Remover a pasta `bin/` do versionamento e adicionar um `.gitignore`.
- Usar `BigDecimal` para valores monetários.
- Persistir as contas em arquivo ou banco de dados.
- Testes unitários com JUnit para as regras de saque e transferência.
