# JavaJuniorTest
WebApplication for Java JR Teste


<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/diagram.jpeg" alt="exemplo imagem">

> API REST responsável por criar, ler, atualizar e deletar objetos do tipo: cliente e produto, criando a relação entre estes na forma de um pedido.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Modelos Cliente, Pedido, Produto
- [x] Repositórios
- [x] Services
- [x] Controllers
- [x] DTO
- [x] Endpoints CRUD para Produto e CLiente
- [x] Endpoint de adicionar Pedido
- [x] Endpoint de ler todos Pedidos
- [ ] Endpoint para deletar Pedidos
- [ ] Endpoint para alterar Pedidos
- [ ] Incluir segurança nos endpoints, definindo roles de acesso a aplicação
- [ ] Incluir testes automatizados

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Você instalou a versão mais recente de `Java 11 | Maven | MySQL`
* Você tem uma máquina `<Windows / Linux>`. 

## 🚀 Instalando JavaJuniorTest

Para instalar o JavaJuniorTest, siga estas etapas:

1 - Clone o respositório para sua máquina.

2 - Importe em sua IDE o respositório como uma Aplicação Maven.

3 - Altere no arquivo application.proporties o caminho de seu DB com seu login e senha.

4 - Rode como uma aplicação Java o arquivo: DeveloperJuniorApplication.java

## 🚀 Instruções de uso
Todas requisições e responses são feitas por JSON.

CLIENTE
----------------------------------------------------------------------------------------------

1 - Adicionar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/salva-cliente.png" alt="salva-cliente">
>Salva um cliente no DB, criando um ID sequencial que poderá ser usado para retornar ou atualizar a informação.

2 - Ler:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/get-cliente-by-id.png" alt="le-cliente">
>Lê um cliente no DB baseado no ID que é passado na requisição, no exemplo o ID 1 está sendo usado. Se utilizar o método GET em /clientes, retorna todos cliente do DB

3 - Atualizar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/atualiza-clientes.png" alt="atualiza-cliente">
>Atualiza um cliente baseado no ID que está sendo passado no header da requisição, no body os novos dados são incluídos.

4 - Deletar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/deleta-cliente-by-id.png" alt="deleta-cliente">
>Deleta um cliente do DB baseado no ID passado no header da requisição

----------------------------------------------------------------------------------------------
PRODUTO
----------------------------------------------------------------------------------------------
1 - Adicionar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/salvar-produto.png" alt="salva-produto">
>Salva um produto no DB, criando um ID sequencial que poderá ser usado para retornar ou atualizar a informação.

2 - Ler:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/get-produtos.png" alt="le-produto">
>Retorna todos produtos cadastrados no DB. No endpoint /api/produto/{id}, retorna apenas produto específico.

3 - Atualizar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/atualiza-produto.png" alt="atualiza-produto">
>Atualiza um produto baseado no ID que está sendo passado no header da requisição, no body novos dados são incluídos.

4 - Deletar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/deleta-produto-id.png" alt="deleta-cliente">
>Deleta um produto do DB baseado no ID passado no header da requisição
----------------------------------------------------------------------------------------------
PEDIDO
----------------------------------------------------------------------------------------------
1 - Adicionar:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/salvar-pedido.png" alt="salva-pedido">
>Salva um pedido no DB. A requisão JSON deve seguir o padrão da imagem.

2 - Ler:
<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/get-pedidos.png" alt="le-pedido">
>Retorna todos pedidos cadastrados no DB.                                        

## 📫 Contribuindo para <JavaJuniorTest>
Para contribuir com <JavaJuniorTest>, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

