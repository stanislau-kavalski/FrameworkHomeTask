package by.course.framework.service;

import by.course.framework.model.CalculatorLocationAndUsageData;

public class CalculatorLocationAndUsageDataCreator {

    private static final String TESTDATA_LOCATION = "testdata.location";
    private static final String TESTDATA_COMMITED_USAGE = "testdata.commited.usage";
    private CalculatorLocationAndUsageData locationAndUsageData = new CalculatorLocationAndUsageData();

    public static CalculatorLocationAndUsageDataCreator create() {
        return new CalculatorLocationAndUsageDataCreator();
    }

    public CalculatorLocationAndUsageDataCreator withLocation() {
        locationAndUsageData.setDataCenterLocation(TestDataReader.getTestData(TESTDATA_LOCATION));
        return this;
    }

    public CalculatorLocationAndUsageDataCreator withCommitedUsage() {
        locationAndUsageData.setCommitedUsage(TestDataReader.getTestData(TESTDATA_COMMITED_USAGE));
        return this;
    }

    public CalculatorLocationAndUsageData build() {
        return locationAndUsageData;
    }
}
