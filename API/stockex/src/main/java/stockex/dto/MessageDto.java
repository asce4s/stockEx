package stockex.dto;


public class MessageDto {
    private String function,symbol,timeFrame;

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    @Override
    public String toString() {
        return "MessageDto{" +
                "function='" + function + '\'' +
                ", symbol='" + symbol + '\'' +
                ", timeFrame='" + timeFrame + '\'' +
                '}';
    }
}
