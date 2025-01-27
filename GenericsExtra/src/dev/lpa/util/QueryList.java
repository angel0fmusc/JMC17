package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    /**
     * T, type parameter, is a different type, completely separate from the type parameter
     * declared for the class itself. This type is specified, or inferred, when you invoke the
     * static method on the class
     * @param items
     * @param field
     * @param value
     * @return
     * @param <S>
     */
    public static <S extends QueryItem> List<S> getMatches(
            List<S> items, String field, String value){
        List<S> matches = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field,value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field,value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
