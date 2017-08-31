package stockex.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class StockExchangeController {

    @MessageMapping("/send")
    @SendTo("/data/subscribe")
    public void getData() throws Exception {
        Thread.sleep(1000);
        System.out.println("triggerd");
    }
}
