/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package icyrain11;

import icyrain11.domain.AverageSpeedResult;
import icyrain11.domain.ETCData;
import icyrain11.function.CalculateAverageSpeed;
import icyrain11.sink.AverageSpeedResultSink;
import icyrain11.sink.ETCSink;
import icyrain11.source.ETCDataSource;
import org.apache.flink.api.connector.sink2.Sink;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Skeleton for a Flink DataStream Job.
 *
 * <p>For a tutorial how to write a Flink application, check the
 * tutorials and examples on the <a href="https://flink.apache.org">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class DataStreamJob {

    public static void main(String[] args) throws Exception {
        // Sets up the execution environment, which is the main entry point
        // to building Flink applications.
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //add data source
        DataStream<ETCData> etcDataDataStream = env.addSource(new ETCDataSource());
        //聚合分区
        SingleOutputStreamOperator<AverageSpeedResult> averageSpeedResultSingleOutputStreamOperator =
                etcDataDataStream.keyBy(ETCData::getVehicleId)
                        .map(new CalculateAverageSpeed());

        //分发数据
        averageSpeedResultSingleOutputStreamOperator.addSink(new AverageSpeedResultSink());
        // Execute program, beginning computation.
        env.execute("Vehicle Distance Job");
    }
}
