# 🏥 Sistema Hospitalar — Projeto Final (Java / POO)

Aplicação de console em Java que gerencia um hospital: **login com controle de senha**,
**cadastro de pacientes e médicos**, **registro de atendimentos** (consulta, exame e cirurgia)
com **cálculo de fatura**, **relatórios** e **persistência em arquivo**. Desenvolvido para a
disciplina de Desenvolvimento de Software, aplicando os pilares da Programação Orientada a
Objetos (POO) sobre uma arquitetura **MVC**.

## 📌 Funcionalidades

* **Autenticação:** login obrigatório com até **3 tentativas**. Após 3 erros, exige o cadastro
  de uma nova senha, que **não pode repetir nenhuma das 3 últimas** já usadas.
* **CRUD:** menu interativo para Cadastrar, Consultar, Alterar e Excluir usuários.
* **Atendimentos e Fatura:** registro de Consulta/Exame/Cirurgia com cálculo de custo e desconto
  conforme o plano de saúde do paciente (vitrine do **polimorfismo**).
* **Relatórios:** geração de arquivo `.csv` cruzando informações de múltiplas classes.
* **Persistência:** leitura e escrita dos dados em arquivo de texto (`arquivos/usuarios.txt`).

## 🧱 Conceitos de POO aplicados

| Conceito | Onde aparece |
|---|---|
| **Herança** | `Usuario → Paciente/Medico` · `Atendimento → Consulta/Exame/Cirurgia` |
| **Classes abstratas** | `Usuario`, `Atendimento` (moldes que não se instanciam sozinhos) |
| **Interface** | `Exportavel` (contrato `gerarLinhasCsv()`), implementada por Paciente e Medico |
| **Polimorfismo** | `Fatura.calcularTotalFatura()` chama `calcularCusto()` e cada filha roda a sua versão (ligação tardia) |
| **Composição (TEM-UM)** | Paciente↔Plano · Atendimento↔Paciente/Medico · Fatura↔Atendimentos |
| **Encapsulamento** | atributos `private`/`protected` + getters/setters |
| **Sobrescrita** | `@Override` em `calcularCusto()` e `toString()` (presente em todas as classes) |

## 📁 Estrutura (arquitetura MVC)

```
SistemaHospitalar_Java/
├── Main.java                  → liga o sistema: carrega dados → login → menu → salva
├── model/                     → DADOS + REGRAS (não imprime, não lê teclado)
│   ├── Usuario.java (abstrata) Paciente · Medico · Plano
│   ├── Atendimento.java (abstrata) Consulta · Exame · Cirurgia
│   ├── Fatura.java             Exportavel.java (interface)
├── view/                      → só entrada/saída no console (Scanner / println)
│   └── LoginView · MenuView · AtendimentoView · Entrada (Scanner único)
├── controller/                → coordena view ↔ model
│   └── Login · MenuController · AtendimentoController
├── persistencia/              → ÚNICA classe que mexe em arquivo (try/catch)
│   └── GerenciadorArquivos
├── arquivos/                  → dados salvos (usuarios.txt) — criado em runtime
└── relatorios/                → relatórios .csv — criado em runtime
```

> **MVC** = separação de responsabilidades: o Model calcula mas não imprime; a View só faz I/O;
> o Controller coordena; a Persistência é a única com acesso a arquivo.

## ▶️ Como executar

Pelo VSCode: abra a pasta e rode o `Main.java` (botão *Run*).

Pelo terminal (a partir da raiz do projeto):
```bash
javac -d bin Main.java model/*.java view/*.java controller/*.java persistencia/*.java
java -cp bin Main
```

### Dados de demonstração (criados na 1ª execução)
Senha padrão de todos: **`1234`**

| Login | Tipo | Plano |
|---|---|---|
| `ana`, `carlos` | Médicos | — |
| `joao` | Paciente | Unimed (50%) |
| `maria` | Paciente | Hospitalar (25%) |
| `jose` | Paciente | Particular (sem desconto) |

## 👥 Autores

Trabalho em dupla — **Felipe** (camada Model, View, Controller) e **Higor** (View, Controller e Persistência).

## 📝 Padrão de commits

`feat` (nova funcionalidade) · `fix` (correção) · `docs` (documentação) · `refactor` (reestruturação) · `chore` (manutenção)

## ✅ Checklist de conclusão

- [x] Sistema executando corretamente
- [x] Login e controle de senhas (3 tentativas + troca + regra das 3 últimas)
- [x] Herança, polimorfismo e interface/classe abstrata
- [x] Dados persistidos em arquivo (leitura e escrita)
- [x] Relatórios e menu interativo operacionais
- [x] Código organizado em MVC e `toString()` em todas as classes
