package testes.ex_lambda.modelos;

//Clase que representa um filtro de pessoas pela idade (menor que 18anos)
public class MenoresDeIdade implements Matcher<Pessoa>{

    @Override
    public boolean test(Pessoa pessoa) {
        return pessoa.getIdade() <= 18;
    }

}