package com.practice.project_enrolment.entity;

public class Course {

  private int CourseID;
  private String Title;
  private int Credits;

  public Course(int courseID, String title, int credits) {
    CourseID = courseID;
    Title = title;
    Credits = credits;
  }

  public int getCourseID() {
    return CourseID;
  }

  public void setCourseID(int courseID) {
    CourseID = courseID;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public int getCredits() {
    return Credits;
  }

  public void setCredits(int credits) {
    Credits = credits;
  }
}
