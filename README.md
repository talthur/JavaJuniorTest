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

CLIENTE
----------------------------------------------------------------------------------------------

1 - Adicionar:

<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/salva-cliente.png" alt="salva-cliente">
Salva um cliente no DB, criando um ID sequencial que poderá ser usado para retornar ou atualizar a informação.

2 - Ler:

<img src="https://github.com/talthur/JavaJuniorTest/blob/master/images/get-cliente-by-id.png" alt="salva-cliente">
Lê um cliente no DB baseado no ID que é passado na requisição, no exemplo o ID 1 está sendo usado.

3 - Atualizar:

----------------------------------------------------------------------------------------------




## 📫 Contribuindo para <nome_do_projeto>
<!---Se o seu README for longo ou se você tiver algum processo ou etapas específicas que deseja que os contribuidores sigam, considere a criação de um arquivo CONTRIBUTING.md separado--->
Para contribuir com <nome_do_projeto>, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars3.githubusercontent.com/u/31936044" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Iuri Silva</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://s2.glbimg.com/FUcw2usZfSTL6yCCGj3L3v3SpJ8=/smart/e.glbimg.com/og/ed/f/original/2019/04/25/zuckerberg_podcast.jpg" width="100px;" alt="Foto do Mark Zuckerberg"/><br>
        <sub>
          <b>Mark Zuckerberg</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://miro.medium.com/max/360/0*1SkS3mSorArvY9kS.jpg" width="100px;" alt="Foto do Steve Jobs"/><br>
        <sub>
          <b>Steve Jobs</b>
        </sub>
      </a>
    </td>
  </tr>
</table>


## 😄 Seja um dos contribuidores<br>

Quer fazer parte desse projeto? Clique [AQUI](CONTRIBUTING.md) e leia como contribuir.

## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.

[⬆ Voltar ao topo](#nome-do-projeto)<br>
