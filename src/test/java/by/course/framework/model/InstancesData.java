package by.course.framework.model;

public class InstancesData {

        private int numberOfInstances;
        private String forWhatInstance;

        public InstancesData(String numberOfInstances, String forWhatInstance) {
                this.numberOfInstances = Integer.parseInt(numberOfInstances);
                this.forWhatInstance = forWhatInstance;
        }

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
