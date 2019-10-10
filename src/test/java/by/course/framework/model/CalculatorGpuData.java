package by.course.framework.model;

public class CalculatorGpuData {

    private int numberOfGPU;
    private String gpuType;

    public int getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(int numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    @Override
    public String toString() {
        return "GpuData{" +
                "numberOfGPU=" + numberOfGPU +
                ", gpuType='" + gpuType + '\'' +
                '}';
    }
}
