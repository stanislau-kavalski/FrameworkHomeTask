package by.course.framework.model;

public class GpuData {

    private int numberOfGPU;
    private String gpuType;

    public GpuData(String numberOfGPU, String gpuType) {
        this.numberOfGPU = Integer.parseInt(numberOfGPU);
        this.gpuType = gpuType;
    }

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
