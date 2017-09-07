package stockex.dto;



import java.io.Serializable;
import java.util.List;

public class ChartDto implements Serializable {

    private List<SeriesDto> values;

    private String symbol,timeFrame;

    public ChartDto(){}

    public ChartDto(List<SeriesDto> values) {
        this.values = values;
    }

    public List<SeriesDto> getValues() {
        return values;
    }

    public void setValues(List<SeriesDto> values) {
        this.values = values;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    //    @Override
//    public String toString() {
//        String series="";
//         for (SeriesDto s:values){
//             series+=s.toString();
//         }
//
//        System.out.println("{ \"values\" : ["+series+"]}");
//         return "{ \"values\" : ["+series+"]}";
//    }
}

