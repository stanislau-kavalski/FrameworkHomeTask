package by.course.framework.service;

import by.course.framework.model.CalculatorSoftwareAndSsdData;

public class CalculatorSoftwareAndSsdDataCreator {

    private static final String TESTDATA_SOFTWARE = "testdata.software";
    private static final String TESTDATA_SSD = "testdata.ssd";
    private CalculatorSoftwareAndSsdData softwareAndSsdData = new CalculatorSoftwareAndSsdData();

    public static CalculatorSoftwareAndSsdDataCreator create() {
        return new CalculatorSoftwareAndSsdDataCreator();
    }

    public CalculatorSoftwareAndSsdDataCreator withSoftware() {
        softwareAndSsdData.setOperationSystemAndSoftware(CalculatorTestDataReader.getTestData(TESTDATA_SOFTWARE));
        return this;
    }

    public CalculatorSoftwareAndSsdDataCreator withSsd() {
        softwareAndSsdData.setLocalSSD(CalculatorTestDataReader.getTestData(TESTDATA_SSD));
        return this;
    }

    public CalculatorSoftwareAndSsdData build() {
        return softwareAndSsdData;
    }
}