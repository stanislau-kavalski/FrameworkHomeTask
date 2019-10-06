package by.course.framework.service;

import by.course.framework.model.MachineData;

public class MachineDataCreator {

    private static final String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";

    public static MachineData withCredentialsFromProperty() {
        return new MachineData(TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE));
    }
}
