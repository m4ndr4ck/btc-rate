package br.com.btcmoedas.rate.controllers;

import br.com.btcmoedas.rate.model.Rate;
import br.com.btcmoedas.rate.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/v1/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @CrossOrigin
    @RequestMapping(value="", method = RequestMethod.GET)
    public Rate getRate() {
        return rateService.getRate();
    }
}
