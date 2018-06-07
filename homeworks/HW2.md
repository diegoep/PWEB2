# Homework 2

Objetivo: aplicar as teorias de modelagem de domínio a partir da decomposição de aplicações em microsserviços.

1. Se registre no [LucidChart](www.lucidchart.com) a partir do e-mail institucional (@ifpb) para ter acesso livre.
2. Crie um novo diagrama contendo as classes de domínio (com respectivos atributos e relacionamentos), repositórios, serviços e recursos web para os microsserviços descritos no último slide da aula 02.
3. Cada aluno deverá fazer o diagrama correspondente a um microsserviço, seguindo esta distribuição:
  * Jozimar: Streaming
  * Lindemberg: Transcode
  * Romulo: Download
  * Rudan: Subscriptions

Para entregar a atividade, envie o link compartilhado do diagrama no Lucid Chart para o professor via mensagem direta no Slack.

Prazo de entrega:
24-mar (quinta), 11h

----
## Requisitos Funcionais: ##
### Serviço de Streaming: ###
1) Usuário deverá ter acesso a um fluxo de vídeo a partir do acesso a uma URL (será possível usar essa URL em um player HTML5)
2) Usuário poderá pular o início do fluxo para um determinado trecho do vídeo (passando o segundo inicial)
3) O acesso ao vídeo deverá ocorrer somente mediante a um código de autenticação válido
4) O serviço deverá guardar dados estatísticos sobre as exibições de vídeo (ex.: quem solicitou, quando e quanto tempo assistiu)

### Serviço de Transcodificação: ###
1) O serviço deverá gerar novas versões de vídeo a partir de um perfil de transcodificação, que indicará a qualidade e o formato que será gerado.
2) O serviço deverá suportar vários perfis de transcodificação, sendo cada perfil referente a um formato/qualidade de vídeo que poderá ser gerado a partir do vídeo original. Esse perfil deverá ser passado como parâmetro na requisição de uma nova transcodificação.
3) O serviço deverá tratar a transcodificação como uma tarefa assíncrona, de maneira que após disparar a tarefa, o status da tarefa poderá ser consultado através de um serviço
4) O sistema deverá organizar uma fila de transcodificações, de maneira que seja possível configurar quantas transcodificações serão executadas em paralelo

### Serviço de Download ###
1) Usuário deverá ter acesso a um arquivo qualquer (vídeo, imagem, audio, documento) a partir de um endereço (URL)
2) O acesso ao arquivo deverá ocorrer somente mediante a um código de autenticação válido
3) O serviço deverá guardar dados estatísticos sobre os downloads de vídeo (ex.: quem solicitou, quando, qual arquivo e tamanho)

### Serviço de Subscriptions ###
1) Usuário irá configurar o sistema para receber notificações que serão recebidas a partir de uma ação (ex.: novo upload feito por um usuário ou dentro de um canal)
2) O sistema deverá suportar vários meios para entrega de notificações (e-mail, sms, mensagem interna)
3) O sistema deverá suportar um conjunto de mensagens pre-definidas que serão utilizadas para o envio de notificações
