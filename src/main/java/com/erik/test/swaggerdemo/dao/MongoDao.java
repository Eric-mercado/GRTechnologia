package com.erik.test.swaggerdemo.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class MongoDao {
/*
    MongoClient mongo;
    private static final String HOST_NAME = "localhost";
    private static final int DEFAULT_PORT = 27017;
    private static final String DB_NAME = "journaldev";
    final static MongoCredential grDevAuth = MongoCredential.createPlainCredential("devAdmin", "grAdmin", "Lickme.51".toCharArray());
    static AtomicReference<DB> mongoDB;

    public static  DB getDB() {

        if(mongoDB != null){
            return mongoDB.get();
        }

        try {
            ServerAddress serverAddress = new ServerAddress(HOST_NAME, DEFAULT_PORT);
            mongo = new MongoClient(serverAddress, Arrays.asList(grDevAuth)));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo.getDB("journaldev");
    }*/
}
