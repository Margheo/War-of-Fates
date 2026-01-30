# Prompts usados

Este arquivo registra os prompts que enviamos à IA, mantendo a ordem e cada prompt separado.

## Estrutura de arquivos (pedido)

- Prompt: "Como podemos fazer uma estrutura de arquivos para um projeto de RPG por turnos inicial, simples para faculdade?"

## Listas e Random

- Prompt: "Explique listas e arrays em Java e dê exemplos de como ler, adicionar, remover e manipular listas."

- Prompt: "Como usar random em Java para sortear um número entre 1 e 10? Dê exemplos."
  
## UI

- Arquivos de contexto: `arena/Arena.java`, `battle/Batalha.java`, `battle/Equipe.java`, `characters/Personagem.java`, `Main.java`

- Prompt 1: "Crie uma interface Swing simples com um espaço para a arena que mostre vários personagens representados por círculos com barras de vida; inclua um menu para selecionar a quantidade de personagens em cada time e botões Start e Reset."

- Prompt 2: "Adicionar slider para controlar a velocidade e animações: atacante se move para frente; personagem atingido pisca/vermelho e retorna gradualmente à cor original; popup mostrando o dano recebido."

Prompt 3: "Adicionar tela de configuração de time por tipo de personagem (ex.: Guerreiro, Mago) com seleção e confirmação e remover menu antigo."

- Prompt 4: "Separe GameUI em vários arquivos por responsabilidade: ConsolePanel, MenuPanel, ArenaView e TeamBuilder (cada um com sua responsabilidade clara)."

- Prompt 5: "Criar novo arquivo que cuide da tela de status que mostra os atributos de Personagem em janela separada/tabela estilo Excel e mostrar barra de mana abaixo da barra de vida."
