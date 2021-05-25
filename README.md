# Começando
    
    Projeto desenvolvido para o desafio da empresa Projuris utilizando as tecnologias: SpringBoot, Thymeleaf, VueJS, Bootstrap, SpringWeb,
    SpringJPA, SpringValidation e H2 Database.

### Guia de uso
1. Ao executar o aplicativo, ele subirá na porta 8080. A página inicial então é localhost:8080/home.

2. Na tela home será apresentado uma listagem das últimas Ordens de Serviço incluídas (inicialmente sem nehum registro), e umm menu de navegação,
para as telas:
  1. Home: tela inicial;
  2. Nova Ordem de Serviço: abre o formuário de inclusão de uma nova ordem de serviço;
  3. Ordens Pendentes: abre uma tela com uma lista editável com todas as Ordens de Serviço com o status Pendente;
  4. Ordens Iniciadas: abre uma tela com uma lista editável com todas as Ordens de Serviço com o status Iniciada;;
  5. Ordens Finalizadas: abre uma tela com uma lista editável com todas as Ordens de Serviço com o status Finalizada;

3. Nova Ordem de Serviço: nesta tela serão preenchidos os dados para inclusão de uma nova Ordem de Serviço. Nesta tela os campos: Nome, Peça e a
   Descrição são obrigatórios, e é feito a validação do conteúdo do que foi preenchido no campo Email(mas ele pode ficar vazio). Ao apertar o botão
   Cadastrar, a Ordem de Serviço será salva no banco de dados e será criada com o status Pendente.

4. Ordens Pendentes: nesta tela aparecerão todas as Ordens de Serviço com o status Pendentes. Em cada Ordem de Serviço aparerá o botão Iniciar e Deletar.
   A mairia dos campos não será editável, somente os campos Data Início, Data Término e Comentário. Para iniciar a Ordem de serviço, é obrigatório o preenchimento
   do campo Data de Início. Ao preencher este campo, poderá ser apertado o botão Iniciar, que mudará o status da Ordem de Serviço para Iniciada. O botão Deletar,
   exclui a Ordem de Serviço.

5. Ordens Iniciadas: nesta tela aparecerão todas as Ordens de Serviço com o status Iniciadas. Em cada Ordem de Serviço aparerá o botão Finalizar e Deletar
   A mairia dos campos não será editável, somente os campos Data Término e Comentário. Para finalizar a Ordem de serviço é obrigatório o preenchimento dos
   campos Data de Término e Comentário. Ao preencher estes campos, poderá ser apertado o botão Finalizar, que mudará o status da Ordem de Serviço para Finalizada.
   O botão Deletar, exclui a Ordem de Serviço.

6. Ordens Finalizadas: nesta tela aparecerão todas as Ordens de Serviço com o status Finalizadas. Em cada Ordem de Serviço aparerá o botão Deletar e não será posssível
   editar mais nenhum campos. O botão Deletar, exclui a Ordem de Serviço.

### Guia da aplicação
- A aplicação está divida em duas partes, a MVC e a API Rest.
- A API Rest se resume aos endpoints presentes no arquivo OrdemServicoRest, e as regras de negócio implementadas no service, os repositórios e os modelos/entidades.
- Toda a comunicação entre a aplicação o front e a API Rest é feita através do ferramenta Axios, que faz as requisições GET, POST e DELETE, junto com o framework VueJS
  e o Thymeleaf que mapeia os os valores buscados no servidor e apresentam em tela. Nos pacotes dto e response, eu criei classes modelos específicas para facilitar esta
  comunicação entre as aplicações.
