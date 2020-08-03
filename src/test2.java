public class test2 {
    public String dayOfTheWeek(int day, int month, int year) {//1972,1976...1971/1/1周四
        int[] ordinary={31,59,90,120,151,181,212,243,273,304,334};
        int[] spec={31,60,91,121,152,182,213,244,274,305,335};
        String[] weeks={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int COUNToFdAY=0;
        int countOfY=year-1971;
        int largeCir=countOfY/4;
        int leaveOfYear=countOfY%4;
        COUNToFdAY+=largeCir*1461;
        if (leaveOfYear==1){//闰年，1972,1976.。。
            if (month<=1){
                return weeks[((4+COUNToFdAY+day+1*365)%7)];
            }else {
                return weeks[((4+COUNToFdAY+spec[month-2]+day+1*365)%7)];
            }
        }else if (leaveOfYear==0){//1971,1975
            if (month<=1){
                return weeks[((4+COUNToFdAY+day)%7)];
            }else {
                return weeks[((4+COUNToFdAY+ordinary[month-2]+day)%7)];
            }
        }else if (leaveOfYear==2){//1973..
            if (month<=1){
                return weeks[((4+COUNToFdAY+day+731)%7)];
            }else {
                return weeks[((4+COUNToFdAY+ordinary[month-2]+day+731)%7)];
            }
        }else {//1974
            if (month<=1){
                return weeks[((4+COUNToFdAY+day+1096)%7)];
            }else {
                return weeks[((4+COUNToFdAY+ordinary[month-2]+day+1096)%7)];
            }
        }
    }
}
