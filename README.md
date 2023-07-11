EXERCÍCIO SEMANA 4


Sistema de venda de ingressos



Devemos construir um sistema para realização de venda de ingressos:
Osistema tera as seguintes funcionalidades:

	• Cadastrar filme
		- id
		- titulo
		- genero
		- idade mínima
		- tempo
		- valor
		- tecnologia (2D, 3D)
		- poltronas disponiveis -> VER ATUALIZAÇAO DE POLTRONAS

	• Cadastro de usuarios
		- nome
		- role (cliente, funcionario)
		- idade
		- user
		- password
		

A sala de cinema possui 100 poltronas enumeradas onde existe um ingresso para cada poltrona
Usuários do tipo (funcionário) poderão
	- cadastrar novos filmes no sistema
	- excluir filmes do cartaz
		• um filme só pode ser excluído caso nenhum ingresso tenha sido vendido
	- listas os filmes em cartaz
	- sair para a tela de login

Usuários do tipo (cliente) poderão:
	- comprar ingressos no sistema
	- listas os filmes em cartaz
		• a listagem deve retornar somente os filme de acordo com a classificação indicativa especificada
	- visualizar os ingressos que comprou
	- sair para a tela de login

Deve existir um sistema de login
	- Deve identificar se o usuário é cliente ou funcionario e direciona-lo para o menu correto
Deve um cadastro de usuários


    MENU INICIAL
		ENTRAR -> (TELA DE LOGIN)
		CADASTRAR -> (TELA DE CADASTRO)

     
     CADASTRO
	informar os campos:
		- nome
		- role (cliente, funcionario)
		- idade
		- user
		- password
	CADASTRAR -> (TELA DE CLIENTE OU TELA DE FUNCIONARIO)

     LOGIN
		Pede user
		Pede password
			O password deve ver armazenado em (Base64 OU md5)
		ENTRAR -> (TELA DE CLIENTE OU TELA DE FUNCIONARIO)

      CLIENTE
		- comprar ingressos no sistema
		- listas os filmes em cartaz
			• a listagem deve retornar somente os filme de acordo com a classificação indicativa especificada
		- visualizar os ingressos que comprou
		- sair -> (TELA DE LOGIN)

      FUNCIONARIO
		- cadastrar novos filmes no sistema
		- excluir filmes do cartaz
			• um filme só pode ser excluído caso nenhum ingresso tenha sido vendido
		- listas os filmes em cartaz
		- sair -> (TELA DE LOGIN)
		




