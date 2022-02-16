package com.example.randomuserjusto.apiclient.entities;

import java.util.ArrayList;
import java.util.List;

public class UserRandomResponse {

    private List<User> results;

    public UserRandomResponse() {
        results = new ArrayList<User>();
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CollectionResult{" +
                "results=" + results +
                '}';
    }
}
