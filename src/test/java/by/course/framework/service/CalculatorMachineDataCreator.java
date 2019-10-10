package by.course.framework.service;

import by.course.framework.model.CalculatorMachineData;

public class CalculatorMachineDataCreator {

    private static final String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    private CalculatorMachineData machineData = new CalculatorMachineData();

    public static CalculatorMachineDataCreator create() {
        return new CalculatorMachineDataCreator();
    }

    public CalculatorMachineDataCreator withMachineClass() {
        machineData.setMachineClass(CalculatorTestDataReader.getTestData(TESTDATA_MACHINE_CLASS));
        return this;
    }

    public CalculatorMachineDataCreator withMachineType() {
        machineData.setMachineType(CalculatorTestDataReader.getTestData(TESTDATA_MACHINE_TYPE));
        return this;
    }

    public CalculatorMachineData build() {
        return machineData;
    }
}
