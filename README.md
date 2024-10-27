# CinemaFilme Application


Este projeto é um sistema de gestão de cinemas e sessões de filmes, desenvolvido utilizando o framework Spring Boot. Ele permite o gerenciamento de cinemas, filmes, sessões e a compra de ingressos, além de fornecer autenticação e autorização básica para os usuários.

## Funcionalidades Principais

- **Gerenciamento de Filmes**: Criação e armazenamento de dados de filmes, incluindo título, diretor, duração e gênero.
- **Cadastro de Cinemas**: Administração de cinemas, com informações de contato e endereço.
- **Sessões de Filmes**: Criação e controle de sessões, incluindo horário e preço dos ingressos.
- **Compra de Ingressos**: Registro e controle das compras de ingressos, com status de compra.
- **Controle de Usuários e Perfis**: Sistema de autenticação e autorização com perfis de usuários (ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN).

## Estrutura do Banco de Dados

O banco de dados possui as seguintes tabelas principais:

1. **Address**: Armazena informações de endereço como CEP, cidade, estado e número do endereço.
2. **Movies**: Guarda informações dos filmes, incluindo título, diretor, gênero e ano de lançamento.
3. **Roles**: Define os papéis dos usuários no sistema (e.g., ADMIN, USER).
4. **Users**: Armazena informações dos usuários, incluindo nome de usuário, e-mail e senha.
5. **Movie Theatres**: Registra as informações de cada cinema, associando-o a um endereço.
6. **Sessions**: Define as sessões de exibição de cada filme, associadas a cinemas e filmes.
7. **Purchases**: Armazena as compras feitas pelos usuários, incluindo a quantidade de ingressos e o status da compra.

## Dependências Principais

O projeto foi desenvolvido com as seguintes dependências principais:

- **Spring Boot**: Framework para construção do backend.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Spring Security**: Para autenticação e autorização de usuários.
- **PostgreSQL**: Banco de dados utilizado no projeto.

## Como Executar o Projeto

1. Clone o repositório.
2. Certifique-se de que o PostgreSQL esteja instalado e configurado.
3. Atualize as configurações de conexão com o banco de dados no arquivo `application.properties`.
4. Execute o comando abaixo para iniciar o servidor:

### Explicação dos Pacotes

#### `configs/`
Este pacote contém classes de configuração, como o `SwaggerConfig`, que são responsáveis por definir as configurações globais do sistema, como APIs de documentação, segurança, e outras.

#### `controllers/`
Os controladores são responsáveis por lidar com as requisições HTTP recebidas pela aplicação. Cada controlador mapeia endpoints e direciona as chamadas para os serviços. Exemplo: `MovieController` lida com as operações relacionadas a filmes.

#### `entities/`
Neste pacote estão as entidades que representam as tabelas do banco de dados. São classes Java anotadas com `@Entity`, que mapeiam os dados armazenados nas tabelas. Exemplo: `MovieEntity`.

#### `repositories/`
Os repositórios fazem a comunicação direta com o banco de dados, oferecendo uma interface para operações CRUD (Create, Read, Update, Delete). Exemplo: `MovieRepository`.

#### `services/`
A camada de serviços contém a lógica de negócios do aplicativo. As classes aqui realizam operações mais complexas e interagem com repositórios para realizar manipulação de dados. Exemplo: `MovieService`.

#### `dtos/`
Data Transfer Objects (DTOs) são usados para transferir dados entre as camadas da aplicação (geralmente da camada de serviço para a camada de apresentação). Eles permitem abstrair as entidades do banco e evitar expor detalhes internos.

#### `system/`
Aqui está localizada a classe principal `CinemaFilmeApplication` que inicializa a aplicação Spring Boot. É nesta classe que a aplicação é configurada e o método `main` é chamado para iniciar o servidor.

#### `util/`
Este pacote contém classes utilitárias que podem ser usadas em várias partes da aplicação, como funções auxiliares e outras ferramentas que facilitam o desenvolvimento.

#### `resources/`
Nesta pasta ficam os arquivos de configuração e recursos estáticos do sistema, incluindo:

- **`static/`**: Arquivos CSS, JavaScript e imagens.
- **`templates/`**: Arquivos HTML utilizados pelo Thymeleaf (ou qualquer outro motor de template).
- **`application.properties`**: Arquivo de configuração do Spring Boot.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cinemafilme.git



## 📂 Estrutura do Projeto
A seguir está a estrutura de diretórios utilizada no projeto:

```bash
.
└── src/
    └── main/
        ├── java/
        │   └── br/
        │       └── com/
        │           └── cinemafilme/
        │               ├── configs/               # Configurações gerais do sistema (ex: Swagger)
        │               │   └── SwaggerConfig.java
        │               ├── controllers/           # Controladores (ex: MovieController)
        │               │   └── MovieController.java
        │               ├── entities/              # Entidades de banco de dados (ex: MovieEntity)
        │               │   └── MovieEntity.java
        │               ├── repositories/          # Repositórios do banco de dados (ex: MovieRepository)
        │               │   └── MovieRepository.java
        │               ├── services/              # Lógica de negócios e serviços (ex: MovieService)
        │               │   └── MovieService.java
        │               ├── dtos/                  # Data Transfer Objects (ex: MovieDTO)
        │               │   └── MovieDTO.java
        │               ├── system/                # Classes principais e de configuração global
        │               │   └── CinemaFilmeApplication.java
        │               └── util/                  # Utilitários e helpers do sistema (ex: StringUtil.java)
        └── resources/
            ├── static/                            # Arquivos estáticos (CSS, JS, imagens, etc.)
            ├── templates/                         # Templates Thymeleaf (HTML)
            └── application.properties             # Configurações de propriedades do Spring

