public class Patient{
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;
    private String phoneNumber;
    private String bloodGroup;

    public Patient(int id, String name, int birthYear, double height, double weight, String phoneNumber, String bloodGroup){
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        if(height < 0 || weight < 0){
            this.height = Math.abs(height);
            this.weight = Math.abs(weight);
        }
        else{
            this.height = height;
            this.weight = weight;
        }
    }

    public int getAge(int currentYear){
        if(currentYear < birthYear){
            return -1;
        }
        else {
            return currentYear-birthYear;
        }
    }

    public String getbloodGroup() {
        String[] validBloodGroups = {"A", "B", "AB", "O"};
        for (String group : validBloodGroups) {
            if (group.equals(bloodGroup)) {
                return bloodGroup;
            }
        }
        return "Error (Invalid bloodGroup)";
    }

    public String getphoneNumber() {
        if (!phoneNumber.matches("[0-9]+")) {
            return "Error (Invalid phone number)";
        }
        return phoneNumber;
    }

    public double getBMI(){
        if(weight > 0 && height > 0){
            double BMI = weight / Math.pow(height/100,2);
            return Double.parseDouble(String.format("%.2f", BMI));
        }  
        else{
            System.err.println("ERROR the BMI");
            return 0;
        }
    }

    public void displayDetails(int currentYear) { 
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + (getAge(currentYear) == -1 ? "Error (Invalid birth year)" :getAge(currentYear) > 120 ? getAge(currentYear)+" WOW you're old now,huh": getAge(currentYear)));
        System.out.println("Patient Height (cm): " + (height > 0 ? height : "Error (Invalid height)"));
        System.out.println("Patient Weight (kg): " + (weight > 0 ? weight : "Error (Invalid weight)"));
        System.out.println("Patient Blood Group: " + getbloodGroup());
        System.out.println("Patient Phone Number: " + getphoneNumber());
        System.out.println("Patient BMI: " + getBMI());
    }

    public static void main(String[] args) {
        int currentYear = 2024; 
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "098764", "A");
        patient.displayDetails(currentYear);
        Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0,"098764", "A");
        invalidPatient.displayDetails(currentYear); 
        Patient invalidPatien1t = new Patient(1003, "Joe Dohn", -5, 0, -147,"0876A4", "C");
        invalidPatien1t.displayDetails(currentYear); 
      }  
}
