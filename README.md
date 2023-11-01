<h1 align="center">📜 Sistema Flash Food</h1>

<p align="center">O Flash Food é uma solução de autoatendimento para restaurantes que desejam gerenciar o fluxo do pedido (criação, pagamento, preparo, monitoramento e entrega ao cliente).
</p>


## Tecnologias
As tecnologias utiizadas nesse proejto visam entregar uma solução escalável.

Conceitos e tecnologias utilizadas:
- Arquitetura Hexagonal
- DDD (Domain Driven Design)
- Spring Boot (Java)
- Docker
- Postgres


<p><font color="red"><strong>* Projeto em desenvolvimento</strong></font></p>

## Documentação

- [Wiki](https://www.notion.so/Sistema-de-Pedidos-Fast-Food-d2e654269bcf4dd3ac3b47a8d9290915)
- [Miro com a arquitetura e DDD](https://miro.com/app/board/uXjVNV9BETw=/)
- [Swagger](http://localhost:8080/swagger-ui/index.html#/Produtos)
- [PostgresSQL Admin](http://localhost:16543/browser/)
- [Coleções do Postman](https://github.com/heiderlopes/flash-food/tree/main/collections/)


**Atenção para acessar o PostgresSQL e o Swagger a aplicação deverá estar rodando.**




## Rodando a aplicação

1 - Baixe o código fonte de aplicação. (Branch **main**)

```bash
git clone https://github.com/heiderlopes/flash-food.git
```

Acesse o diretório raíz e execute o seguinte comando para fazer o build da aplicação:

````
./gradlew build
````


2 - Execute o docker-compose para subir a aplicação:

````
docker-compose up
````

**Observação:**

Para parar basta executar:

````
docker-compose down
````
