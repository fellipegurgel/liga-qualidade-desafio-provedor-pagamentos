package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

public interface Processor<T,U> {
    U process(T t);
}
