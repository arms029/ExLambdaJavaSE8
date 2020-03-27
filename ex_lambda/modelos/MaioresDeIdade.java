package testes.ex_lambda.modelos;

//Clase que representa um filtro de pessoas pela idade (maior que 18anos)
public class MaioresDeIdade implements Matcher<Pessoa>{

    @Override
    public boolean test(Pessoa pessoa) {
        return pessoa.getIdade() >= 18;
    }

}