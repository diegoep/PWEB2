# Homework 3

Objetivo: criar aplicação web baseada em microsserviços integrando tecnologias que implementam padrões para a comunicação síncrona distribuída.

O modelo de dados da aplicação Web será de livre escolha, mas deverá ser implementada pelo menos uma entidade com respectivos repositório e serviço. Os seguintes microsserviços (implementados como aplicações Spring Boot) devem fazer parte da aplicação:

- 1) Microserviço provendo o acesso à lógica de negócio seguindo o modelo de dados escolhido e podendo ser rodado em múltiplas instâncias;

- 2) Gateway contendo Circuit Breaker Hystrix com os fallbacks para chamadas para o microsserviço, Zuul Server para roteamento e Ribbon Client para balanceamento nas chamadas realizadas pelo Zuul para os microsserviços);

- 3) Registry (rodando um Eureka Server) para fornecer para o Gateway as instâncias disponíveis do microsserviço.

## Entrega:
Para entregar a atividade, crie um repositório privado no GitHub e compartilhe o acesso só com o professor.

Prazo de entrega:
19-jul (quinta), 11h
