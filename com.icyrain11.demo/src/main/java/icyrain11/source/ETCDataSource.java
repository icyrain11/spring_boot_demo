package icyrain11.source;

import icyrain11.domain.ETCData;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @author icyrain11
 * @version 1.8
 */
public class ETCDataSource implements SourceFunction<ETCData> {

    @Override
    public void run(SourceContext<ETCData> sourceContext) throws Exception {
        //TODO get ETC Data Source
    }

    @Override
    public void cancel() {

    }
}
