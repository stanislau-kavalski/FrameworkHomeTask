package by.course.framework.service;

import by.course.framework.model.CalculatorGpuData;

public class CalculatorGpuDataCreator {

    private static final String TESTDATA_GPU_NUMBER = "testdata.gpu.number";
    private static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    private CalculatorGpuData gpuData = new CalculatorGpuData();

    public static CalculatorGpuDataCreator create() {
        return new CalculatorGpuDataCreator();
    }

    public CalculatorGpuDataCreator withGpuNumber() {
        gpuData.setNumberOfGPU(Integer.parseInt(TestDataReader.getTestData(TESTDATA_GPU_NUMBER)));
        return this;
    }

    public CalculatorGpuDataCreator withGpuType() {
        gpuData.setGpuType(TestDataReader.getTestData(TESTDATA_GPU_TYPE));
        return this;
    }

    public CalculatorGpuData build() {
        return gpuData;
    }
}
