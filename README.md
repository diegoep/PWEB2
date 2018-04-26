# Programação para a Web 2

## CST em Análise e Desenvolvimento de Sistemas, [IFPB - Campus Cajazeiras](http://ifpb.edu.br/cajazeiras)

### Professor

* Diego Pessoa ([diego.pessoa@ifpb.edu.br](mailto:diego.pessoa@ifpb.edu.br))

### Local / Horários

* Centro de Informática, horários: **Quintas (13:00-15:15)**, Sala07/Lab.Inf.3 e **Sextas (15:30-17:45)**, Sala10A/Lab.Inf.5
* Canal de comunicação oficial no Slack: [pweb2-2018-1.slack.com](http://pweb2-2018-1.slack.com)

### Ementa

Arquitetura, ciclo de vida, conceitos e ferramentas para a construção de Aplicações Web avançadas. Novos padrões arquiteturais e paradigmas de desenvolvimento. Tópicos avançados e tendências.

### Objetivo Geral

Exposição prática a conceitos, ferramentas e princípios do desenvolvimento de aplicações Web baseadas na arquitetura de microsserviços, juntamente com as boas práticas e técnicas de implantação utilizando-se dos princípios de DevOps.

### Objetivos Específicos

- Tornar o aluno capacitado a entender os fundamentos, desenvolver e gerenciar uma aplicação Web avançada baseada em microsserviços.
- Aplicar e gerenciar os principais frameworks utilizados no desenvolvimento de aplicações Web
- Apresentar todo o fluxo de desenvolvimento de uma aplicação Web avançada, da concepção, desenvolvimento, configuração, implantação e disponibilização para o usuário final.

### Conteúdo Programático (Tópicos)

1. Nivelamento, revisão e aprofundamento de conceitos fundamentais
   - Controle de versão e integração contínua
   - Ferramentas para construção automática de projetos
2. Migrando de aplicações monolíticas para aplicações baseadas em microsserviços
   - Definição, propósito e conceitos fundamentais da arquitetura de microsserviços
   - Modelagem e estratégias para decomposição de microsserviços
   - Visão geral dos componentes de uma aplicação Web baseada em microsserviços
   - Frameworks e ferramentas de desenvolvimento (Spring Boot, Netflix OSS)
3. Desenvolvendo lógica de negócio numa arquitetura de microsserviços
   - Padrões de organização de lógica de negócio (Transaction Script, DDD)
   - Publicação de eventos de domínio
   - Mapeamento do modelo de dados em classes de domínio (entidades e migrações)
   - Serviços para gerenciamento de regras de negócio e acesso à base de dados
   - Disponibilização de APIs REST com paginação e consultas locais
4. Comunicação entre microsserviços
   - Padrões de Comunicação entre aplicações Web
   - Formatos de Mensagens
   - Gerenciamento de transações
   - Mecanismos para Distribuição de carga alta-disponibilidade
   - Comunicação assíncrona e Message Brokers
5. Consultas envolvendo microsserviços
   - Consumo de dados utilizando o padrão API composition
   - Adoção do padrão CQRS (Command Query Responsible Segregation) 
   - Criação de visões para otimização de buscas 
6. Padrões para consumo como APIs externas
   - Desafios para integração de aplicações externas (Clientes Mobile, Front-end de aplicações Web)
   - O padrão API Gateway
   - Tecnologias para implementação do API Gateway (Spring Cloud, Eureka, Zuul)
7. Testes em microsserviços
   - Estratégias para testes de microsserviços
   - Testes unitários por serviço
   - Testes de integração
   - Testes de componente
   - Testes de aceitação
8. Desenvolvendo serviços prontos para produção
   - Segurança em microsserviços (UAA – User account and Authentication, SSL)
   - Gerenciamento de Configuracão externa (push-based e pull-based)
   - Monitoramento de serviços: health check, logging, métricas, auditoria e exception tracking
   - Preparando perfis para diferentes ambientes (dev, teste, prod)
9. Implantação de microsserviços
   - Componentes do pipeline para geração e implantação de serviços
   - Construção do pacote executável e cópia para um repositório compartilhado
   - Geração de imagem para implantação da aplicação como container
   - Avaliação de qualidade do código
   - Implantação da aplicação em um serviço na nuvem (Heroku, AWS)
10. Tópicos avançados e tendências
    - Novos padrões para requisições REST (GraphQL)
    - Integração com serviços para utilização de algoritmos de Machine Learning
    - Web de Dados, Internet das Coisas e manipulação de dados semânticos

### Metodologia de Ensino

A metodologia de ensino adotada compreende um misto de aulas tradicionais com atividades e workshops em sala de aula. Durante as aulas, serão abordados os conceitos básicos relacionados aos tópicos tratados na disciplina. Durante os workshops em sala de aula, serão realizados exemplos de exercícios com ferramentas relevantes que reforçam o material de aula.

### Avaliação

### Bibliografia Básica

LUCKOW, Décio; MELO, Alexandre. Programação Java para a Web – 2ª Edição. Novatec, 2015. 

DEITEL, Paul; DEITEL, Harvey. Java: como programar. 10ª Edição. São Paulo: Pearson, 2016

KALIN, Martin. Java Web Services: implementando. Rio de Janeiro: Alta Books, 2010.

### Bibliografia Complementar

RICHARDISON, Chris. Microsservices Patterns. Manning Publication, 2018. Disponível em: https://www.manning.com/books/microservices-patterns

CARNELL, John. Spring Microservices in Action. Manning Publication, 2017.

POSTA, Christian. Microservices for Java Developers. O’ Reilly, 2016. Disponivel em: https://www.oreilly.com/learning/microservices-for-java-developers

WALLS, Craig. Spring Boot in Action. Manning Publication, 2015.

HEMRAJANI, Anil. Desenvolvimento ágil em Java com Spring, Hibernate e Eclipse. São Paulo: Pearson, 2006.

PESSOA, Diego. Planilha: Desenvolvimento de Aplicações Web avançadas baseadas em microsserviços, 2018. Disponível em: http://github.com/diegoep/PWEB2.

### Links Complementares sobre Ferramentas, Frameworks e Tecnologias

- [Arquitetura de Microsserviços](http://microservices.io/patterns/microservices.html)
- [Introdução a Microserviços](https://www.nginx.com/blog/introduction-to-microservices/)
- Spring IO
  - Spring IO Website: http://www.spring.io
  - Spring Boot: https://projects.spring.io/spring-boot/
  - Spring Cloud: https://projects.spring.io/spring-cloud/
  - Spring Projects: http://spring.io/projects
  - Spring Guides: http://spring.io/guides
  - Spring Document: http://spring.io/guides
  - Spring Boot Docs: http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
  - Spring Boot API: http://docs.spring.io/spring-boot/docs/current/api/
- Fique por dentro
  - Twitter: http://twitter.com/springcentral
  - YouTube: http://spring.io/video
  - Questions: http://spring.io/questions
  - JIRA: http://jira.spring.io
  - Blog: http://spring.io/blog
- Ajuda
  - Stack Overflow: http://stackoverflow.com/questions/tagged/spring-boot
- [Netflix Open Source Software Center](https://netflix.github.io/)
- [Microservices vs. Service-Oriented Architecture](https://www.nginx.com/resources/library/microservices-vs-soa/)
- [Canary deployments, A/B testing, and microservices with Ambassador](https://www.datawire.io/faster/canary-workflow/)
- [Systems Performance: Enterprise and the Cloud](http://www.brendangregg.com/sysperfbook.html)
- [Designing Data-Intensive Applications](http://www.dataintensive.net/)
- [Continous Delivery](http://www.continuousdelivery.com)
- [The Evolution of DevSecOps Revisited](https://cloudsentry.evident.io/evolution-devsecops-revisited/)
- [Containers com Docker: Do desenvolvimento à produção](https://www.casadocodigo.com.br/products/livro-docker)
- [Ansible: Up and Running](http://www.ansiblebook.com/)
- [Docker Tutorials and Labs](https://github.com/docker/labs) (This repo contains Docker labs and tutorials authored both by Docker, and by members of the community)
- [Jenkins: Automatize tudo sem complicações](https://www.casadocodigo.com.br/products/livro-jenkins)
- [Testes automatizados de software: Um guia prático](https://www.casadocodigo.com.br/products/livro-testes-de-software)
- [Test-Driven Development: Teste e Design no Mundo Real](https://www.casadocodigo.com.br/products/livro-tdd)
- [Cloud Computing: Concepts, Technology & Architecture](http://www.amazon.com/Cloud-Computing-Practice-Dan-Marinescu/dp/0124046274)
- [Four Layers of TCP/IP model, Comparison and Difference between TCP/IP and OSI models](http://www.omnisecu.com/tcpip/tcpip-model.php)
- [Travis CI](https://travis-ci.org/), Test and Deploy with Confidence


