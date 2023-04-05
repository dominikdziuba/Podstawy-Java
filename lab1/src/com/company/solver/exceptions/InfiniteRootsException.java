package com.company.solver.exceptions;

public class InfiniteRootsException extends SolverException{
    public InfiniteRootsException(){
        super("Równanie ma nieskonczenie wiele rozwiazan.");
    }
}
