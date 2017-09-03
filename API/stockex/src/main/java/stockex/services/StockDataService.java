package stockex.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import stockex.dto.ChartDto;
import stockex.dto.SeriesDto;
import stockex.utils.Constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
public class StockDataService {


    Logger logger = Logger.getLogger(StockDataService.class);
    @Autowired
    private SimpMessagingTemplate msgTemplate;

    @Async
    public void getData() throws Exception {
        logger.info("connected");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stockData= restTemplate.getForEntity("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=1min&apikey="+ Constants.API_KEY+"",String.class);
        logger.info(stockData.getStatusCode());

        if(stockData.getStatusCode().value()==200)
            emit(processData(stockData.getBody().toString()));
    }

    private void emit(ChartDto data) throws Exception{
        msgTemplate.convertAndSend("/data/subscribe",data);
        logger.info("Emited");
        //msgTemplate.send("/data/subscribe", MessageBuilder.withPayload(data.getBytes("UTF-8")).build());
    }

    private ChartDto processData(String data) throws Exception{
        ChartDto chartDto=new ChartDto();
        List<SeriesDto> series= new ArrayList<SeriesDto>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.readTree(data);

        assertNotNull(jsonData);

        JsonNode timeSeries=jsonData.get("Time Series (1min)");

        Iterator<Map.Entry<String, JsonNode>> nodes = timeSeries.fields();

        while (nodes.hasNext()) {
            Map.Entry<String, JsonNode> entry =  nodes.next();

            String date = entry.getKey();
            Double open = entry.getValue().get("1. open").asDouble();
            Double high =entry.getValue().get("2. high").asDouble();
            Double low = entry.getValue().get("3. low").asDouble();
            Double close = entry.getValue().get("4. close").asDouble();
            Double volume = entry.getValue().get("5. volume").asDouble();

            series.add(new SeriesDto(date,open,high,low,close,volume,close));
        }

        chartDto.setValues(series);
        return chartDto;


    }
}
