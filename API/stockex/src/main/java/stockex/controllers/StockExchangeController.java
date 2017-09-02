package stockex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class StockExchangeController {

    @MessageMapping("/send")
    @SendTo("/data/subscribe")
    public ResponseEntity<String> getData() throws Exception {
        Thread.sleep(1000);
        System.out.println("triggerd");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> xxx= restTemplate.getForEntity("https://www.alphavantage.co/query?function=SMA&symbol=MSFT&interval=1min&time_period=10&series_type=close&apikey=0ASQLZMP1Y4ISM63",String.class);

        System.out.println(xxx);
        return xxx;
    }
}
