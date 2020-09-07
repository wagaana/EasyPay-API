package com.nsiimbi.easypay.modules;

import java.io.Serializable;

public class ApiParameters implements Serializable {
    public String amountToPay;
    public String userPhone;
    public String currency="UGX";
    public String clientID;
    public String reference;
    public String ClientSecret;
    public String paymentReason;

    public ApiParameters(){}
}
