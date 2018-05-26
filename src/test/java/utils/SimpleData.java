package utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SimpleData extends Data {
    private String firstValue;
    private String secondValue;

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    @JsonCreator
    public SimpleData() {}

    public SimpleData(String fileName) {
        super(fileName);
    }
}
