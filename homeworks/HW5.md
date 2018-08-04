# Homework 5

Objetivo: utilize como base o [Upload Service](https://github.com/diegoep/PWEB2/blob/master/sourcecode/UploadService/) e o [Command Producer](https://github.com/diegoep/PWEB2/blob/master/sourcecode/command-producer/) criados anteriormente para tratar o evento de reserva expirada (faça clone dos códigos para um repositório seu).

No Upload Service:
* Altere a classe "RemocaoReservaExpirada" para disparar um evento que referente à esta ação

No Command Producer:
* Crie um tratador para o evento criado referente à reserva expirada e atualize o estado da entidade "Conteudo" para NEGADO.

Para simular a expiração de uma reserva, no lado do Upload Service, coloque um Thread.sleep de um minuto no método de criar a reserva de espaço, fazendo com que a reserva seja expirada antes da criação.

Reflexão:
* Neste caso, o que irá acontecer? A reserva será NEGADA ou após a liberação do sleep, ela voltará ao estado APROVADA? Como tratar o isolamento?

## Entrega:
Para entregar a atividade, crie um repositório privado no GitHub e compartilhe o acesso só com o professor.

Prazo de entrega:
15-ago (quarta), 23:59
