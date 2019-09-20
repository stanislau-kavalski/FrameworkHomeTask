package by.course.framework.model;

public class MachineData {

    private String machineClass;
    private String machineType;

    public MachineData(String machineClass, String machineType) {
        this.machineClass = machineClass;
        this.machineType = machineType;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    @Override
    public String toString() {
        return "MachineData{" +
                "machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                '}';
    }
}
