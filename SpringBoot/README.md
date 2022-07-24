### Olá a você que está louco para usar essa tão linda aplicação.
### Seja Bem Vindo
#### Criador: Micael Marques Rodrigues Silva


<h>Vamos começar a configurar o banco de dados. Para essa aplicação, utilizei o banco de dados PostgreSQL, no qual é de suma importância a criação de um database local com as seguintes credenciais:
```
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

Caso seja criado o database com essas informações acima, não precisará configurar mais nada.
Recomendo criar uma conexão no DBeaver com as credenciais acima para teste do banco de dados.

O próximo passo é iniciar a aplicação. Nesse caso, precisamos abrir nosso projeto com sua IDE preferida. Eu recomendo que utilize o Intellij IDEA.
Para isso, importe o projeto, e em seguida abra a Classe
JavaSpringBootApplication,
com path
com.integrada.api.javaspringboot.JavaSpringBootApplication.
Com a classe aberta, ```Alt + Shift + F10``` a fará rodar.

Com a aplicação iniciada, seguindo a orientação do passo 1, o banco já terá suas tabelas criadas, e se tudo estiver certo, e com itens preenchidos. A classe Application.java criará as informações dentro do banco de dados.

#### Vamos agora para o crud:
~~~
Para adicionar um produto no carrinho via insomnia, 
cria uma requisição POST com a URL
http://localhost:8080/api/carrinho/adicionar/{id},
trocando o {id} pelo id do produto.
Caso dê certo, retornará 201. Caso não, retornará uma exception.
~~~
~~~
Para remover um produto do carrinho via insomnia:
cria uma requisição POST com a URL
http://localhost:8080/api/carrinho/remover/{id},
trocando o {id} pelo id do produto.
Caso dê certo, retornará 201. Caso não, retornará uma exception.
~~~
~~~
Para adicionar um cupom de desconto no carrinho via insomnia:
cria uma requisição POST com a URL
http://localhost:8080/api/carrinho/desconto/{id}/{cupom},
trocando o {id} pelo id do produto.
Caso dê certo, retornará o carrinho com o preço total com desconto aplicado.
~~~
~~~
Para receber o preço total do carrinho:
cria uma requisição GET com a URL
http://localhost:8080/api/carrinho/preco/{id}
trocando o {id} pelo id do carrinho.
Caso dê certo, retornará o preço completo do carrinho.
~~~
~~~
Para ter um JSON com o carrinho completo:
Cria uma requisição GET com a URL
http://localhost:8080/api/carrinho
Caso dê certo, retornará a lista com o carrinho, e todos os produtos adicionados.
~~~