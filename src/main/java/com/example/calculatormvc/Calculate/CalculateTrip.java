package com.example.calculatormvc.Calculate;

import com.example.calculatormvc.model.CalculatorModel;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
@Getter@Setter
public class CalculateTrip {
    private String descript;
    private String leaveTime;
    private String arriveTime;
    private String totalTime;
    private Double dietCost;
    private String breakfastAmount;
    private String dinnerAmount;
    private String supperAmount;
    private Double freeFoodCost;
    private Double totalDietCost;
    private Double dietValue;
    private String transType;
    private Double ticketPrice;
    private Double ovCcm;
    private Double unCcm;
    private Double motorcycle;
    private Double motBicycle;
    private Double trvlCost;
    private String lumpSum;
    private Double sleepBill;
    private Double lump;
    private String pLumpSum;
    private Double returnPay;
    private Double pLump;
    private Double advance;
    private Double payment;
    private Double sumCosts;

    private CalculatorModel calculatorModel;
    public CalculateTrip(CalculatorModel calculatorModel) throws ParseException {
        this.calculatorModel = calculatorModel;
        description();
        totalTripTime();
        dishes();
        diet(dietCost, freeFoodCost);
        transportType();
        tcktPrice();
        travelCosts();
        accommodation();
        localCommunication();
        score(dietValue, ticketPrice, trvlCost, lump, sleepBill, pLump, returnPay);
    }

    private void description() throws ParseException {
        String descript;
        descript = calculatorModel.getDescr();

        this.descript = descript;
    }

    private void totalTripTime() throws ParseException {
        String totalTime;
        Double dietCost;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String start = calculatorModel.getLeaveDate() + " " + calculatorModel.getLeaveTime();
        String end = calculatorModel.getArriveDate() + " " + calculatorModel.getArriveTime();
        DateTime dStart = new DateTime(format.parse(start));
        DateTime dEnd = new DateTime(format.parse(end));
        totalTime = Days.daysBetween(dStart, dEnd).getDays() + "d ";
        totalTime += Hours.hoursBetween(dStart, dEnd).getHours() % 24 + "h ";
        totalTime += Minutes.minutesBetween(dStart, dEnd).getMinutes() % 60 + "m ";

        dietCost = Double.valueOf(Days.daysBetween(dStart, dEnd).getDays()) * Double.valueOf(calculatorModel.getPay()) +
                Double.valueOf(Hours.hoursBetween(dStart, dEnd).getHours() % 24 ) * (Double.valueOf(calculatorModel.getPay()) / 24) +
                Double.valueOf(Minutes.minutesBetween(dStart, dEnd).getMinutes() % 60) * ((Double.valueOf(calculatorModel.getPay()) / 24) / 60);

        this.leaveTime = start;
        this.arriveTime = end;
        this.totalTime = totalTime;
        this.dietCost = dietCost;
    }

    private void dishes() throws ParseException {
        String breakfastAmount;
        String dinnerAmount;
        String supperAmount;
        Double freeFoodCost;

        breakfastAmount = calculatorModel.getBreakfast();
        dinnerAmount = calculatorModel.getDinner();
        supperAmount = calculatorModel.getSupper();

        freeFoodCost = (Integer.parseInt(breakfastAmount) * 7.5) + (Integer.parseInt(dinnerAmount) * 15.0) +
                (Integer.parseInt(supperAmount) * 7.5);

        this.breakfastAmount = breakfastAmount;
        this.dinnerAmount = dinnerAmount;
        this.supperAmount = supperAmount;
        this.freeFoodCost = freeFoodCost;
    }

    private void diet(Double dietCost, Double freeFoodCost) throws ParseException {
        Double dietValue;
        dietValue = dietCost - freeFoodCost;

        this.dietValue = dietValue;
    }

    private void transportType() throws ParseException {
        String transType;
        transType = calculatorModel.getTransType();

        this.transType = transType;
    }

    private void tcktPrice() throws  ParseException {
        Double ticketPrice;
        ticketPrice = Double.valueOf(calculatorModel.getTicketPrice());

        this.ticketPrice = ticketPrice;
    }

    private void travelCosts() throws ParseException {
        //<900 1km = 0.52
        //>900 1km = 0,84
        //motocykl 1km = 0,23
        //motorower 1km = 0,14
        Double unCcm;
        Double ovCcm;
        Double motorcycle;
        Double motBicycle;
        Double trvlCost;

        unCcm = Double.valueOf(calculatorModel.getUnCcm());
        ovCcm = Double.valueOf(calculatorModel.getOvCcm());
        motorcycle = Double.valueOf(calculatorModel.getMotorcycle());
        motBicycle = Double.valueOf(calculatorModel.getMotBicycle());

        trvlCost = unCcm * 0.52 + ovCcm * 0.84 + motorcycle * 0.23 + motBicycle * 0.14;

        this.unCcm = unCcm;
        this.ovCcm = ovCcm;
        this.motorcycle = motorcycle;
        this.motBicycle = motBicycle;
        this.trvlCost = trvlCost;
    }

    private void accommodation() throws ParseException {
        String lumpSum;
        Double lump;
        Double sleepBill;

        lumpSum = calculatorModel.getLumpSum();
        lump = Integer.parseInt(lumpSum) * 45.0;
        sleepBill = Double.valueOf(calculatorModel.getSleepBill());

        this.lumpSum = lumpSum;
        this.sleepBill = sleepBill;
        this.lump = lump;
    }

    private void localCommunication() throws ParseException {
        String pLumpSum;
        Double pLump;
        Double returnPay;

        pLumpSum = calculatorModel.getpLumpSum();
        pLump = Integer.parseInt(pLumpSum) * 6.0;
        returnPay = Double.valueOf(calculatorModel.getReturnPay());

        this.pLumpSum = pLumpSum;
        this.pLump = pLump;
        this.returnPay = returnPay;

    }

    private void otherExpenses() throws ParseException {

    }

    private void score(Double dietValue, Double ticketPrice, Double trvlCost, Double lump, Double sleepBill,
                       Double pLump, Double returnPay) throws ParseException{
        Double sumCosts;
        Double advance;
        Double payment;

        sumCosts = dietValue + ticketPrice + trvlCost + lump + sleepBill + pLump + returnPay;
        advance = Double.valueOf(calculatorModel.getAdvance());
        payment = sumCosts - advance;

        this.sumCosts = sumCosts;
        this.payment = payment;
        this.advance = advance;
    }

}