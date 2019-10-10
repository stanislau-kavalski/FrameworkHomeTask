package by.course.framework.model;

public class CalculatorSoftwareAndSsdData {

    private String operationSystemAndSoftware;
    private String localSSD;

    public String getOperationSystemAndSoftware() {
        return operationSystemAndSoftware;
    }

    public void setOperationSystemAndSoftware(String operationSystemAndSoftware) {
        this.operationSystemAndSoftware = operationSystemAndSoftware;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    @Override
    public String toString() {
        return "OtherCalculatorData{" +
                "operationSystemAndSoftware='" + operationSystemAndSoftware + '\'' +
                ", localSSD='" + localSSD + '\'' +
                '}';
    }
}
