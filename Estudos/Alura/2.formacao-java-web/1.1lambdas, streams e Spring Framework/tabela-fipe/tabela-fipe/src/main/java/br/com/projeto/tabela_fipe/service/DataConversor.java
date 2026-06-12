package br.com.projeto.tabela_fipe.service;

import java.util.Collection;
import java.util.List;
import java.rmi.server.ObjID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;

 

import br.com.projeto.tabela_fipe.service.IDataConversor;

public class DataConversor implements IDataConversor{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classe) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> classe){

        CollectionType lista = mapper.getTypeFactory()
                                .constructCollectionType(List.class, classe);

        try{
            return mapper.readValue(json, lista);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }


}
