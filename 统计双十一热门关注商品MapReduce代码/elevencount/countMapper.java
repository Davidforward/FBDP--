package elevencount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class countMapper extends Mapper<LongWritable, Text,itemBean,LongWritable> {

    //Text v=new Text();
    LongWritable v=new LongWritable();
    itemBean k=new itemBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //328862,406349,1280,2700,5476,11,11,0,0,1,四川
        //获取一行
        String line=value.toString();
        //分割，按\t分
        String[] fields=line.split(",");
        //封装对象
        long action=Long.parseLong(fields[7]);
        long focus=1;
        long item_it=Long.parseLong(fields[1]);
        String province=fields[10];
        k.setItem_id(item_it);
        k.setProvince(province);
        v.set(focus);

        //写出
        context.write(k,v);
    }
}
