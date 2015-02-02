package silent.kuasap;

public class BusList {
    String busId;
    String endStation;
    Integer reserveCount;
    Integer limitCount;
    String runDateTime;
    Integer isReserve;
    public BusList(String busId, String endStation, Integer reserveCount, Integer limitCount, String runDateTime, Integer isReserve)
    {
        this.busId = busId;
        this.endStation = endStation;
        this.reserveCount = reserveCount;
        this.limitCount = limitCount;
        this.runDateTime = runDateTime;
        this.isReserve = isReserve;
    }
}