public class Student {

	private String name;
	private int studentID;
	private double gpa;
	private int credits;
	
	public Student(String firstName, String lastName, int studentID){
		this.name = firstName + " " + lastName;
		this.studentID = studentID;
		this.gpa = 0.0;
		this.credits = 0;
	}
	
	public Student(String firstName, String lastName, int studentID, double gpa, int credits){
		this.name = firstName + " " + lastName;
		this.studentID = studentID;
		this.gpa = gpa;
		this.credits = credits;
	}
		
	public String getName(){
		return name;
	}
	
	public int getStudentID(){
		return studentID;
	}
	
	public double getGPA(){
		return gpa;
	}
	
	public int getCredits(){
		return credits;
	}
	
	public String getClassStanding(){
		if(this.credits < 30){
			return "Freshman";
		}
		else if(this.credits >= 30 && this.credits < 60){
			return "Sophomore";
		}
		else if(this.credits >= 60 && this.credits < 90){
			return "Junior";
		}
		else {
			return "Senior";
		}
		
	}
	
	public void submitGrade(double grade, int credits){
		double qualityScore = grade * credits;
		double scoreSubtotal = this.gpa * this.credits;
		this.credits += credits;
		scoreSubtotal += qualityScore;
		double newGPA = scoreSubtotal/this.credits;
		this.gpa = (double) Math.round(newGPA * 1000.0) / 1000.0;
	}
	
	public double computeTuition(){
		int semesters = this.credits / 15;
		int leftoverCredits = this.credits % 15;
		return semesters * 20000.0 + leftoverCredits * 1333.33;
	}
	
	public Student createLegacy(Student studentOne, Student studentTwo){
		return new Student(studentOne.getName(), studentTwo.getName(), 
				studentOne.getStudentID()+studentTwo.getStudentID(),
				(studentOne.getGPA() + studentTwo.getGPA())/2,
				Math.max(studentOne.getCredits(), studentTwo.getCredits()));
	}
	
	public String toString(){
		return this.getName() + "'s Student ID is " + this.getStudentID();
	}
	
}