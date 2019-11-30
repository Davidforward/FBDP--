package popularitem;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class countDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //args = new String[]{"e:/input/inputflow","e:/output1"};

        Configuration conf = new Configuration();
        // 1 获取job对象
        Job job = Job.getInstance(conf );

        // 2 设置jar的路径
        job.setJarByClass(countDriver.class);

        // 3 关联mapper和reducer
        job.setMapperClass(countMapper.class);
        job.setReducerClass(countReduer.class);

        // 4 设置mapper输出的key和value类型
        job.setMapOutputKeyClass(longBean.class);
        job.setMapOutputValueClass(itemBean.class);

        // 5 设置最终输出的key和value类型
        job.setOutputKeyClass(itemBean.class);
        job.setOutputValueClass(LongWritable.class);

		job.setPartitionerClass(ProvincePartitioner.class);
//
		job.setNumReduceTasks(35);
//

        // 6 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 7 提交job
        boolean result = job.waitForCompletion(true);

        System.exit(result?0 :1);
    }
}
