package stockex.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import stockex.dto.MessageDto;
import stockex.services.StockDataService;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class StockExchangeController {

    Logger logger = Logger.getLogger(StockExchangeController.class);

    @Autowired
    private SimpMessagingTemplate msgTemplate;

    @Autowired
    private StockDataService stockDataService;

    @SubscribeMapping("/data/subscribe")
    @MessageMapping("/message")
    @SendTo("/data/subscribe")
    public void getData(MessageDto msg) {
        logger.info(msg.toString());
        try {
            while(true){
            stockDataService.getData(msg);
            Thread.sleep(10000);
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }

    }






}
