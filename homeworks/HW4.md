# Homework 4

Objetivo: utilize como base o [Upload Service](https://github.com/diegoep/PWEB2/blob/master/sourcecode/UploadService/) criado anteriormente para utilizar um mecanismo de comunicação assíncrona a partir da chamada feita por outros serviço, seguindo os seguintes passos:

* Crie um serviço simples que gerencie alguma entidade uma entidade qualquer e que contenha uma referência para um arquivo e um status.
* Crie os respectivos repositórios/serviços para gerenciar essa entidade.
* No método de criação da entidade, inicialize o status como "RESERVA_PENDENTE"
* Após a criação da entidade localmente, dispare um comando assíncrono para criar uma reserva de espaço no Upload Service (Use o endpoint definido no [ReservaEspacoController](https://github.com/diegoep/PWEB2/blob/master/sourcecode/UploadService/src/main/java/br/edu/ifpb/uploadservice/web/ReservaEspacoController.java)).
* Simule e trate os dois casos possíveis de resposta do Upload Service:
   1. Se houver espaço em disco, o Upload Service irá criar a reserva e retornar sucesso - neste caso, o seu serviço deverá finalizar a transação e atualizar a entidade para o estado "RESERVA_REALIZADA"
   2. Se não houver espaço em disco, o Upload Service irá retornar BAD_REQUEST - neste caso, o seu serviço deverá finalizar a transação e atualizar o estado da entidade para "RESERVA_REJEITADA"

* Sugestão de implementação: Eventuate com envio de comandos assíncronos e canal de resposta. Exemplo: https://github.com/eventuate-tram/eventuate-tram-core-examples-basic

* Obs.: para esta etapa, não é requerido o uso de sagas.

## Entrega:
Para entregar a atividade, crie um repositório privado no GitHub e compartilhe o acesso só com o professor.

Prazo de entrega:
02-ago (quinta), 11:00
