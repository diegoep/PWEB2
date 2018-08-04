# Homework 5

Objetivo: utilize como base o [Upload Service](https://github.com/diegoep/PWEB2/blob/master/sourcecode/UploadService/) e o [Command Producer](https://github.com/diegoep/PWEB2/blob/master/sourcecode/command-producer/) criados anteriormente para tratar o evento de reserva expirada (faça clone dos códigos para um repositório seu).

No Upload Service:
* Altere a classe "RemocaoReservaExpirada" para disparar um evento referente à esta ação

No Command Producer:
* Crie um handler para o evento criado referente à reserva expirada e atualize o estado da entidade "Conteudo" para NEGADO.

Para simular a expiração de uma reserva, no lado do Upload Service, coloque um Thread.sleep de um minuto no método de criar a reserva de espaço, fazendo com que a reserva seja expirada antes da criação.

Reflexão:
* Neste caso, o que irá acontecer? A reserva será NEGADA definitivamente ou após a liberação do sleep, ela voltará ao estado APROVADA? Como garantir o isolamento?

## Entrega:
Para entregar a atividade, crie um repositório privado no GitHub e compartilhe o acesso só com o professor.

Prazo de entrega:
08-ago (quarta), 23:59
