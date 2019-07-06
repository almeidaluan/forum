# Projeto

Uma copia do forum da alura.

* Paginação 
* Cache
* Spring security
* JWT
* Monitoramento com Spring boot Actuator e Spring boot Admin
* Documentando API com SWAGGER

# Sumário de arquivos

 ```repository``` - Responsavel por fazer a interface com o banco. <br />
 ```model``` - Contem todas as classes do sistema que são persistidas no banco. <br />
 ```service``` - Trata as regras de negocio <br />
 ```config/validacao```  - Classes responsaveis por tratar as Exceptions geradas no sistema. <br/>
 ```config/security``` - Classes responsaveis por tratar a autenticação e autorização no sistema utilizando jwt. <br/>
```controller/dto``` - Criado para retornar apenas informações pertinentes a consulta do usuario evitando retornar um monte de informações desnecessarias.<br />
```controller/form``` - Criado para mandar informações que são recebidas no body. / Utilizando BeanValidation
### Como utilizar a Ordenação

- Ordenação passando os atributos [pagina,qtd,ordenacao] no endpoint commit 97195b2c8b608132f0b003e26e08ae11e6364302.

        localhost:8080/topicos?pagina=0&qtd=3&ordenacao=dataCriacao

- Ordenação passando apenas o objeto Pageable no endpoint.

        localhost:8080/topicos?page=0?size=10&sort=id,asc&sort=dataCriacao
