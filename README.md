# 💰 Conta Bancária - Simulador

Este é um projeto de sistema bancário simples, onde é possível criar contas, realizar depósitos, saques e transferências entre contas.

## 📌 Funcionalidades
✅ Criar conta com nome, CPF e saldo inicial  
✅ Depositar valores na conta  
✅ Sacar dinheiro da conta  
✅ Transferir entre contas  
✅ Consultar saldo  

## 🛠 Tecnologias Utilizadas
- **Linguagem:** Java  
- **Framework:** Spring Boot  
- **Banco de Dados:** MySQL  
- **Segurança:** Spring Security, JWT  
- **Ferramentas:** Git, Docker, Postman  

## 🚀 Como Executar o Projeto

1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/conta-bancaria.git
2. Entre no diretório do projeto:
   ```bash
   cd conta-bancaria

### Explicação sobre como configurar o banco de dados:

3. Configure o banco de dados no arquivo `src/main/resources/application.properties` com suas credenciais e URL do banco de dados:
## Exemplo de configuração para MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sua_database
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
   
4. Execute o projeto:
```bash
mvn spring-boot:run
```
# Estrutura do projeto
```
📦 conta-bancaria
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┗ 📂 com.generationbrasil.contabancaria
 ┃ ┃ ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┃ ┣ 📂 model
 ┃ ┃ ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┃ ┗ ContaBancariaApplication.java
 ┃ ┃ ┗ 📂 resources
 ┃ ┃ ┃ ┣ application.properties
 ┃ ┃ ┃ ┗ schema.sql
 ┣ pom.xml
 ┗ README.md

```
## 📩 Contato
📧 Email: Guilhermekaynam2006@gmail.com
💼 LinkedIn: (https://www.linkedin.com/in/guilherme-kaynam/)  

---

Desenvolvido com ❤️ por **Guilherme Kaynam** 🚀
