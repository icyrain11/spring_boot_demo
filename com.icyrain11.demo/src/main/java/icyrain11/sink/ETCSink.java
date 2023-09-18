package icyrain11.sink;

import icyrain11.domain.ETCData;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

/**
 * 分发数据
 * @author icyrain11
 * @version 1.8
 */
public class ETCSink extends RichSinkFunction<ETCData> {

    @Override
    public void invoke(ETCData value, Context context) throws Exception {
        //push data to etc
        super.invoke(value, context);
    }

    @Override
    public void close() throws Exception {
        //close
        super.close();
    }

}
