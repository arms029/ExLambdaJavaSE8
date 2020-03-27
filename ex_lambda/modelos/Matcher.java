package testes.ex_lambda.modelos;

//Interface que faz um teste, devolvendo um booleano
@FunctionalInterface
public interface Matcher<T>{
    public boolean test(T t);
}