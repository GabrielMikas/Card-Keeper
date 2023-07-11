# Card Keeper
 O projeto Card Keeper nasce da união do estudo, da prática e de um hobby pessoal: a coleçao de cartas.
 
 Com o intuito de solidificar core skills na linguagem Java, aprender tecnologias atuais, como o Spring Boot e ter um meio de controlar meu estoque pessoal de cartas colecionaveis, o projeto Card Keeper é idealizado contendo:
 - Uma aplicação desktop feita em Java 17
 - Uma API Rest feita com Spring Boot 3
 - Uma aplicação front-end
   
Vale notar que é um projeto em andamento e sujeito a melhorias constantes

# Card KeeperAPI
O Card KeeperAPI é o componente do sistema referente ao back-end e consiste numa RESTful API alimentada pelo banco de dados MySQL comum a todos os componentes do projeto.

Uma carta na API possui:
- id, referente ao id da carta no banco de dados
- CardName, referente ao nome da carta no banco de dados
- CardCode, referente ao código fisico da carta no banco de dados
- CardQuality, referente à qualidade da carta no banco de daod
- CardsAmount, referente à quantidade de cartas similares no banco de dados
- CardSleeve, referente à carta estar ou não em um sleeve
- CardImage, referente à imagem correspondente à carta

Até sua ultima atualização, a API conta com:
- Métodos GET, PUT, POST, DELETE devidamente implementados

## Dos métodos
### Métodos GET
Dos métodos GET presentes, temos:
- DetailCards
  - Retorna o código 200
  - Retorna um JSON referente à carta especificada na URI por meio de ID
- SendCards
  - Retorna o código 200
  - Retorna um JSON contendo todas as cartas presentes no banco de dados
### Métodos PUT
Dos métodos PUT presentes, temos:
- UpdateCards
  - Retorna o código 200
  - Retorna os dados atualizados da carta especificada por meio de ID no corpo da requisição
### Métodos POST
Dos métodos POST presentes, temos:
- ReceiveCards
  - Retorna o código 201
  - Retorna um JSON com o elemento criado
  - Retorna o header com o ID do elemento criado
### Métodos DELETE
Dos métodos DELETE presentes, temos:
- DeleteCards
  - Retorna o código 204
  - Apaga o registro da carta especificada por meio de ID no URI

# Card Keeper-Front
A adição mais recente do projeto, em construção HTML e Javascript, estilizado com bootstrap. Futuramente será migrado para ReactJS.

Consta com elementos card do bootstrap contando com:
- Uma imagem referente à carta
- O nome da carta
- O código da carta
- A qualidade da carta
- A quantidade de cartas
- O status sobre a carta estár ou não em um sleeve

Todos dados obtidos diretamente da Card Keeper API por meio de fetch()
# Card Keeper-Desktop - _Descontinuado_
***Em razão de ter servido seu proposito como forma de praticar e fundamentar conceitos core de OOP, o componente foi descontinuado de modo que mais tempo possa ser alocado ao componente front-end.***

O Card Keeper-Desktop é o componente do sistema que apresenta um app com interface simples e CRUD completo conectado a um banco de dados MySQL, atualmente hospedado localmente, onde são armazenados os dados relevantes das cartas presentes na minha coleção.

Nasce como o ponto inicial de desenvolvimento do projeto e tem como intuito praticar core skills de POO. Para tal, utilizei a linguagem Java 17 e para a criação da interface foi utilizado Java Swing.

Tem como campos de input:
- Card Name
- Card Code
- Card Quality
- Card Amount

  Após o input, os dados cadastrados no banco de dados são dispostos em uma tabela à direita contendo todos os dados de todas as cartas cadastradas até o momento.
