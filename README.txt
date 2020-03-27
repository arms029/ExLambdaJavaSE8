Exemplo do uso da expressão lambda a fim de tornar o código menor e mais legível, diminuindo também a quantidade de classes criadas no sistema, facilitando bastante a manutenção.
Também será abordado o uso de classes anônimas, indispensável para o entendimento da expressão lambda.

- Neste exemplo, será criado uma lista de pessoas e alimentada logo em seguida com o nome de cada pessoa e sua respectiva idade.
- Um filtrador de pessoas também será instanciado, onde o filtrador receberá como parâmetro uma lista de pessoas populada, e um respectivo filtro, que será representada pela interface Matcher.
- A interface Matcher recebe um genérico como parâmetro e devolve true ou false, de acordo com a lógica implantada pela classe.
- Será criado duas classes que implementam a interface Matcher, uma classe MaioresDeIdade, o qual retorna true caso a pessoa seja maior de idade, e uma classe MenoresDeIdade, o qual retorna true caso a pessoa seja menor de idade.
- Por fim, será imprimido no console essa lista de pessoas filtrada, e ao longo do Programa principal será comparado as várias formas de se obter o mesmo resultado, com o objetivo de mostrar a importância da expressão lambda e a interface Predicate do javaSE8.
