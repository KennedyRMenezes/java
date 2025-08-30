package br.com.projeto.tabela_fipe.service;

import java.util.List;
import java.rmi.server.ObjID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataConversor {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> getListData(String json, Class<T> classe) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(
                json,
                mapper.getTypeFactory().constructCollectionType(List.class, classe)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
