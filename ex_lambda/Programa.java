package testes.ex_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import testes.ex_lambda.modelos.FiltradorDePessoas;
import testes.ex_lambda.modelos.MaioresDeIdade;
import testes.ex_lambda.modelos.Matcher;
import testes.ex_lambda.modelos.MenoresDeIdade;
import testes.ex_lambda.modelos.Pessoa;

public class Programa {
    public static void main(String args[]){
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Mario",29),
                                new Pessoa("Gui", 31),
                                new Pessoa("Joao", 17),
                                new Pessoa("Maria", 19),
                                new Pessoa("Alicia", 16));

        List<Pessoa> resultado = new ArrayList<Pessoa>();
        FiltradorDePessoas filtrador = new FiltradorDePessoas();

        //-------------------------------------------------------------------------------------------------------------------
        // Critério usando classe (note o trabalho que dá ter que criar as classes separadamente para cada caso diferente).
        Matcher<Pessoa> maioresDeIdade = new MaioresDeIdade();
        Matcher<Pessoa> menoresDeIdade = new MenoresDeIdade();
        resultado = filtrador.filtraComMatcher(pessoas, maioresDeIdade);
        System.out.println(resultado);
        resultado = filtrador.filtraComMatcher(pessoas, menoresDeIdade);
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------------
        //MAIORES DE IDADE - classe anônima, veja que n é necessário criar classes separadas para cada tipo de filtro.
        Matcher<Pessoa> maioresDeIdadeAnonimo = new Matcher<Pessoa>(){
            public boolean test(Pessoa p){
                return p.getIdade() >= 18;
            }
        };
        //MENORES DE IDADE
        Matcher<Pessoa> menoresDeIdadeAnonimo = new Matcher<Pessoa>(){
            public boolean test(Pessoa p){
                return p.getIdade() < 18;
            }
        };
        resultado = filtrador.filtraComMatcher(pessoas, maioresDeIdadeAnonimo);
        System.out.println(resultado);
        resultado = filtrador.filtraComMatcher(pessoas, menoresDeIdadeAnonimo);
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------------
        //Usando classe Anônima com Predicate, veja que não é necessário a criação de uma classe Matcher
        Predicate<Pessoa> maioresDeIdadeAnonimoComPredicate = new Predicate<Pessoa>(){
			@Override
			public boolean test(Pessoa p) {
				return p.getIdade() >= 18;
			}
        };
        Predicate<Pessoa> menoresDeIdadeAnonimoComPredicate = new Predicate<Pessoa>(){
			@Override
			public boolean test(Pessoa p) {
				return p.getIdade() < 18;
			}
        };
        resultado = filtrador.filtraComPredicate(pessoas, maioresDeIdadeAnonimoComPredicate);
        System.out.println(resultado);
        resultado = filtrador.filtraComPredicate(pessoas, menoresDeIdadeAnonimoComPredicate);
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------------
        //Usando expressão lambda, olha que sensacional!! Apenas um trechinho de código para fazer a mesma coisa!!!
        Predicate<Pessoa> maioresDeIdadeLambda = (Pessoa p) -> {
		return p.getIdade() >= 18;
        };
        Predicate<Pessoa> menoresDeIdadeLambda = (Pessoa p) -> {
            	return p.getIdade() < 18;
        };
        resultado = filtrador.filtraComPredicate(pessoas, maioresDeIdadeLambda);
        System.out.println(resultado);
        resultado = filtrador.filtraComPredicate(pessoas, menoresDeIdadeLambda);
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------------
        //É possível colocar tudo em uma linha só quando o corpo do método é pequeno
        Predicate<Pessoa> maioresDeIdadeReduzido = p -> p.getIdade() >=18;
        Predicate<Pessoa> menoresDeIdadeReduzido = p -> p.getIdade() < 18;
        resultado = filtrador.filtraComPredicate(pessoas, maioresDeIdadeReduzido);
        System.out.println(resultado);
        resultado = filtrador.filtraComPredicate(pessoas, menoresDeIdadeReduzido);
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------------------------------
        // É possível até mesmo passar a expressão lambda diretamento como parâmetro!!!!
        resultado = filtrador.filtraComPredicate(pessoas, p -> p.getIdade() >=18);
        System.out.println(resultado);
        resultado = filtrador.filtraComPredicate(pessoas, p -> p.getIdade() < 18);
        System.out.println(resultado);
        //Olha a facilidade de criar um novo filtro, sem se preocupar em ter que criar classes!!!
        resultado = filtrador.filtraComPredicate(pessoas, p -> p.getNome().startsWith("M"));
        System.out.println(resultado);
        //-------------------------------------------------------------------------------------------------------------------

        //Agora compare esse trecho de código acima usando expressão lambda com o que foi escrito inicialmente, 
        //lembre-se que foi necessário criar uma classe matcher e uma classe MaioresDeIdade, além de ter o 
        //trabalho de instanciar os objetos das classes para o main, caso você queira fazer o filtro por alguma
        //outra lógica, seria necessário a criação de outra classe.
        //Usando expressão lambda, tudo fica mais fácil e mais prático, além de ajudar na hora da manutenção do código.
    }
}
