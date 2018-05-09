package com.philspelman.springbootninjagold.controllers;


import com.philspelman.springbootninjagold.SpringBootNinjaGoldApplication;
import com.philspelman.springbootninjagold.models.Location;
import com.philspelman.springbootninjagold.models.NinjaActivity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.philspelman.springbootninjagold.SpringBootNinjaGoldApplication.*;

@Controller
public class MainController {


    @GetMapping(value = "/")
    public String index(Model model, HttpSession session) {
        System.out.println("Reached the ninja gold Index router");

        //todo: initiate the activity log!
//        session.removeAttribute("activityLog");
        if ( session.getAttribute("activityLog") == null ){
            System.out.println("setting session attributes");
            session.setAttribute("activityLog", new ArrayList<NinjaActivity>());
            session.setAttribute("total_gold", 0);
        }


        model.addAttribute("titleMessage", "Ninja Gold Welcome");

        session.setAttribute("locations", SpringBootNinjaGoldApplication.locations);


        return "index";
    }


    @PostMapping(value = "/activity")
    public String activity(HttpSession session, Model model,
                           @RequestParam(value = "location") String location) {

        System.out.println("Reached the activity POST method...determining stuff");

        session.setAttribute("brokeMessage", "");

        //DONE: extract the parameters
        System.out.println("location: " + location);

        //set the outcome default to "won"
        String outcome = "won";

        //Get the CURRENT gold (need to add or subtract later)
        int currentGold = (int) session.getAttribute("total_gold");

        //get the activity log
        ArrayList<NinjaActivity> activities = (ArrayList<NinjaActivity>) session.getAttribute("activityLog");

        if (location.equals("farm")) {
            System.out.println("FARM was detected!");
            int moneyMade = farm.makeMoney();
            System.out.println("adding activity");

            //add to front of the activity list
            session.setAttribute("total_gold", currentGold + moneyMade);
            activities.add(0, new NinjaActivity(location, outcome, moneyMade));
            System.out.println("Money:" + moneyMade);
        }
        else if (location.equals("cave")) {
            System.out.println("CAVE was detected!");
            int moneyMade = cave.makeMoney();
            System.out.println("adding activity");

            session.setAttribute("total_gold", currentGold + moneyMade);
            //add to front of the activity list
            activities.add(0, new NinjaActivity(location, outcome, moneyMade));
            System.out.println("Money:" + moneyMade);


        }
        else if (location.equals("house")) {
            System.out.println("HOUSE was detected!");
            int moneyMade = house.makeMoney();
            System.out.println("adding activity");

            session.setAttribute("total_gold", currentGold + moneyMade);

            //add to front of the activity list
            activities.add(0, new NinjaActivity(location, outcome, moneyMade));
            System.out.println("Money:" + moneyMade);


        }
        else if (location.equals("casino")) {
            System.out.println("CASINO was detected!");
            //FIXME: need to logic to gamble up to the amount the player has
            int moneyMade;
            if (currentGold != 0) {
                if (currentGold >= 50) {
                    //if player has at least the default max gambling value, play on
                    moneyMade = casino.makeMoney();
                } else {
                    moneyMade = casino.makeMoney(0, currentGold);
                }

                //TODO: get the decision of WIN or LOSS

                if (Math.random() <= .7) {
                    outcome = "LOST";
                    session.setAttribute("total_gold", currentGold + (moneyMade * -1));
                } else {
                    session.setAttribute("total_gold", currentGold + moneyMade);
                }
                //add to front of the activity list
                activities.add(0, new NinjaActivity(location, outcome, moneyMade));
                System.out.println("Money:" + moneyMade);

            } else {
                System.out.println("No money! Ninja cannot gamble!");
//                model.addAttribute("brokeMessage", "Ninja may not gamble when broke! Go make some money!");
                session.setAttribute("brokeMessage", "Ninja may not gamble when broke! Go make some money!");
            }

        } else {
            System.out.println("nothing");
        }
        //get the location that was selected

        return "redirect:/";
//        return "index";
    }

}

