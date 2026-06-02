# Projeto Final - Desenvolvimento de Software (Java)

Este repositório contém o Projeto Final da disciplina de Desenvolvimento de Software. O objetivo é desenvolver uma aplicação em Java para resolver um problema real do cotidiano ou do mercado (como um sistema hospitalar, delivery, biblioteca, etc.), aplicando conceitos consolidados de Programação Orientada a Objetos (POO).

## 📌 Funcionalidades Principais

* **Autenticação:** Sistema de login obrigatório para iniciar a aplicação. O usuário possui um limite de 3 tentativas de acesso. Após 3 erros, é exigido o cadastro de uma nova senha, que não pode ser igual a nenhuma das 3 últimas cadastradas.
* **Gestão de Dados:** Sistema interativo com menu navegável para Cadastro, Consulta, Alteração e Exclusão de registros.
* **Relatórios:** Geração de relatórios cruzando informações de múltiplas classes.
* **Persistência:** O armazenamento dos dados (leitura e escrita) é feito localmente através de arquivos.

## 💻 Requisitos Técnicos (POO)

A arquitetura do sistema foi desenhada para aplicar os seguintes conceitos obrigatórios:

* **Estrutura de Classes:** O projeto possui no mínimo 5 classes coerentes com o tema. Pelo menos 3 delas são classes compostas (possuem objetos de outras classes como atributos).
* **Encapsulamento e Base:** Uso de atributos privados, construtores e métodos Getters/Setters. O método `toString()` está implementado em todas as classes.
* **Conceitos Avançados:** Implementação prática de Herança, Polimorfismo, Relacionamento entre classes, Sobrescrita de métodos (`@Override`) e utilização de Classes Abstratas ou Interfaces.

## 📁 Estrutura de Diretórios

A organização do código-fonte segue a separação de responsabilidades recomendada:

* `Main.java` - Ponto de entrada e menu interativo.
* `classes/` - Entidades e modelos de negócio.
* `interfaces/` e `abstract/` - Contratos e classes base do sistema.
* `arquivos/` - Lógica de leitura e escrita para persistência.
* `relatorios/` - Geração e formatação de saídas de dados.
* `utils/` - Classes utilitárias e ferramentas auxiliares.

## 📝 Padrões de Versionamento (Git)

Para garantir um histórico organizado durante a evolução do código, o repositório adota o seguinte padrão semântico para commits:

* `feat`: Adição de nova funcionalidade (ex: criação do login, nova classe).
* `fix`: Correção de bugs ou falhas nas regras de negócio.
* `docs`: Atualizações na documentação ou comentários.
* `refactor`: Reestruturação de código que não altera o comportamento externo.

## ✅ Checklist de Conclusão

- [ ] Sistema executando corretamente
- [ ] Login e controle de senhas funcionando
- [ ] Uso de herança, polimorfismo e interfaces/classes abstratas
- [ ] Dados sendo persistidos em arquivos corretamente
- [ ] Relatórios e menu interativo operacionais
- [ ] Código organizado e método `toString` implementado
