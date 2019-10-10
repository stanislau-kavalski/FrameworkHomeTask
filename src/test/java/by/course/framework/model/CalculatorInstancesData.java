package by.course.framework.model;

public class CalculatorInstancesData {

        private int numberOfInstances;
        private String forWhatInstance;

        public int getNumberOfInstances() {
                return numberOfInstances;
        }

        public void setNumberOfInstances(int numberOfInstances) {
                this.numberOfInstances = numberOfInstances;
        }

        public String getForWhatInstance() {
                return forWhatInstance;
        }

        public void setForWhatInstance(String forWhatInstance) {
                this.forWhatInstance = forWhatInstance;
        }

        @Override
        public String toString() {
                return "InstancesData{" +
                        "numberOfInstances=" + numberOfInstances +
                        ", forWhatInstance='" + forWhatInstance + '\'' +
                        '}';
        }
}
