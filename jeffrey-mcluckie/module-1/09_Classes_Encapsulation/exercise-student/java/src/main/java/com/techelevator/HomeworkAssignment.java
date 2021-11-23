package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return this.earnedMarks;
    }
    public int getPossibleMarks() {
        return this.possibleMarks;
    }
    public String getSubmitterName() {
        return this.submitterName;
    }
    public String getLetterGrade() {
        double gradeDouble = ((double)this.earnedMarks)/this.possibleMarks;
        if(gradeDouble * 100 >= 90.0){
            return "A";
        }
        else if(gradeDouble * 100 >= 80){
            return "B";
        }
        else if(gradeDouble * 100 >= 70){
            return "C";
        }
        else if(gradeDouble * 100 >= 60){
            return "D";
        }
        else return "F";
        }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }
}
