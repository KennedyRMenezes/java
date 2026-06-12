package br.com.projeto.tabela_fipe.service;
import java.util.List;

public interface IDataConversor {

    <T> T getData(String json, Class<T> classe);

    <T> List<T> getList(String json, Class<T> classe);

}
