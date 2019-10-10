package by.course.framework.service;

import by.course.framework.model.CalculatorInstancesData;

public class CalculatorInstancesDataCreator {

    private static final String TESTDATA_INSTANCES_NUMBER = "testdata.instances.number";
    private static final String TESTDATA_INSTANCES_PURPOSE = "testdata.instances.purpose";
    private static CalculatorInstancesData instancesData = new CalculatorInstancesData();

    public static CalculatorInstancesDataCreator create() {
        return new CalculatorInstancesDataCreator();
    }

    public CalculatorInstancesDataCreator withInstancesNumber() {
        instancesData.setNumberOfInstances(Integer.parseInt(TestDataReader.getTestData(TESTDATA_INSTANCES_NUMBER)));
        return this;
    }

    public CalculatorInstancesDataCreator withInstancesPurpose() {
        instancesData.setForWhatInstance(TestDataReader.getTestData(TESTDATA_INSTANCES_PURPOSE));
        return this;
    }

    public CalculatorInstancesData build() {
        return instancesData;
    }
}
