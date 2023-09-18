package icyrain11.sink;

import icyrain11.domain.AverageSpeedResult;
import icyrain11.domain.ETCData;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * @author icyrain11
 * @version 1.8
 */
public class AverageSpeedResultSink extends RichSinkFunction<AverageSpeedResult> {

    @Override
    public void invoke(AverageSpeedResult value, Context context) throws Exception {
        super.invoke(value, context);
        //分发数据给ETC
    }

    @Override
    public void close() throws Exception {
        super.close();
    }
}
