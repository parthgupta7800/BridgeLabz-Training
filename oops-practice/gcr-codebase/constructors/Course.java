class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "BridgeLabz";
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
    }
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
    public static void main(String[] args) {
        Course c1 = new Course("Core Java", 8, 15000);
        Course c2 = new Course("Full Stack", 16, 35000);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("Solutions");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
