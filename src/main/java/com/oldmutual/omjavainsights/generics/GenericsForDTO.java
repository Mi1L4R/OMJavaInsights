package com.oldmutual.omjavainsights.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsForDTO {

    public static <T> void addDTOObjectToList(T object, List<T> list){
        if(list == null){
            list = new ArrayList<>();
        }

        list.add(object);
    }

    //todo add error checking in the event that the object is not found
    public static  <T> void removeDTOObjectFromList(T object, List<T> list){
        if(list == null){
            return;
        }

        list.remove(object);
    }
}
