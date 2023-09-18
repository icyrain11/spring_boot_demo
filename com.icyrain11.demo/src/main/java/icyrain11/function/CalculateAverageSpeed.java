package icyrain11.function;

import icyrain11.domain.AverageSpeedResult;
import icyrain11.domain.ETCData;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * @author icyrain11
 * @version 1.8
 */
public class CalculateAverageSpeed implements MapFunction<ETCData, AverageSpeedResult> {

    @Override
    public AverageSpeedResult map(ETCData etcData) throws Exception {
        //get data
        double distance = etcData.getDistance();
        long fromTimestamp = etcData.getFromTimestamp();
        long toTimestamp = etcData.getToTimestamp();
        long timestamp = toTimestamp - fromTimestamp;
        double averageSpeed = distance / timestamp;
        String vehicleId = etcData.getVehicleId();

        //map
        AverageSpeedResult averageSpeedResult = new AverageSpeedResult();
        averageSpeedResult.setAverageSpeed(averageSpeed);
        averageSpeedResult.setVehicleId(vehicleId);
        return averageSpeedResult;
    }
}
