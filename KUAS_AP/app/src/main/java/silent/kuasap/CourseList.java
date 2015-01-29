package silent.kuasap;

public class CourseList {
    String ID;
    String Teacher;
    String Place;
    String Time;
    public CourseList(String ID, String Teacher, String Place, String Time)
    {
        this.ID = ID.replace(" ","");
        this.Teacher = Teacher.replace(" ","");
        this.Place = Place.replace(" ","");
        if (!Time.equals(""))
            if (Time.contains("A"))
                this.Time = "A";
            else if (Time.contains("M"))
                this.Time = "M";
            else if (Time.contains("B"))
                this.Time = "B";
            else
            {
                this.Time = Time.split("節")[1].replace(" ","");
                this.Time = this.Time.substring(0,2) + ":" + this.Time.substring(2,7) + ":" + this.Time.substring(7);
            }
    }
}