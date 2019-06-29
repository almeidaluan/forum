# Projeto

Uma copia do forum da alura.

* Paginação 
* Cache
* Spring security
* JWT
* Monitoramento com Spring boot Actuator e Spring boot Admin
* Documentando API com SWAGGER

### Como utilizar a Ordenação

- Ordenação passando os atributos [pagina,qtd,ordenacao] no endpoint commit 97195b2c8b608132f0b003e26e08ae11e6364302.

        localhost:8080/topicos?pagina=0&qtd=3&ordenacao=dataCriacao

- Ordenação passando apenas o objeto Pageable no endpoint.

        localhost:8080/topicos?page=0?size=10&sort=id,asc&sort=dataCriacao
