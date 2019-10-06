package by.course.framework.service;

import by.course.framework.model.GpuData;

public class GpuDataCreator {

    private static final String TESTDATA_GPU_NUMBER = "testdata.gpu.number";
    private static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";

    public static GpuData withCredentialsFromProperty() {
        return new GpuData(TestDataReader.getTestData(TESTDATA_GPU_NUMBER),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE));
    }
}
