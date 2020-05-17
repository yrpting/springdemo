package com.springmvc.inject;

import java.util.List;
import java.util.Map;

public class InjectClass2 {
    private Map<Integer,String> mymap;
    private List<String> mylist;

    public Map<Integer, String> getMymap() {
        return mymap;
    }

    public void setMymap(Map<Integer, String> mymap) {
        this.mymap = mymap;
    }

    public List<String> getMylist() {
        return mylist;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }
}
