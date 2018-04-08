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


    private CalculatorModel calculatorModel;
    public CalculateTrip(CalculatorModel calculatorModel) throws ParseException {
        this.calculatorModel = calculatorModel;
        description();
        totalTripTime();
        dishes();
        diet(dietCost, freeFoodCost);
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

    private void travelCosts() throws ParseException {
        //<900 1km = 0.52
        //>900 1km = 0,84
        //motocykl 1km = 0,23
        //motorower 1km = 0,14
    }

    private void accommodation() throws ParseException {

    }

    private void localCommunication() throws ParseException {

    }

    private void otherExpenses() throws ParseException {

    }

    private void score() throws ParseException{

    }

}