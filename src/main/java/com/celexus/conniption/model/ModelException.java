package com.celexus.conniption.model;

/**
 * An exception for the exclusive use of the Model Package
 *
 * @author cam
 *
 */
public class ModelException extends Exception {

    private static final long serialVersionUID = -5069711488216229748L;

    public ModelException(String message, Throwable t) {
        super(message, t);
    }

    public ModelException(String message) {
        super(message);
    }

}
