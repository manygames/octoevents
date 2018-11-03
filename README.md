# Octo Events

Octo Events � uma aplica��o que recebe eventos do Github Events via webhooks e os exp�e via API para uso futuro.

## 1. Preparando Banco de Dados

Instale o Postgres na vers�o 9.6 com as seguintes configura��es:

* Usu�rio: postgres 
* Senha: 123

Ap�s finalizar a instala��o, crie um banco de dados chamado "githubevents", sem as aspas.
A porta padr�o configurada para o projeto acess�-lo � 5432, mas fique � vontade para modific�-la.

## 2. Execu��o

- Para uma execu��o **Standalone**, execute a task "bootJar" e no diret�rio em que ele foi gerado, execute o comando: java -jar "nome-do-jar"

- Para executar usando uma **IDE**, execute o arquivo "GithubIssueEventApplication.kt"

## 3. Endpoint events

O endpoint /events "escuta" por issues abertas no projeto configurado e ao receber, salva no banco

## 4. Endpoint issues/{number}/events

O endpoint issues/{number}/events expoe eventos atrav�s de uma API que as filtra usando o n�mero da issue. Basta escolher alguma ferramenta e consumir da seguinte forma:

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
