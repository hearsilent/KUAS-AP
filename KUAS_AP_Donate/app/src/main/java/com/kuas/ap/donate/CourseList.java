package com.kuas.ap.donate;

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
        this.Time = parseTime(Time);
//        if (!Time.equals(""))
//            if (Time.contains("A"))
//                this.Time = "A";
//            else if (Time.contains("M"))
//                this.Time = "M";
//            else if (Time.contains("B"))
//                this.Time = "B";
//            else
//            {
//                this.Time = Time.split("節")[1].replace(" ","");
//                this.Time = this.Time.substring(0,2) + ":" + this.Time.substring(2,7) + ":" + this.Time.substring(7);
//            }
    }

    private String parseTime(String Time)
    {
        if (Time.contains("M"))
            return "M";
        if (Time.contains("A"))
            return "A";
        if (Time.contains("B"))
            return "B";
        if (Time.contains("C"))
            return "C";

        if (Time.equals("第1節"))
            return "08:10 - 09:00";
        if (Time.equals("第2節"))
            return "09:10 - 10:00";
        if (Time.equals("第3節"))
            return "10:10 - 11:00";
        if (Time.equals("第4節"))
            return "11:10 - 12:00";
        if (Time.equals("第5節"))
            return "13:30 - 14:20";
        if (Time.equals("第6節"))
            return "14:30 - 15:20";
        if (Time.equals("第7節"))
            return "15:30 - 16:20";
        if (Time.equals("第8節"))
            return "16:30 - 17:20";
        if (Time.equals("第11節"))
            return "18:30 - 19:20";
        if (Time.equals("第12節"))
            return "19:25 - 20:15";
        if (Time.equals("第13節"))
            return "20:20 - 21:00";
        if (Time.equals("第14節"))
            return "21:15 - 22:05";
        return "";
    }
}