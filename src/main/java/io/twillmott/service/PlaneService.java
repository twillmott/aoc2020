package io.twillmott.service;

public class PlaneService {

    public static int findSeatId(String seatCode) {
        String row = seatCode.substring(0, 7).replace("F", "0").replace("B", "1");
        String column = seatCode.substring(7, 10).replace("L", "0").replace("R", "1");

        int rowInt = Integer.parseInt(row, 2);
        int columnInt = Integer.parseInt(column, 2);
        int id = (rowInt * 8) + columnInt;
//        System.out.println("Row: " + rowInt + " Column: " + columnInt + " ID: " + id);
        return id;
    }
}
