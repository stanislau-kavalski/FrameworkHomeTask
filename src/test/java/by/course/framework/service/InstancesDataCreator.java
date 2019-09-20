package by.course.framework.service;

import by.course.framework.model.InstancesData;

public class InstancesDataCreator {
    private static final String TESTDATA_INSTANCES_NUMBER = "testdata.instances.number";
    private static final String TESTDATA_INSTANCES_PURPOSE = "testdata.instances.purpose";

    public static InstancesData withCredentialsFromProperty() {
        return new InstancesData(TestDataReader.getTestData(TESTDATA_INSTANCES_NUMBER),
                TestDataReader.getTestData(TESTDATA_INSTANCES_PURPOSE));
    }
}
