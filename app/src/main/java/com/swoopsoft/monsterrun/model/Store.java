package com.swoopsoft.monsterrun.model;

import java.util.List;

public class Store{
    public List<String> selling;    //Items for sale (ItemIDs)
    public long start;      //Store opening date
    public long end;        //Store close date

    public Store(List<String> selling, long start, long end){
        this.selling = selling;
        this.start =start;
        this.end = end;
    }

    public List<String> getSelling(){
        return selling;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}
