
public class Course {

	private String nameOfClass;
	private int numOfCredits;
	private int numOfSeatsAvailable;
	private Student[] enrolledStudents;
	
	public Course(String nameOfClass, int numOfCredits, int numOfSeatsAvailable){
		this.nameOfClass = nameOfClass;
		this.numOfCredits = numOfCredits;
		this.numOfSeatsAvailable = numOfSeatsAvailable;
		this.enrolledStudents = new Student[numOfSeatsAvailable];
	}
	
	public String getName(){
		return this.nameOfClass;
	}
	
	public int getRemainingSeats(){
		return this.numOfSeatsAvailable;
	}
	
	public boolean addStudent(Student newStudent){
		if(this.numOfSeatsAvailable == 0){
			return false;
		}
		
		for(int i=0; i < enrolledStudents.length; i++){
			if(enrolledStudents[i] != null && enrolledStudents[i].getName() == newStudent.getName()){
				return false;
			}
		}
		enrolledStudents[enrolledStudents.length - this.numOfSeatsAvailable] = newStudent;
		this.numOfSeatsAvailable--;
		
		return true;
	}
	
	public double averageGPA(){
		double sum = 0.0;
		int numStudents = 0;
		for(int i=0; i < enrolledStudents.length; i++){
			if(enrolledStudents[i] != null){
				sum += enrolledStudents[i].getGPA();
				numStudents++;
			}
		}
		return sum/numStudents;
	}
	
	public String toString(){
		return this.nameOfClass + this.numOfCredits;
	}
}