package com.nsiimbi.easypay;

import android.app.Activity;
import android.content.Intent;

import com.nsiimbi.easypay.activities.MakeRequest;
import com.nsiimbi.easypay.modules.ApiParameters;

public class Request {
    private Activity activity;
    public String amountToPay;
    public String userPhone;
    public String currency;
    public String clientID;
    public String ClientSecret;
    public String paymentReason;
    public static String EASY_PAY_PARAMS="parameters";
    public static int EP_REQUEST_CODE =120;

    public Request(Activity activity) {
        this.activity = activity;
    }

    public Request setAmountToPay(String amountToPay) {
        this.amountToPay = amountToPay;
        return this;
    }

    public Request setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Request setPaymentReason(String paymentReason) {
        this.paymentReason = paymentReason;
        return this;
    }

    public Request setClientID(String clientID) {
        this.clientID = clientID;
        return this;
    }

    public Request setClientSecret(String ClientSecret) {
        this.ClientSecret = ClientSecret;
        return this;
    }

    public void initialize() {
        if (activity != null) {
            ApiParameters apiParameters=new ApiParameters();
            apiParameters.amountToPay=amountToPay;;
            apiParameters.userPhone=userPhone;;
            apiParameters.currency=currency;;
            apiParameters.clientID=clientID;;
            apiParameters.ClientSecret=ClientSecret;;
            Intent intent = new Intent(activity, MakeRequest.class);
            intent.putExtra(EASY_PAY_PARAMS, apiParameters);
            activity.startActivityForResult(intent, EP_REQUEST_CODE);
        }
    }
}
