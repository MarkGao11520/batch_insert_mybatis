package com.gwf.batch.model;

import lombok.Data;

/**
 * Created by gaowenfeng on 2017/10/19.
 */
@Data
public class DataModel {
    private String STN;
    private String WBAN;
    private String YEARMODA;
    private String TEMP;
    private String DEWP;
    private String SLP;
    private String STP;
    private String VISIB;
    private String WDSP;
    private String MXSPD;
    private String GUST;
    private String MAX;
    private String MIN;
    private String PRCP;
    private String SNDP;
    private String FRSHTT;


    public DataModel(String items[]){
        if(items.length<21)
            throw new RuntimeException("数组长度不足");
        this.setSTN(items[0]);
        this.setWBAN(items[1]);
        this.setYEARMODA(items[2]);
        this.setTEMP(items[3]);
        this.setDEWP(items[5]);
        this.setSLP(items[7]);
        this.setSTP(items[9]);
        this.setVISIB(items[11]);
        this.setWDSP(items[13]);
        this.setMXSPD(items[15]);
        this.setGUST(items[16]);
        this.setMAX(items[17]);
        this.setMIN(items[18]);
        this.setPRCP(items[19]);
        this.setSNDP(items[20]);
        this.setFRSHTT(items[21]);
    }
}
