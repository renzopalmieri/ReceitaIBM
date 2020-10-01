/*
CenÃ¡rio de NegÃ³cio:
Todo dia Ãºtil por volta das 6 horas da manhÃ£ um colaborador da retaguarda do Sicredi 
recebe e organiza as informaÃ§Ãµes de contas para enviar ao Banco Central. 

Todas agencias e cooperativas enviam arquivos Excel Ã  Retaguarda. Hoje o Sicredi jÃ¡ possiu mais de 4 milhÃµes de contas ativas.
Esse usuÃ¡rio da retaguarda exporta manualmente os dados em um arquivo CSV para ser enviada para a Receita Federal, antes as 10:00 da manhÃ£ na abertura das agÃªncias.

Requisito:
Usar o "serviÃ§o da receita" (fake) para processamento automÃ¡tico do arquivo.

Funcionalidade:
0. Criar uma aplicaÃ§Ã£o SprintBoot standalone. Exemplo: java -jar SincronizacaoReceita <input-file>
1. Processa um arquivo CSV de entrada com o formato abaixo.
2. Envia a atualizaÃ§Ã£o para a Receita atravÃ©s do serviÃ§o (SIMULADO pela classe ReceitaService).
3. Retorna um arquivo com o resultado do envio da atualizaÃ§Ã£o da Receita. Mesmo formato adicionando o resultado em uma nova coluna.


Formato CSV:
agencia;conta;saldo;status
0101;12225-6;100,00;A
0101;12226-8;3200,50;A
3202;40011-1;-35,12;I
3202;54001-2;0,00;P
3202;00321-2;34500,00;B
...

*/