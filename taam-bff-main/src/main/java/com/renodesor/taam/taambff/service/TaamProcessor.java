package com.renodesor.taam.taambff.service;

import com.renodesor.taam.generated.client.model.Activity;
import com.renodesor.taam.taambff.client.TaamApiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaamProcessor {
    private final TaamApiClient taamApiClient;

    public TaamProcessor(TaamApiClient taamApiClient) {
        this.taamApiClient = taamApiClient;
    }

    public void process() {
        ResponseEntity<List<Activity>> response = taamApiClient.getAllActivities();
        List<Activity> activities = response.getBody();
        activities.forEach(activity ->
            System.out.println(activity));
    }
}
