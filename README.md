# Simulador AFN
Botões: 
  * Novo - Cria um automato
  * Excluir - Exclui um automato
  * \+ (mais) - Cria uma transição
  * \- (menos) - Cria uma transição
  * Exibir modelo - Exibe o modelo formal do autômato
  * Novo automato - Cria um novo automato
  * Testar - Testa a string de entrada
 
 Campos: 
   * Nome - Altera o nome do nó selecionado
   * Símbolo - Simbólo que será a string de transição do nó
   * Estado de destino - Seleciona o automato ao qual será transferido a transição
   * String de teste - É onde o usuário insere a String com as entradas
   * Visualização e teste - Exibe os autômatos na interface
   
O Funcionamento básico é na seção criar estados, o usuário deve 
clicar em novo para criar um autômato. Ele tem a opção de selecionar
se aquele automato será o final, caso seja o primeiro autômato
a ser criado, este será o autômato inicial. 

O usuário tem a opção de clicar no autômato e ticar ele como 
o autômato que será o final. 

Para criar a transição selecione um autômato clicando nele, 
digte o símbolo que deseja inserir e no campo Estado destino,
seleciona para qual autômato será feita a transição, se
você escolher o mesmo que você selecionou, então ele irá 
criar uma seta para você mesmo. Caso seja outro autômato, 
a seta será criada com o símbolo em cima apontando para 
o autômato que você escolheu. 

Ao digitar a string de caracteres e clicar em testar, o
autômato tomará os caminhos de acordo com as transições, 
caso um deles pare no está final, a cadeia será aceita. 
  