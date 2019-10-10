package by.course.framework.model;

public class CalculatorLocationAndUsageData {

    private String dataCenterLocation;
    private String commitedUsage;

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    @Override
    public String toString() {
        return "CalculatorLocationAndUsageData{" +
                "dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }
}
