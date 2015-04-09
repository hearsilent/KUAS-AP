package com.kuas.ap.donate;

public class LeaveList {
    String _Time;
    String _M, _1, _2, _3, _4, _A, _5, _6, _7, _8, _B, _11, _12, _13, _14;
    public LeaveList(String _Time, String _M, String _1, String _2, String _3, String _4, String _A, String _5, String _6, String _7, String _8, String _B, String _11, String _12, String _13, String _14)
    {
        this._Time = parseTime(_Time);
        this._M = parseType(_M);
        this._1 = parseType(_1);
        this._2 = parseType(_2);
        this._3 = parseType(_3);
        this._4 = parseType(_4);
        this._A = parseType(_A);
        this._5 = parseType(_5);
        this._6 = parseType(_6);
        this._7 = parseType(_7);
        this._8 = parseType(_8);
        this._B = parseType(_B);
        this._11 = parseType(_11);
        this._12 = parseType(_12);
        this._13 = parseType(_13);
        this._14 = parseType(_14);
    }

    private String parseTime(String time)
    {
        return time.substring(4);
    }

    private String parseType(String type)
    {
        if (type.contains("事"))
            return "事";
        else if (type.contains("曠"))
            return "曠";
        else if (type.contains("病"))
            return "病";
        else if (type.contains("公"))
            return "公";
        else if (type.contains("喪"))
            return "喪";
        else if (type.contains("產"))
            return "產";
        else
            return "　";
    }
}