package com.example.pocketofficepool.system;

/**
 * This class defines the status code for the Result class.
 * The status code is defined as following:
 * 200: success
 * 400: invalid argument
 * 401: unauthorized
 * 403: forbidden
 * 404: not found
 * 500: internal server error
 *
 * @author  Byiringiro
 */
public class StatusCode {

    public static final int SUCCESS = 200;
    public static final int INVALID_ARGUMENT = 400;
    public static final int UNAUTHORIZED= 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int INTERNAL_SERVER_ERROR = 500;


}
