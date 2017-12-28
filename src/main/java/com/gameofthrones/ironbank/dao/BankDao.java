package com.gameofthrones.ironbank.dao;

import com.gameofthrones.ironbank.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.websocket.server.PathParam;

/**
 * @author Evgeny Borisov
 */

public interface BankDao extends MongoRepository<Bank,String> {

    Bank findByName(@Param("name") String name);

}
