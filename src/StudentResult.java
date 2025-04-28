public class StudentResult {
    private String rollNo;
    private String name;
    private String gender;
    private String section;
    private String semester;
    private String contactNo;
    private String email;
    private int marks;
    public StudentResult(String rollNo, String name, String gender, String section, String semester, String contactNo, String email, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.gender = gender;
        this.section = section;
        this.semester = semester;
        this.contactNo = contactNo;
        this.email = email;
        this.marks = marks; }
    public String getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getSection() {
        return section;
    }
    public String getSemester() {
        return semester;
    }
    public String getContactNo() {
        return contactNo;
    }
    public String getEmail() {
        return email;   }
    public int getMarks() {
        return marks;  }   
}
