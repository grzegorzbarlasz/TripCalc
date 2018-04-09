package com.example.calculatormvc.controller;

import com.example.calculatormvc.Calculate.CalculateTrip;
import com.example.calculatormvc.model.CalculatorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showPage(Model model) {
       // model.addAttribute();
        return "redirect:/calculator";
    }

    @GetMapping("/calculator")
    public String calculatorGet(Model model) {
        model.addAttribute("calculator", new CalculatorModel());
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculatorPost(@ModelAttribute CalculatorModel CalculatorModel, Model model) throws ParseException {
        CalculateTrip calculateTrip = new CalculateTrip(CalculatorModel);
        Map<String, String> attributes = new HashMap<>();
        attributes.put("dscrp", calculateTrip.getDescript());
        attributes.put("leave", calculateTrip.getLeaveTime());
        attributes.put("arrive", calculateTrip.getArriveTime());
        attributes.put("total", calculateTrip.getTotalTime());
        attributes.put("diet", calculateTrip.getDietCost().toString());
        attributes.put("breakfast", calculateTrip.getBreakfastAmount());
        attributes.put("dinner", calculateTrip.getDinnerAmount());
        attributes.put("supper", calculateTrip.getSupperAmount());
        attributes.put("freeFood", calculateTrip.getFreeFoodCost().toString());
        attributes.put("totalDiet", calculateTrip.getDietValue().toString());
        attributes.put("trnsprtType", calculateTrip.getTransType());
        attributes.put("tcktPrice", calculateTrip.getTicketPrice().toString());
        attributes.put("underCcm", calculateTrip.getUnCcm().toString());
        attributes.put("overCcm", calculateTrip.getOvCcm().toString());
        attributes.put("motoCycle", calculateTrip.getMotorcycle().toString());
        attributes.put("motoBicycle", calculateTrip.getMotBicycle().toString());
        attributes.put("travelCost", calculateTrip.getTrvlCost().toString());
        attributes.put("lmpSum", calculateTrip.getLumpSum());
        attributes.put("lmp", calculateTrip.getLump().toString());
        attributes.put("billSleep", calculateTrip.getSleepBill().toString());
        attributes.put("pLmpSum", calculateTrip.getPLumpSum());
        attributes.put("pLmp", calculateTrip.getPLump().toString());
        attributes.put("rtrnPay", calculateTrip.getReturnPay().toString());
        attributes.put("costs", calculateTrip.getSumCosts().toString());
        attributes.put("advnc", calculateTrip.getAdvance().toString());
        attributes.put("paymnt", calculateTrip.getPayment().toString());
        model.addAllAttributes(attributes);
        return "result";

    }

}
