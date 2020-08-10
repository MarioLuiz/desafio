# Configuração para rodar o projeto
Candidato Mario Luiz

### Instruções rodar o BackEnd
- Na IDE de sua preferencia escolha a opção de importação do projeto MAVEN, localizando o pom.xml creio que o restante a própria IDE irá fazer;
- Necessário estar com JDK 11, pois o projeto foi projetado para esta versao da Linguagem Java;
- O Banco de dados escolhido foi o H2 (Banco em memória), é necessário ;
- O projeto está rodando na porta 8084, portanto para rodar H2 siga esse link: http://localhost:8084/h2-console/;
- O BackEnd não está finalizado: falta implementar extrato por (Dia/Mês/Intervalo)

### Front-end
- Infelizmente não tive tempo habil de implementar o Front.



----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# desafio
Desafio para avaliação de candidato

### Instruções para o desafio
- O candidato deverá criar um fork no git e criar uma branch com o nome e sobrenome do canditado(ex: desafio_Jose_Silva) para o desenvolvimento da atividade;
- O projeto deverá ser divido em dois pacotes, um do front-end e um do back-end;
- O front deverá ser feito em Vue.js e o back deverá ser feito com spring boot;
- Fica a critério do candidato a implementar testes unitários;
- Histórico de commit será levado em consideração para acompanhamento da evolução do desafio, onde iremos avaliar o passo a passo desde a criação do projeto, criação dos pacotes back e front, criação dos serviços, criação das funcionalidades, etc. Portanto sugerimos que a cada passo realizado seja feito um commit com um comentário explicativo do que foi realizado, exemplo:
    - Commit 1- Criação da estrutura inicial do projeto;
    - Commit 2- Criação do pacote back-end;
    - Commit 3- Criação do pacote front-end;
    - Commit 4- Criação das entidades de persistência;
    - Commit x- Criação da funcionalidade Criar Licitação;
- Ao final do desafio, criar um documento explicando como configurar e subir a aplicação;


### Desafio
- Desenvolver uma aplicação web responsável por simular ações básicas de uma conta bancaria.
- Criar conta
    - Deve conter os atributos
        - número conta
        - responsável
        - saldo

- Movimentações
    - Realizar deposito
    - Realizar saque
    - Realizar transferência
	- Incluir

- Exibir extrato por (Dia/Mês/Intervalo)
    - deve detalhar as movimentações
