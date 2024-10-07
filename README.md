# CinemaFilme Application

Este é um projeto de exemplo utilizando o **Spring Boot** com o padrão **MVC** (Model-View-Controller). O objetivo deste projeto é demonstrar uma estrutura organizada e eficiente para um aplicativo de gerenciamento de filmes.

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

