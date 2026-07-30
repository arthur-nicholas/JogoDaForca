# JogoDaForca

> Jogo focado no terminal feito para estudar conceitos de lógica de programação e POO.

## Estrutura das classes do Código
- __Main__ = Responsável pela lógica geral do jogo, fazendo comparações de letras e palavras, além de controlar o fluxo do código.
- __View__ = Desenha a interface visual e atualiza as informações exibida no console. 
- __Word__ = Faz a requisição da palavra para a API externa e trata os dados recebidos para envia-la para a __Main__.

*As palavras são geradas aleatoriamente e recebidas de uma API externa -> (https://random-words-api.kushcreates.com/).
