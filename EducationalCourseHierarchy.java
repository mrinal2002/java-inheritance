// Base class: Course
class Course {
    protected String courseName;
    protected int duration; // Duration in weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass: OnlineCourse extending Course
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // Discount in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalPrice() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + getFinalPrice());
    }
}

// Main class to test the hierarchy
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        // Basic Course
        Course course = new Course("Java Programming", 8);
        course.displayCourseDetails();
        System.out.println();

        // Online Course
        OnlineCourse onlineCourse = new OnlineCourse("Python for Data Science", 6, "Udemy", true);
        onlineCourse.displayCourseDetails();
        System.out.println();

        // Paid Online Course
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full Stack Web Development", 12, "Coursera", true, 500, 20);
        paidCourse.displayCourseDetails();
    }
}
