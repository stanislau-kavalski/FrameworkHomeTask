package by.course.framework.model;

public class OtherData {
    private String operationSystemAndSoftware;
    private String localSSD;
    private String dataCenterLocation;
    private String commitedUsage;

    public OtherData(String operationSystemAndSoftware, String localSSD, String dataCenterLocation, String commitedUsage) {
        this.operationSystemAndSoftware = operationSystemAndSoftware;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.commitedUsage = commitedUsage;
    }

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
        return "OtherData{" +
                "operationSystemAndSoftware='" + operationSystemAndSoftware + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }
}
