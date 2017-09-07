package stockex.services;


import stockex.dto.MessageDto;

public interface StockDataService {

    public void getData(MessageDto msg) throws Exception ;
}
