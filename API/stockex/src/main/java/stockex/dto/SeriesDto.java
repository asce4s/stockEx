package stockex.dto;

import java.io.Serializable;

public class SeriesDto implements Serializable {

    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Double adjusted;

    public SeriesDto(){}

    public SeriesDto(String date, Double open, Double high, Double low, Double close, Double volume, Double adjusted) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjusted = adjusted;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(Double adjusted) {
        this.adjusted = adjusted;
    }

    //    @Override
//    public String toString() {
//        return "{" +
//                "\"date\":\"" + date + "\"" +
//                ",\"open\":" + open +
//                ",\"high\":" + high +
//                ",\"low\":" + low +
//                ",\"close\":" + close +
//                ",\"volume\":" + volume +
//                "},";
//    }
}
