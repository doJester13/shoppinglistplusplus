package com.udacity.firebase.shoppinglistplusplus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.HashMap;

/**
 * Created by Erik on 16/06/16.
 */
public class ShoppingList {
    String listName;
    String owner;
    HashMap<String, Object> dateCreated;
    HashMap<String, Object> dateLastChanged;

    public ShoppingList() {
    }

    public ShoppingList(String listName, String owner, HashMap<String, Object> dateCreated) {
        this.listName = listName;
        this.owner = owner;
        this.dateCreated = dateCreated;
        HashMap<String, Object> dateLastChangedObj = new HashMap<String, Object>();
        dateLastChangedObj.put("date", ServerValue.TIMESTAMP);
        this.dateLastChanged = dateLastChangedObj;
    }

    public String getOwner() {

        return owner;
    }

    public String getListName() {

        return listName;
    }

    public HashMap<String, Object> getDateLastChanged() {
        return dateLastChanged;
    }

    public HashMap<String, Object> getDateCreated() {
        if(dateCreated != null){
            return dateCreated;
        }

        HashMap<String, Object> dateCreatedObj = new HashMap<String, Object>();
        dateCreatedObj.put("date", ServerValue.TIMESTAMP);
        return dateCreatedObj;
    }

    @JsonIgnore
    public long getDateLastChangedLong(){
        return (long) dateLastChanged.get("date");
    }

    @JsonIgnore
    public long getDateCreatedLong(){
        return (long) dateCreated.get("date");
    }
}
