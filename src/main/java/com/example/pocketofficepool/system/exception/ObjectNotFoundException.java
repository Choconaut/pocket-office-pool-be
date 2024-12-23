package com.example.pocketofficepool.system.exception;

import java.util.UUID;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String objectName, UUID id) {
        super("Could not find : " + objectName + " '" + id + "'");
    }

    public ObjectNotFoundException(String objectName, String id, String objectName2, UUID id2) {
        super("Could not find " + objectName + " with id: " + id + " and " + objectName2 + " with field: " + id2);
    }
}
