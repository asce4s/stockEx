package stockex.dto;



import java.io.Serializable;
import java.util.List;

public class ChartDto implements Serializable {

    private List<SeriesDto> values;

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

