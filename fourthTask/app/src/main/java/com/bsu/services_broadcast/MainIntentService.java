package com.bsu.services_broadcast;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.List;

public class MainIntentService extends IntentService {

    public MainIntentService() {
        super("MainIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int number = intent.getIntExtra("number",0);
        final StringBuilder result = new StringBuilder();
        List <Integer> primeNumbers = getListOfPrimaryNumbers(number);
        int countOfPrimeNumbers = primeNumbers.size();
        for (int i = 0; i < countOfPrimeNumbers - 1;i++){
            result.append(primeNumbers.get(i));
            result.append(", ");
        }

        result.append(primeNumbers.get(countOfPrimeNumbers - 1));

        Intent resIntent = new Intent("MainActivity");
        resIntent.putExtra("listOfPrimeNumbers", result.toString());
        resIntent.putExtra("amountOfPrimeNumbers", countOfPrimeNumbers);

        LocalBroadcastManager.getInstance(this).sendBroadcast(resIntent);



    }

    private List getListOfPrimaryNumbers(Integer number) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) primeNumbers.add(i);
        }
        return primeNumbers;
    }



    private boolean isPrime(int number){

        if (number < 2) return false;


        for (int i = 2; i < number; i++ ) {
            if (number%i == 0) return false;
        }
        return true;
    }


}
