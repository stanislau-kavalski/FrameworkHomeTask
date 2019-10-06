package by.course.framework.service;

import by.course.framework.model.OtherData;

public class OtherDataCreator {

    private static final String TESTDATA_OTHER_SOFTWARE = "testdata.other.software";
    private static final String TESTDATA_OTHER_SSD = "testdata.other.ssd";
    private static final String TESTDATA_OTHER_LOCATION = "testdata.other.location";
    private static final String TESTDATA_OTHER_COMMITED_USAGE = "testdata.other.commited.usage";

    public static OtherData withCredentialsFromProperty() {
        return new OtherData(TestDataReader.getTestData(TESTDATA_OTHER_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_OTHER_SSD),
                TestDataReader.getTestData(TESTDATA_OTHER_LOCATION),
                TestDataReader.getTestData(TESTDATA_OTHER_COMMITED_USAGE));
    }
}
