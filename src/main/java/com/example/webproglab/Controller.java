package com.example.webproglab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    private ArrayList<Valuta> valutaRegister = new ArrayList<>();


    @GetMapping("/lastInn")
    public void lastInn() {
        Valuta USD = new Valuta("USD", 8.4);
        Valuta EUR = new Valuta("EUR", 10.1);
        valutaRegister.add(USD);
        valutaRegister.add(EUR);
    }

    @GetMapping("/kalkuler")
    public String kalkuler(Belop belop) {

        for(Valuta enValuta : valutaRegister) {
            if(enValuta.getType().equals(belop.getType())) {
                return belop.getVerdi() + " " + belop.getType() + " er " + enValuta.getKurs() * belop.getVerdi() + " NOK";
            }
        }
        return "Finner ikke kursen";
    }

}