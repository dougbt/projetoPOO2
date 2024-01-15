# Projeto Java com Swing, JavaFX, Controle de Threads e MongoDB

## Descrição

Este é um projeto Java que utiliza as bibliotecas Swing e JavaFX para criar uma aplicação de gerenciamento com tela de cadastro, cadastro de fornecedor e hardware. O projeto também faz uso do banco de dados MongoDB para armazenar e recuperar dados.

## Funcionalidades

- **Cadastro de Fornecedores:** Permite cadastrar informações detalhadas sobre fornecedores, incluindo nome, contato e detalhes adicionais.

- **Cadastro de Hardware:** Permite o registro de hardware, incluindo informações como tipo, marca, modelo e número de série.

- **Tela de Cadastro:** Oferece uma interface amigável para o usuário realizar cadastros de forma intuitiva.

- **Controle de Threads:** Implementa um controle eficiente de threads para garantir uma experiência de usuário suave e responsiva.

- **Integração com MongoDB:** Utiliza o banco de dados MongoDB para armazenar e recuperar dados, proporcionando uma persistência robusta e escalável.

## Pré-requisitos

Certifique-se de ter os seguintes componentes instalados antes de executar o projeto:

- Java Development Kit (JDK)
- Bibliotecas Swing e JavaFX
- MongoDB Server

## Configuração do MongoDB

Antes de executar a aplicação, configure as informações de conexão com o MongoDB no arquivo de configuração. Edite o arquivo `config.properties` e insira as informações corretas para a conexão com o banco de dados.

```properties
# Configurações do MongoDB
mongo.host=localhost
mongo.port=27017
mongo.database=nome_do_banco
```

## Executando o Projeto

1. Clone este repositório: `git clone https://github.com/dougbt/seu-repositorio.git`
2. Configure o MongoDB conforme as instruções acima.
3. Abra o projeto em sua IDE preferida.
4. Compile e execute a aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback.

## Licença

Este projeto é distribuído sob a licença [MIT](LICENSE).


