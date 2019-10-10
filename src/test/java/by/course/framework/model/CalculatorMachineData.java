package by.course.framework.model;

public class CalculatorMachineData {

    private String machineClass;
    private String machineType;

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
