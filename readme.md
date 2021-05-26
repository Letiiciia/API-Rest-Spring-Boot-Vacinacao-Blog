## API REST com Spring Boot e Hibernate

Neste artigo irei explicar de forma detalhada a construção de uma API REST utilizando a linguagem JAVA e as tecnologias Spring Boot e Hibernate, a IDE utilizada na construção da aplicação foi o Eclipse e a versão 8 do JAVA.
No Spring Initializr, na página web https://start.spring.io/, foi configurado os nomes dos pacotes e selecionado as seguintes dependências:<br>
-> Spring Web<br>
-> Spring Boot DevTools<br>
-> Spring Data JPA<br>
-> H2 Database<br>
<br>
Além da facilidade que o Spring Boot nos possibilita, a escolha dessas dependências foi com a intenção de facilitar ainda mais. Na minha humilde concepção, eu entendo o Spring Boot com a visualização de um cenário, que eu faço questão de detalhar para que vocês enxerguem exatamente como eu.
Imaginem um desenvolvedor que trabalha em Home Office e sempre antes de iniciar o desenvolvimento de uma aplicação, o assistente Spring Boot organiza o setup dele, liga os equipamentos, configura tudo o que precisa ser configurado para que ele tenha apenas o trabalho de codar (codificar) e de brinde ainda entrega uma xícara de café (risos).
Consegue visualizar a facilidade que este projeto do Framework Spring nos possibilita? Este comparativo é um pouco exagerado, mas a intenção é apenas construir uma ilustração na sua mente.
<br>
Ele basicamente faz toda a configuração e contribui para que sua aplicação esteja na web o mais rápido possível, a intenção dele é de corrigir todos os possíveis erros que você enfrentaria na construção de uma aplicação do zero.
O Spring Web é a dependência padrão para a construção de aplicativos web, API Rest, usando spring MVC e utilizando o servidor Apache Tomcat.
O Spring Boot DevTools fornece uma configuração de reinicialização automática, sempre que faço uma atualização na minha aplicação, eu não preciso ficar derrubando e subindo o servidor pra visualizar a modificação.
O Spring Data JPA é uma especificação do JAVA persistence usando Spring Data e Hibernate pra gente trabalhar com objeto relacional, resumindo pra gente trabalhar com banco de dados.
E por fim o H2 Database que é um modelo de banco de dados em memória, ele já vem todo configurado e eu só precisei modelar meus dados.
A arquitetura de pastas utilizada no projeto foi o MVC, então comecei pela minha Controller, criando a chamada dos métodos POST’s dentro do package controller, uma classe chamada UsuarioController que contém o método de cadastramento de usuário no banco de dados, e outra classe chamada VacinaController que contém o método de cadastramento da aplicação da vacina.
<br>
A mesma construção realizada para cadastrar o usuário é utilizada pra cadastrar a aplicação de vacina. Então tudo que for descrito pra um, vale para o outro.
Dentro das classes controllers, eu declarei uma propriedade repository que recebe a notação @Autowired e injeta uma instância do package repository, mas pra ela funcionar, primeiro tenho que criar meu repository.
Crio o package repository e as classes UsuarioRepository e VacinaRepository (lembrando que são arquivos independentes), declaro uma public interface com extends que vai herdar o JPA e especificar o tipo da entidade e o tipo do ID.
Após isso eu volto ao meu controller e consigo fazer uso dos métodos http que vieram da interface estendida na repository.
No momento de declarar a minha public de cadastrar é preciso fazer referência a minha model, no caso o meu banco de dados. Então agora criarei o package model. Nessa classe eu preciso definir quais dados eu irei receber no momento do cadastro e especificamente nessa parte a classe usuário é diferente da classe vacina. Além das informações serem diferentes, é preciso fazer referência do usuário na model da vacina.
<br>
Na model do usuário eu declaro:
 Id
 Nome
 Email
 Cpf
 dataNascimento
Na model da vacina eu declaro:
 Id
 nomeVacina
 data
 usuário (neste campo eu uso a chave estrangeira e referencio os dados de um cadastro de usuário)
Em cada declaração eu coloco as notações que configuram o dado, por exemplo o dado data, a notação @JsonFormat define o formato da data.
E por fim gero getters, setters, hashCode e equals, pois não estou usando lombok que faz a autogeração desses itens.
Por fim texto minhas rotas no postman. Ao criar um cadastro o retorno deve ser o dado e o status 201 - Created, se houver erro no preenchimento do dado o retorno será 400 - Bad request.
<br>
Quando minha API estiver completinha, posso fazer deploy pelo Heroko e deixar meus endpoints acessíveis na web. Espero que tenham compreendido o quão importâte o Spring Boot é para o processo.


Até a Próxima. Letícia Ferreira Lima

