package com.javalent.curio.search.models;

public sealed interface SearchPredicate permits TermSearchPredicate, FieldSearchPredicate {
    public Type type();

    public enum Type {
        FIELD,
        TERM
    }

}
