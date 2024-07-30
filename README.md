<h1 align="center">Ecommerce API</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Linkedin&message=devlucasgusmao&color=1921E1&labelColor=000000" alt="devlucasgusmao" />
</p>

## Descrição

Este projeto é uma API de e-commerce desenvolvida em Java utilizando o framework Spring Boot. A API permite a gestão de produtos, usuários e carrinhos de compras.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- JPA/Hibernate
- Lombok
- Spring Security
- JWT

## Estrutura do Projeto

- `src/main/java/com/lucasgusmao/ecommerce_api/controllers`: Contém os controladores REST.
- `src/main/java/com/lucasgusmao/ecommerce_api/models`: Contém as classes de modelo.
- `src/main/java/com/lucasgusmao/ecommerce_api/repositories`: Contém as interfaces de repositório.
- `src/main/java/com/lucasgusmao/ecommerce_api/services`: Contém as classes de serviço.
- `src/main/java/com/lucasgusmao/ecommerce_api/config`: Contém as classes de configuração de segurança.

## Endpoints

### Produtos

- **GET** `/produtos`: Lista todos os produtos.
- **GET** `/produtos/{id}`: Retorna um produto pelo ID.
- **POST** `/produtos/criar`: Cria um novo produto.
- **PUT** `/produtos/atualizar/{id}`: Atualiza um produto existente.
- **DELETE** `/produtos/remover/{id}`: Remove um produto pelo ID.

### Carrinho

- **GET** `/carrinho/{idCarrinho}/produtos`: Lista todos os produtos no carrinho.
- **POST** `/carrinho/add/{idCarrinho}/produto/{idProduto}`: Adiciona um produto ao carrinho.
- **DELETE** `/carrinho/remove/{idCarrinho}/produto/{idProduto}`: Remove um produto do carrinho.
- **DELETE** `/carrinho/delete/{idCarrinho}`: Deleta um carrinho.

### Autenticação

- **POST** `/auth/registro`: Registra um novo usuário.
- **POST** `/auth/login`: Autentica um usuário e retorna um token JWT.

## Configuração

### Pré-requisitos

- Java 11 ou superior
- Maven
- IDE de sua preferência (recomendado: IntelliJ IDEA)
- Ferramenta para teste de Endpoints (recomendado: Isomnia ou Postman)


### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/lucasgusmaobaptista/ecommerce_api.git
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd ecommerce_api
    ```
3. Compile o projeto:
    ```sh
    mvn clean install
    ```

### Executando a Aplicação

1. Configurações Básicas
    - Crie um banco de dados MySQL chamado `ecommerce_api`.
    - Configure o arquivo `application.properties` com as credenciais do seu banco de dados. 
    ```shell
    spring.datasource.url=jdbc:mysql://localhost:3306/produtos_db
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    (ESCOLHA UM BASEADO NA SUA VERSÃO DO MYSQL)
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    (ESCOLHA UM BASEADO NA SUA VERSÃO DO MYSQL)
    ```

2. Execute a aplicação:
   ```sh
    mvn spring-boot:run
   ```
3. A aplicação estará disponível em `http://localhost:8080`.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature:
    ```sh
    git checkout -b minha-feature
    ```
3. Commit suas mudanças:
    ```sh
    git commit -m 'Minha nova feature'
    ```
4. Faça o push para a branch:
    ```sh
    git push origin minha-feature
    ```
5. Abra um Pull Request.
