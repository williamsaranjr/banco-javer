# API de cadastros de usuários
Esta API é responsável por expor os endpoints da aplicação.

O CRUD de usuários é realizado pelo serviço de cadastro de usuários:
[Serviço de cadastro](https://github.com/williamsaranjr/cadastro-service)

## Configuração
Para o funcionamento da aplicação, algumas mudanças devem
ser feitas no arquivo `src/main/resources/application.yml`.
- Porta: A porta padrão é a porta **8000**, mas pode ser alterada se for necessário.
## Endpoints
Com o serviço em execução, os endpoints
podem ser visualizados através do Swagger UI, acessando a
[documentação](http://localhost:8080/swagger-ui.html).

## Executar
Para executar o serviço, basta rodar o comando equivalente:
- Releases:
    - `java -jar banco-javer-0.0.1-SNAPSHOT.jar`
- Maven
    - `mvn clean compile`
    - `mvn clean package`
    - `java -jar target/banco-javer-0.0.1-SNAPSHOT.jar`