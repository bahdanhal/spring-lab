package com.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.lab.triangle.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/request")
public class RequestController {
        @RequestMapping(method = RequestMethod.POST)
        public String addTriangle (ModelMap model, @RequestParam(value = "firstSide", required = true,
            defaultValue = "0") String firstSide,
        @RequestParam(value = "secondSide", required = true,
                defaultValue = "0") String secondSide,
        @RequestParam(value = "thirdSide", required = true,
        defaultValue = "0") String thirdSide) {
                Logger log = LogManager.getLogger(RequestController.class);
                double min;
                double mid;
                double max;
                try {
                        min = Double.parseDouble(firstSide);
                        mid = Double.parseDouble(secondSide);
                        max = Double.parseDouble(thirdSide);
                } catch (NumberFormatException e){
                        log.info("HTTP 400 Bad data");
                        model.addAttribute("error", "<br/>Bad request");
                        return "Request";
                }
                Triangle triangle = new Triangle(min, mid, max);
                model.addAttribute("impossible", "Impossible:" + Triangle.getImpossible());
                model.addAttribute("equilateral", "Equilateral:" + Triangle.getEquilateral());
                model.addAttribute("isosceles", "Isosceles:" + Triangle.getIsosceles());
                model.addAttribute("rectangular", "Rectangular:" + Triangle.getRectangular());
                log.trace("HTTP 100 Continue");
                return "Request";
        }

        @RequestMapping(method = RequestMethod.GET)
        public String addTriangle () {
                Logger log = LogManager.getLogger(RequestController.class);
                log.info("HTTP 100 Continue");
                return "Request";
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity handlerSameControllerExceptions(){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
    