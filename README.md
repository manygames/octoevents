# Octo Events

Octo Events é uma aplicação que recebe eventos do Github Events via webhooks e os expõe via API para uso futuro.

## 1. Preparando Banco de Dados

Instale o Postgres na versão 9.6 com as seguintes configurações:

* Usuário: postgres 
* Senha: 123

Após finalizar a instalação, crie um banco de dados chamado "githubevents", sem as aspas.
A porta padrão configurada para o projeto acessá-lo é 5432, mas fique à vontade para modificá-la.

## 2. Execução

- Para uma execução **Standalone**, execute a task "bootJar" e no diretório em que ele foi gerado, execute o comando: java -jar "nome-do-jar"

- Para executar usando uma **IDE**, execute o arquivo "GithubIssueEventApplication.kt"

## 3. Endpoint events

O endpoint /events "escuta" por issues abertas no projeto configurado e ao receber, salva no banco

## 4. Endpoint issues/{number}/events

O endpoint issues/{number}/events expoe eventos através de uma API que as filtra usando o número da issue. Basta escolher alguma ferramenta e consumir da seguinte forma:

**Request:**

> GET localhost:4040/issues/1000/events

**Response:**

> 200 OK
```javascript
{
    "id": 376467047,
    "number": 1,
    "action": "reopened",
    "title": "Strange things happening",
    "url": "https://api.github.com/repos/manygames/meep/issues/1"
}
``` 
