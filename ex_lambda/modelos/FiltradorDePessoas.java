package testes.ex_lambda.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Classe que representa um filtro de pessoas, recebe como parametro uma lista de pessoas e um tipo de filtro
public class FiltradorDePessoas {
    //Usando interface Predicate
    public List<Pessoa> filtraComPredicate(List<Pessoa> pessoas, Predicate<Pessoa> filtro){
        List<Pessoa> resultado = new ArrayList<>();
        for (Pessoa pessoa : pessoas){
            if (filtro.test(pessoa)) 
                resultado.add(pessoa);
        }
        return resultado;
    }    
    //Usando uma interface criada na mão (classe Matcher)
    public List<Pessoa> filtraComMatcher(List<Pessoa> pessoas, Matcher<Pessoa> filtro){
        List<Pessoa> resultado = new ArrayList<>();
        for (Pessoa pessoa : pessoas){
            if (filtro.test(pessoa)) 
                resultado.add(pessoa);
        }
        return resultado;
    }    
    
}