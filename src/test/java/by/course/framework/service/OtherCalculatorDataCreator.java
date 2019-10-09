package by.course.framework.service;

import by.course.framework.model.OtherCalculatorData;

public class OtherCalculatorDataCreator {

    private static final String TESTDATA_OTHER_SOFTWARE = "testdata.other.software";
    private static final String TESTDATA_OTHER_SSD = "testdata.other.ssd";
    private static final String TESTDATA_OTHER_LOCATION = "testdata.other.location";
    private static final String TESTDATA_OTHER_COMMITED_USAGE = "testdata.other.commited.usage";
    private OtherCalculatorData otherCalculatorData;

    public static OtherCalculatorDataCreator create() {
        return new OtherCalculatorDataCreator();
    }

    public OtherCalculatorDataCreator withSoftware() {
        otherCalculatorData.setOperationSystemAndSoftware(TestDataReader.getTestData(TESTDATA_OTHER_SOFTWARE));
        return this;
    }

    public OtherCalculatorDataCreator withSsd() {
        otherCalculatorData.setLocalSSD(TestDataReader.getTestData(TESTDATA_OTHER_SSD));
        return this;
    }

    public OtherCalculatorDataCreator withLocation() {
        otherCalculatorData.setDataCenterLocation(TestDataReader.getTestData(TESTDATA_OTHER_LOCATION));
        return this;
    }

    public OtherCalculatorDataCreator withCommitedUsage() {
        otherCalculatorData.setCommitedUsage(TestDataReader.getTestData(TESTDATA_OTHER_COMMITED_USAGE));
        return this;
    }

    public OtherCalculatorData build() {
        return otherCalculatorData;
    }

    private OtherCalculatorDataCreator() {
        throw new AssertionError("Cannot be instantiated directly.");
    }
}