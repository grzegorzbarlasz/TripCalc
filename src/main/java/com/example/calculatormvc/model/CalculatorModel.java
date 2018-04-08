package com.example.calculatormvc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class CalculatorModel {

    private String descr;
    private String leaveDate;
    private String leaveTime;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSupper() {
        return supper;
    }

    public void setSupper(String supper) {
        this.supper = supper;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getOvCcm() {
        return ovCcm;
    }

    public void setOvCcm(String ovCcm) {
        this.ovCcm = ovCcm;
    }

    public String getUnCcm() {
        return unCcm;
    }

    public void setUnCcm(String unCcm) {
        this.unCcm = unCcm;
    }

    public String getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(String motorcycle) {
        this.motorcycle = motorcycle;
    }

    public String getMotBicycle() {
        return motBicycle;
    }

    public void setMotBicycle(String motBicycle) {
        this.motBicycle = motBicycle;
    }

    public String getLumpSum() {
        return lumpSum;
    }

    public void setLumpSum(String lumpSum) {
        this.lumpSum = lumpSum;
    }

    public String getSleepBill() {
        return sleepBill;
    }

    public void setSleepBill(String sleepBill) {
        this.sleepBill = sleepBill;
    }

    public String getpLumpSum() {
        return pLumpSum;
    }

    public void setpLumpSum(String pLumpSum) {
        this.pLumpSum = pLumpSum;
    }

    public String getReturnPay() {
        return returnPay;
    }

    public void setReturnPay(String returnPay) {
        this.returnPay = returnPay;
    }

    public List<String> getCosts() {
        return costs;
    }

    public void setCosts(List<String> costs) {
        this.costs = costs;
    }

    public List<String> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<String> amounts) {
        this.amounts = amounts;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    private String arriveDate;
    private String arriveTime;
    private String pay;
    private String breakfast;
    private String dinner;
    private String supper;
    private String transType;
    private String ticketPrice;
    private String ovCcm;
    private String unCcm;
    private String motorcycle;
    private String motBicycle;
    private String lumpSum;
    private String sleepBill;
    private String pLumpSum;
    private String returnPay;
    private List<String> costs;
    private List<String> amounts;
    private String advance;
}