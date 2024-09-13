package com.javalent.curio.search.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class FieldSearchPredicate implements SearchPredicate {
    @Override
    public SearchPredicate.Type type() {
        return Type.FIELD;
    }

    public List<String> fields;

    @Builder.Default
    public int fuzzy = 0;

    @Builder.Default
    public int boost = 1;

    public static class FieldSearchPredicateBuilder {
        public FieldSearchPredicateBuilder field(String field) {
            if (this.fields == null)
                this.fields = new ArrayList<String>();
            this.fields.add(field);
            return this;
        }
    }

}